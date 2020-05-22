package com.nlinnik.occ.interview.valuescore;

import junit.framework.TestCase;
import org.junit.Test;

public class ValueScoreFactoryTest extends TestCase {

    ValueScoreFactory subject = new ValueScoreFactory();

    @Test
    public void test_ALPHABET_ORDER_SUM() {
        assertTrue(subject.get(ValueScoreType.ALPHABET_ORDER_SUM).isPresent());
        assertTrue(subject.get(ValueScoreType.ALPHABET_ORDER_SUM).get() instanceof AlphabetOrderSum);
    }
}