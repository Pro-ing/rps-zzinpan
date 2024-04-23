package com.zzinpan.rps.player;

import com.zzinpan.rps.RpsType;

public class Computer implements IPlayer {

    private static String Name = "Computer-";
    private static Integer Sequence = 1;

    private final String name;
    private RpsType rpsType = null;

    public static void SetName( String name ) {
        Computer.Name = name;
    }

    public Computer() {
        this.name = Computer.Name + Computer.Sequence;
        Computer.Sequence = Computer.Sequence + 1;
    }

    @Override
    public String getName() {
        return this.name;
    }


    @Override
    public IPlayer setRpsType(RpsType rpsType) {
        double random = Math.random();
        if( random < 0.3333 ){
            this.rpsType = RpsType.ROCK;
            return this;
        }

        if( random < 0.6666 ){
            this.rpsType = RpsType.PAPER;
            return this;
        }

        this.rpsType = RpsType.SCISSORS;
        return this;
    }

    @Override
    public RpsType getRpsType() {
        return this.rpsType;
    }
}
