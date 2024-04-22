package src.main.rps;

import src.main.rps.player.IPlayer;

import java.util.ArrayList;
import java.util.List;

public class Rps {

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

    public IPlayer getPlayerByName( String name ) {

        return this.players.stream().filter(( player ) -> {
            return name.equals( player.getName() );
        }).findFirst().orElse(null);

    }

}
