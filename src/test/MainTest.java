package src.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import src.main.rps.Rps;
import src.main.rps.player.Computer;
import src.main.rps.player.User;

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
