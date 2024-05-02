package com.zzinpan.rps;

import com.zzinpan.rps.player.Computer;
import com.zzinpan.rps.player.IPlayer;
import com.zzinpan.rps.player.User;
import com.zzinpan.rps.type.ResultType;
import com.zzinpan.rps.type.RpsType;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class RpsTest {

    @Test
    void addPlayer() {

        Rps rps = new Rps();

        // 사용자 추가
        User user1 = new User("찐빵");
        assertTrue( rps.addPlayer( user1 ) );

        // 같은 이름의 사용자는 추가 불가능
        User user2 = new User("찐빵");
        assertFalse( rps.addPlayer( user2 ) );

    }

    @Test
    void removePlayer() {

        Rps rps = new Rps();

        // 사용자 추가
        User user1 = new User("찐빵1");
        rps.addPlayer( user1 );

        // 사용자 삭제 - 성공
        assertTrue( rps.removePlayer( user1 ) );

        // 사용자 삭제 - 실패: 존재하지 않음
        assertFalse( rps.removePlayer( user1 ) );

    }

    @Test
    void getPlayerByName() {

        Rps rps = new Rps();

        // 사용자 추가
        rps.addPlayer( new User("찐빵") );

        // 플레이어 조회 가능
        assertInstanceOf( User.class, rps.getPlayerByName( "찐빵" ) );

        // 존재하지 않는 플레이어
        assertNull( rps.getPlayerByName( "아무개" ) );

    }

    @Test
    void evaluation() {

        Rps rps = new Rps();

        // 사용자 없이 평가
        assertEquals( rps.evaluation().size(), 0 );



        User user1 = new User("신비");
        rps.addPlayer( user1 );
        assertThrows( NullPointerException.class, rps::evaluation);

        user1.setRpsType(RpsType.ROCK);
        assertEquals( rps.evaluation().get(0).getResultType(), ResultType.DRAW );



        User user2 = new User("금비");
        rps.addPlayer( user2 );

        user2.setRpsType(RpsType.PAPER);
        IPlayer winner = Objects.requireNonNull(rps.evaluation().stream().filter((playerData) -> {

            return playerData.getResultType() == ResultType.WIN;

        }).findFirst().orElse(null)).getPlayer();
        assertEquals( winner, user2 );


    }

}
