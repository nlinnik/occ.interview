package com.nlinnik.occ.interview.utils;

import com.nlinnik.occ.interview.valuescore.ValueScoreCalculator;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUtils {

    /**
     * Converts Stream into Map where key is steam value and value is calculated value score by passed ValueScoreCalculator implementation
     * @param inputStream
     * @param valueScoreCalculator
     * @return
     */
    public static Map<String, BigDecimal> sortMapCalculateScore(Stream<String> inputStream, ValueScoreCalculator valueScoreCalculator) {

        int[] pos = {1};
        var map = new TreeMap<String, BigDecimal>();
        inputStream.sorted().collect(Collectors.toList()).forEach(value -> map.put(value, valueScoreCalculator.score(value, BigDecimal.valueOf(pos[0]++))));

        return map;
    }

    /**
     * Sums up all values in a given map
     * @param map
     * @return
     */
    public static BigDecimal reduceSum(Map<String, BigDecimal> map) {
        return map.values().parallelStream().reduce(BigDecimal::add).get();
    }
}
