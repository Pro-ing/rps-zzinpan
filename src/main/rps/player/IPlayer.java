package src.main.rps.player;

import src.main.rps.RpsType;

public interface IPlayer {

    public String getName();

    public IPlayer setRpsType( RpsType rpsType );
    public RpsType getRpsType();

}
