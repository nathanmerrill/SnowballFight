package com.nmerrill.snowballfight;

import com.nmerrill.kothcomm.game.players.AbstractPlayer;

public abstract class Player extends AbstractPlayer<Player> {

    public abstract Move turn(int turnNumber, int snowballs, int opponent_snowballs, int ducks, int opponent_ducks, int max_snowballs);
}
