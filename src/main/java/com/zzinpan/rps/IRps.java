package com.zzinpan.rps;

import com.zzinpan.rps.data.PlayerData;
import com.zzinpan.rps.player.IPlayer;

import java.util.List;

public interface IRps {

    public boolean addPlayer( IPlayer player );

    public List<PlayerData> evaluation();

}
