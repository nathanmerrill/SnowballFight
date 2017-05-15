package com.nmerrill.snowballfight;

import com.nmerrill.kothcomm.communication.languages.other.PipeCommunicator;

import java.util.Random;

public class CrosslangPlayer extends Player {
    private final PipeCommunicator pipeCommunicator;

    public CrosslangPlayer(PipeCommunicator pipeCommunicator){
        this.pipeCommunicator = pipeCommunicator;
    }

    public Move turn(int turnNumber, int snowballs, int opponent_snowballs, int ducks, int opponent_ducks, int max_snowballs){
        String response = pipeCommunicator.sendMessage(turnNumber+","+snowballs+","+opponent_snowballs+","+ducks+","+opponent_ducks+","+max_snowballs, "turn");
        return Move.values()[Integer.parseInt(response)];
    }

    @Override
    public void setRandom(Random random) {
        super.setRandom(random);
        pipeCommunicator.sendMessage(random.nextInt()+"", "RandomSeed");
    }
}
