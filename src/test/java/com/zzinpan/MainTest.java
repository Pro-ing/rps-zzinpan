package com.zzinpan;

import com.zzinpan.rps.Rps;
import com.zzinpan.rps.data.PlayerData;
import com.zzinpan.rps.type.ResultType;
import com.zzinpan.rps.type.RpsType;
import com.zzinpan.rps.player.Computer;
import com.zzinpan.rps.player.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTest {

    @Test
    void evaluation() {

        Rps rps = new Rps();

        // 컴퓨터 추가
        Computer.SetName("컴퓨터-");
        List<Computer> computers = new ArrayList<>(Arrays.asList(
                new Computer(),
                new Computer(),
                new Computer()
        ));
        computers.forEach(rps::addPlayer);

        // 사용자 추가
        User user = new User("찐빵");
        rps.addPlayer( user );

        // 바위
        user.setRpsType( RpsType.ROCK );

        // 컴퓨터 ??
        computers.forEach(Computer::setRpsType);

        // 결과
        rps.evaluation().forEach(System.out::println);

    }

    @Test
    void multipleEvaluationForOnePlayer() {

        Rps rps = new Rps();

        // 컴퓨터 추가
        Computer.SetName("컴퓨터-");
        List<Computer> computers = new ArrayList<>(Arrays.asList(
                new Computer(),
                new Computer(),
                new Computer()
        ));
        computers.forEach(rps::addPlayer);

        // 사용자 추가
        User user = new User("찐빵");
        rps.addPlayer( user );

        // 바위
        user.setRpsType( RpsType.ROCK );

        int gameCount = 1;
        while(true) {

            // 컴퓨터 ??
            computers.forEach(Computer::setRpsType);

            // 결과
            List<PlayerData> playerDataItems = rps.evaluation();

            System.out.println("게임-" + gameCount);
            long winnerCounts = playerDataItems.stream().filter(( playerData ) -> {
                System.out.println( playerData );
                return playerData.getResultType() == ResultType.WIN;
            }).count();

            // 승자가 한명이면 게임 끝
            if( winnerCounts == 1 ){
                break;
            }

            // 잔사람 제외
            playerDataItems.forEach(( playerData ) -> {

                if( playerData.getResultType() != ResultType.LOSE ){
                    return;
                }

                rps.removePlayer( playerData.getPlayer() );

            });

            System.out.println();
            gameCount = gameCount + 1;

        }



    }

}
