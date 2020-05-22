package com.nlinnik.occ.interview;

import com.nlinnik.occ.interview.utils.FileIOUtils;
import com.nlinnik.occ.interview.valuescore.ValueScoreCalculator;
import com.nlinnik.occ.interview.valuescore.ValueScoreFactory;
import com.nlinnik.occ.interview.valuescore.ValueScoreType;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static com.nlinnik.occ.interview.utils.StreamUtils.reduceSum;
import static com.nlinnik.occ.interview.utils.StreamUtils.sortMapCalculateScore;

public class NameScoreApplication {


    public static void main(String[] args) throws IOException {

        if (args.length < 1) {
            System.out.println("You would need to pass as 1st argument - a full path for file name");
            return;
        }

        Stream<String> inputStream = FileIOUtils.getByFilePath(args[0], ",", "\"");

        //get ValueScoreCalculator from a factory, additional calculators could be added later
        Supplier<ValueScoreFactory> valueScoreFactory = ValueScoreFactory::new;
        Optional<ValueScoreCalculator> valueScoreCalculator = valueScoreFactory.get().get(ValueScoreType.ALPHABET_ORDER_SUM);
        if (valueScoreCalculator.isEmpty()) {
            System.out.println(String.format("Value Score Calculator implementation for %s is not found", ValueScoreType.ALPHABET_ORDER_SUM));
            return;
        }

        // Sorts input stream values converts to a map with calculated score for each value
        Map<String, BigDecimal> map = sortMapCalculateScore(inputStream, valueScoreCalculator.get());
        // Calculates total score for all values scores
        BigDecimal totalScore = reduceSum(map);

        FileIOUtils.write(args[0] + String.format("_scored - %s", totalScore), map.toString());

        inputStream.close();
    }

}
