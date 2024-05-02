# rps-zzinpan
가위바위보 엔진

<br>

### Getting Started

```java
import com.zzinpan.rps.Rps;
import com.zzinpan.rps.data.PlayerData;
import com.zzinpan.rps.type.ResultType;
import com.zzinpan.rps.type.RpsType;
import com.zzinpan.rps.player.Computer;
import com.zzinpan.rps.player.User;

public class Main {

    public static void main( String... args ) {

        Rps rps = new Rps();

        // add cpu
        List<Computer> computers = new ArrayList<>(Arrays.asList(
                new Computer(),
                new Computer(),
                new Computer()
        ));
        computers.forEach(rps::addPlayer);

        // add user
        User user = new User("user");
        rps.addPlayer( user );

        // set user rps
        user.setRpsType( RpsType.ROCK );

        // set cpu rps
        computers.forEach(Computer::setRpsType);

        // result
        rps.evaluation().forEach(System.out::println);
        
    }
    
}
```