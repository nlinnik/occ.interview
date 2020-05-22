package com.nlinnik.occ.interview.valuescore;

import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;

public class AlphabetOrderSumTest extends TestCase {

    ValueScoreCalculator subject = new AlphabetOrderSum();

    @Test
    public void test_LINDA_SCORE_40() {
        assertEquals(new BigDecimal("40"), subject.score("LINDA"));
    }

    @Test
    public void test_LINDA_SCORE_160_RATIO_4() {
        assertEquals(new BigDecimal("160"), subject.score("LINDA", new BigDecimal("4")));
    }

}