package com.zzinpan.rps;

import com.zzinpan.rps.data.PlayerData;
import com.zzinpan.rps.player.IPlayer;
import com.zzinpan.rps.type.ResultType;
import com.zzinpan.rps.type.RpsType;

import java.util.ArrayList;
import java.util.List;

/**
 * 가위바위보 게임 모듈입니다.
 *
 * @author zzinpan
 * @version 1.0.0
 * @since 1.0.0
 */
public class Rps implements IRps {

    /**
     * 가위바위보에 참여하고 있는 플레이어 목록입니다.
     * @version 1.0.0
     * @since 1.0.0
     */
    private final List<IPlayer> players;

    /**
     * 객체 기본 생성자 입니다.<br><br>
     * <b>Example</b><br>
     * {@code
     * 	IRps rps = new Rps();
     * }
     *
     * @author dss456@sehyunict.com
     * @version 1.0.0
     * @since 1.0.0
     */
    public Rps() {

        this.players = new ArrayList<>();

    }

    /**
     * 게임에 참여할 플레이어를 추가합니다.<br><br>
     * <b>Example</b><br>
     * {@code
     *  IPlayer player = new User("나");
     *
     *  // addResult1: true
     * 	boolean addResult1 = rps.addPlayer( player );
     *
     * 	// addResult2: false
     *  boolean addResult2 = rps.addPlayer( player );
     * }
     * @param player 게임에 참여할 플레이어 입니다.
     * @return 플레이어 추가 성공여부를 반환합니다.<br>이미 추가된 경우, <b>false</b>가 반환됩니다.
     * @author zzinpan
     * @version 1.0.0
     * @since 1.0.0
     */
    public boolean addPlayer( IPlayer player ) {

        IPlayer addedPlayer = this.getPlayerByName( player.getName() );
        if( addedPlayer != null ){
            return false;
        }
        this.players.add( player );
        return true;

    }

    /**
     * 이미 참여중인 플레이어를 게임에서 제외합니다.<br><br>
     * <b>Example</b><br>
     * {@code
     *  IPlayer player = new User("나");
     *
     * 	rps.addPlayer( player );
     *
     * 	// removeResult1: true
     * 	boolean removeResult1 = rps.removePlayer( player );
     *
     * 	// removeResult2: false
     * 	boolean removeResult2 = rps.removePlayer( player );
     * }
     * @param player 게임에 제외할 플레이어 입니다.
     * @return 플레이어 제외 성공여부를 반환합니다.<br>플레이어가 참여중이지 않은 경우, <b>false</b>가 반환됩니다.
     * @author zzinpan
     * @version 1.0.0
     * @since 1.0.0
     */
    public boolean removePlayer( IPlayer player ) {

        return this.players.remove( player );

    }

    /**
     * 플레이어를 이름으로 조회합니다.<br><br>
     * <b>Example</b><br>
     * {@code
     *  IPlayer player = new User("나");
     *  rps.addPlayer( player );
     *
     *  // me == player
     * 	IPlayer me = rps.getPlayerByName( "나" );
     *
     *  // you == null
     * 	IPlayer you = rps.getPlayerByName( "너" );
     * }
     * @param name 조회하고 싶은 플레이어의 이름 입니다.
     * @return 이름에 해당되는 플레이어가 반환됩니다.<br>해당되는 플레이어가 없는 경우, <b>null</b>이 반환됩니다.
     * @author zzinpan
     * @version 1.0.0
     * @since 1.0.0
     */
    public IPlayer getPlayerByName( String name ) {

        return this.players.stream().filter(( player ) -> {
            return name.equals( player.getName() );
        }).findFirst().orElse(null);

    }

    /**
     * 게임을 평가합니다.<br><br>
     * <b>Example</b><br>
     * {@code
     *  IPlayer me = new User("나");
     *  rps.addPlayer( me );
     *
     *  IPlayer you = new User("너");
     *  rps.addPlayer( you );
     *
     *  // me: 주먹
     *  player.setRpsType( RpsType.ROCK );
     *
     *  // you: 가위
     *  player.setRpsType( RpsType.SCISSORS );
     *
     *  // 평가
     *  List<PlayerData> report = rps.evaluation();
     * }
     * @return 플레이어 데이터를 반환합니다.<br>데이터의 항목들은 각각 "어떤 플레이어(me)가 어떤 종류(RpsType.ROCK)를 내서 어떤 결과(ResultType.WIN)가 나왔다." 를 의미 합니다.
     * @author zzinpan
     * @version 1.0.0
     * @since 1.0.0
     */
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
