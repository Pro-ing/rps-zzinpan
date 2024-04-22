package src.main.rps.player;

import src.main.rps.RpsType;

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

    @Override
    public IPlayer setRpsType(RpsType rpsType) {
        this.rpsType = rpsType;
        return this;
    }

    @Override
    public RpsType getRpsType() {
        return this.rpsType;
    }
}
