package com.zzinpan;

import com.zzinpan.rps.Rps;
import com.zzinpan.rps.player.Computer;
import com.zzinpan.rps.player.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTest {

    @DisplayName("main")
    @Test
    void main() {

        Rps rps = new Rps();

        // 컴퓨터 추가
        Computer.SetName("컴퓨터-");
        for( int i=0; i<2; ++i ){
            Computer computer = new Computer();
            rps.addPlayer( computer );
        }

        // 사용자 추가
        User user = new User("찐빵");
        rps.addPlayer( user );

    }

}
