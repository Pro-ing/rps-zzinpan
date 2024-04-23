package com.zzinpan.rps.data;

import com.zzinpan.rps.type.ResultType;
import com.zzinpan.rps.type.RpsType;
import com.zzinpan.rps.player.IPlayer;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerData {

    private IPlayer player;
    private RpsType rpsType;
    private ResultType resultType;

}
