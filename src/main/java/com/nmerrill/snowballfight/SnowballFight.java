package com.nmerrill.snowballfight;

import com.nmerrill.kothcomm.game.games.AbstractGame;
import com.nmerrill.kothcomm.game.scoring.Scoreboard;

public class SnowballFight extends AbstractGame<Player> {


    private int maxSnowballs, maxDucks, turnNumber;

    private int[] snowballs;
    private int[] ducks;
    private int winner = -1;
    @Override
    protected void setup() {
        snowballs = new int[2];
        ducks = new int[2];
        maxSnowballs = 50;
        maxDucks = 25;
        for (int i = 0; i < 2; i++){
            snowballs[i] = 0;
            ducks[i] = maxDucks;
        }
        turnNumber = 0;
    }

    @Override
    protected void step() {
        Move[] moves = new Move[2];
        for (int i = 0; i < 2; i++){
            moves[i] = players.get(i).turn(turnNumber, snowballs[i], snowballs[1-i], ducks[i], ducks[1-i], maxSnowballs);
        }
        for (int i = 0; i < 2; i++){
            if (moves[i] == Move.Throw){
                if (snowballs[i] > 0){
                    snowballs[i]--;
                    if (moves[1-i] == Move.Reload){
                        winner = i;
                    }
                }
            }
            if (moves[i] == Move.Reload){
                snowballs[i] ++;
            }
        }
        turnNumber++;
    }

    @Override
    public Scoreboard<Player> getScores() {
        Scoreboard<Player> s = new Scoreboard<>();
        for (int i = 0; i < 2; i++){
            if (winner == i){
                s.addScore(players.get(i), 1);
            } else {
                s.addScore(players.get(i), 0);
            }
        }
        return s;
    }

    @Override
    public boolean finished() {
        return winner == -1;
    }
}
