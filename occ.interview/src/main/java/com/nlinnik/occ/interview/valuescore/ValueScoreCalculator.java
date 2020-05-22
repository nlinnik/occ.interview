package com.nlinnik.occ.interview.valuescore;

import java.math.BigDecimal;

public interface ValueScoreCalculator {

    /**
     * Calculates score for a given value
     * @param value
     * @param <T>
     * @return
     */
    <T> BigDecimal score(T value);

    /**
     * Calculates score implementation and multiplies by a given ratio
     * @param value
     * @param ratio
     * @param <T>
     * @return
     */
    default <T> BigDecimal score(T value, BigDecimal ratio) {

        return score(value).multiply(ratio);
    }
}
