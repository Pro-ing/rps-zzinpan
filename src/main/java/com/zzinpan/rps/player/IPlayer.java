package com.zzinpan.rps.player;

import com.zzinpan.rps.RpsType;

public interface IPlayer {

    public String getName();

    public IPlayer setRpsType( RpsType rpsType );
    public RpsType getRpsType();

}
