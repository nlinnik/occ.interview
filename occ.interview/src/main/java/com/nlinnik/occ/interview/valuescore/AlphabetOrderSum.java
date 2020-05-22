package com.nlinnik.occ.interview.valuescore;

import java.math.BigDecimal;

public class AlphabetOrderSum implements ValueScoreCalculator {

    @Override
    public <String> BigDecimal score(String value) {

        var score = 0;

        for (char letter : value.toString().toCharArray()) {
            score = score + Character.toLowerCase(letter) - 96;
        }
        return BigDecimal.valueOf(score);
    }
}