package com.zzinpan.rps.type;

import com.zzinpan.rps.function.Evaluator;

import java.util.List;

public class RpsType {

    public static RpsType ROCK = new RpsType("바위", ( rpsTypes ) -> {

        boolean everyRock = rpsTypes.stream().allMatch(( rpsType ) -> {
            return rpsType == RpsType.ROCK;
        });

        if( everyRock ) {
            return ResultType.DRAW;
        }


        boolean hasPaper = rpsTypes.contains( RpsType.PAPER );
        boolean hasScissors = rpsTypes.contains( RpsType.SCISSORS );

        if( hasPaper && hasScissors ) {
            return ResultType.DRAW;
        }

        if( hasPaper ) {
            return ResultType.LOSE;
        }

        return ResultType.WIN;
    });

    public static RpsType PAPER = new RpsType("보", ( rpsTypes ) -> {

        boolean everyPaper = rpsTypes.stream().allMatch(( rpsType ) -> {
            return rpsType == RpsType.PAPER;
        });

        if( everyPaper ) {
            return ResultType.DRAW;
        }


        boolean hasRock = rpsTypes.contains( RpsType.ROCK );
        boolean hasScissors = rpsTypes.contains( RpsType.SCISSORS );

        if( hasRock && hasScissors ) {
            return ResultType.DRAW;
        }

        if( hasScissors ) {
            return ResultType.LOSE;
        }

        return ResultType.WIN;
    });

    public static RpsType SCISSORS = new RpsType("가위", ( rpsTypes ) -> {

        boolean everyScissors = rpsTypes.stream().allMatch(( rpsType ) -> {
            return rpsType == RpsType.SCISSORS;
        });

        if( everyScissors ) {
            return ResultType.DRAW;
        }


        boolean hasRock = rpsTypes.contains( RpsType.ROCK );
        boolean hasPaper = rpsTypes.contains( RpsType.PAPER );

        if( hasRock && hasPaper ) {
            return ResultType.DRAW;
        }

        if( hasRock ) {
            return ResultType.LOSE;
        }

        return ResultType.WIN;
    });

    private final String name;
    private final Evaluator evaluator;

    private RpsType(String name, Evaluator evaluator) {
        this.name = name;
        this.evaluator = evaluator;
    }

    public ResultType evaluation(List<RpsType> rpsTypes) {
        return this.evaluator.evaluate( rpsTypes );
    }

    @Override
    public String toString() {
        return "RpsType{" +
                "name='" + name + '\'' +
                '}';
    }
}
