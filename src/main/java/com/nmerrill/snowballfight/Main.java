package com.nmerrill.snowballfight;

import com.nmerrill.kothcomm.communication.languages.other.OtherLoader;
import com.nmerrill.kothcomm.game.KotHComm;

public class Main {
    public static void main(String[] args){
        KotHComm<Player, SnowballFight> kotHComm = new KotHComm<>(SnowballFight::new);
        kotHComm.addLanguage(new OtherLoader<>(CrosslangPlayer::new));
        kotHComm.run(args);
    }
}
