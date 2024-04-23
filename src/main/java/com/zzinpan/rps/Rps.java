package com.zzinpan.rps;

import com.zzinpan.rps.data.PlayerData;
import com.zzinpan.rps.player.IPlayer;
import com.zzinpan.rps.type.ResultType;
import com.zzinpan.rps.type.RpsType;

import java.util.ArrayList;
import java.util.List;

public class Rps implements IRps {

    private final List<IPlayer> players;

    public Rps() {

        this.players = new ArrayList<>();

    }

    public boolean addPlayer( IPlayer player ) {

        IPlayer addedPlayer = this.getPlayerByName( player.getName() );
        if( addedPlayer != null ){
            return false;
        }
        this.players.add( player );
        return true;

    }

    public boolean removePlayer( IPlayer player ) {

        return this.players.remove( player );

    }

    public IPlayer getPlayerByName( String name ) {

        return this.players.stream().filter(( player ) -> {
            return name.equals( player.getName() );
        }).findFirst().orElse(null);

    }

    public List<PlayerData> evaluation() {

        return this.players.stream().map(( me ) -> {

            List<RpsType> otherRpsTypes = this.players.stream().filter(( other ) -> {

                return me != other;

            }).map(( other ) -> {

                return other.getRpsType();

            }).toList();

            RpsType myRpsType = me.getRpsType();
            ResultType myResultType = me.getRpsType().evaluation( otherRpsTypes );
            return new PlayerData( me, myRpsType, myResultType );

        }).toList();

    }

}
