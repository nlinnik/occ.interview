package com.nlinnik.occ.interview.valuescore;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ValueScoreFactory {
    //with Spring implementation could be injected from application config here or preferred way at constructor
    private final Map<ValueScoreType, ValueScoreCalculator> valueScores = new ConcurrentHashMap<>();

    public ValueScoreFactory() {
         valueScores.put(ValueScoreType.ALPHABET_ORDER_SUM, new AlphabetOrderSum());
    }

    public Optional<ValueScoreCalculator> get(ValueScoreType valueScoreType) {

        return Optional.of(valueScores.get(valueScoreType));

    }
}
