package com.zzinpan.rps.function;

import com.zzinpan.rps.type.ResultType;
import com.zzinpan.rps.type.RpsType;

import java.util.List;

@FunctionalInterface
public interface Evaluator {
    ResultType evaluate(List<RpsType> rpsTypes);
}
