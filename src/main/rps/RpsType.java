package src.main.rps;

public enum RpsType {

    ROCK( ResultType.DRAW, ResultType.LOSE, ResultType.WIN ),
    PAPER( ResultType.WIN, ResultType.DRAW, ResultType.LOSE ),
    SCISSORS( ResultType.LOSE, ResultType.WIN, ResultType.DRAW );

    private ResultType vsRockResult;
    private ResultType vsPaperResult;
    private ResultType vsScissors;

    private RpsType(ResultType vsRockResult, ResultType vsPaperResult, ResultType vsScissors) {

        this.vsRockResult = vsRockResult;
        this.vsPaperResult = vsPaperResult;
        this.vsScissors = vsScissors;

    }



}
