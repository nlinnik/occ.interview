package com.nlinnik.occ.interview.utils;

import com.nlinnik.occ.interview.valuescore.AlphabetOrderSum;
import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Stream;

public class StreamUtilsTest extends TestCase {

    private static final String inputString = "\"MARY\",\"PATRICIA\",\"LINDA\",\"BARBARA\",\"VINCENZO\",\"SHON\",\"LYNWOOD\",\"JERE\",\"HAI\"";

    @Test
    public void testSortMapCalculateScore() {
        Stream<String> inputStream = Stream.of(inputString.replace("\"", "").split(","));

        String expectedResult = "{BARBARA=43, HAI=36, JERE=114, LINDA=160, LYNWOOD=540, MARY=342, PATRICIA=539, SHON=448, VINCENZO=972}";
        assertEquals(expectedResult, StreamUtils.sortMapCalculateScore(inputStream, new AlphabetOrderSum()).toString());

    }

    @Test
    public void testReduceSum() {
        Stream<String> inputStream = Stream.of(inputString.replace("\"", "").split(","));
        Map<String, BigDecimal> map = StreamUtils.sortMapCalculateScore(inputStream, new AlphabetOrderSum());
        assertEquals(new BigDecimal("3194"), StreamUtils.reduceSum(map));
    }
}