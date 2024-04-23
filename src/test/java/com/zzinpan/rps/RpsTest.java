package com.zzinpan.rps;

import com.zzinpan.rps.player.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RpsTest {

    @Test
    void addPlayer() {

        Rps rps = new Rps();

        // 사용자 추가
        User user1 = new User("찐빵");
        boolean user1AddResult = rps.addPlayer( user1 );
        assertTrue(user1AddResult);

        User user2 = new User("찐빵");
        boolean user2AddResult = rps.addPlayer( user2 );
        assertFalse(user2AddResult);

    }

}
