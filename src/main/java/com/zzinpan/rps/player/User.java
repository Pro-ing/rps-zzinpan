package com.zzinpan.rps.player;

import com.zzinpan.rps.type.RpsType;

public class User implements IPlayer {

    private final String name;
    private RpsType rpsType = null;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public IPlayer setRpsType(RpsType rpsType) {
        this.rpsType = rpsType;
        return this;
    }

    @Override
    public RpsType getRpsType() {
        return this.rpsType;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
