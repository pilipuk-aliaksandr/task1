package by.pilipuk.inno.service.calculator.impl;

import by.pilipuk.inno.entity.CustomIntArray;
import by.pilipuk.inno.service.calculator.CustomIntArrayCalculator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Optional;

public class IntArrayCalculatorImpl implements CustomIntArrayCalculator {

    private static final Logger logger = LogManager.getLogger(IntArrayCalculatorImpl.class);

    @Override
    public Optional<Integer> findMinValue(CustomIntArray array) {
        if (array.isEmpty()) {
            logger.log(Level.DEBUG, "The min value from array {} didn't find, because this custom array is empty!", array);
            return Optional.empty();
        }
        int[] tempArr = array.getArr();
        int min = tempArr[0];
        for (int i = 1; i < tempArr.length; i++) {
            if (tempArr[i] < min) {
                min = tempArr[i];
            }
        }
        logger.log(Level.DEBUG, "The min value from array {} is {}!", array, min);
        return Optional.of(min);
    }

    @Override
    public Optional<Integer> findMaxValue(CustomIntArray array) {
        if (array.isEmpty()) {
            logger.log(Level.DEBUG, "The max value from array {} didn't find, because this custom array is empty!", array);
            return Optional.empty();
        }
        int[] tempArr = array.getArr();
        int max = tempArr[0];
        for (int i = 1; i < tempArr.length; i++) {
            if (tempArr[i] > max) {
                max = tempArr[i];
            }
        }
        logger.log(Level.DEBUG, "The max value from array {} is {}!", array, max);
        return Optional.of(max);
    }

    @Override
    public Optional<Integer> calculateSumOfElements(CustomIntArray array) {
        if (array.isEmpty()) {
            logger.log(Level.DEBUG, "The sum of elements from array {} didn't find, because this custom array is empty!", array);
            return Optional.empty();
        }
        int[] tempArr = array.getArr();
        int sum = 0;
        for (int j : tempArr) {
            sum += j;
        }
        logger.log(Level.DEBUG, "The sum of elements from array {} is {}!", array, sum);
        return Optional.of(sum);
    }

    @Override
    public Optional<Double> calculateAverageOfElements(CustomIntArray array) {
        if (array.isEmpty()) {
            logger.log(Level.DEBUG, "The average value of elements from array {} didn't find, because this custom array is empty!", array);
            return Optional.empty();
        }
        int[] tempArr = array.getArr();
        long sum = 0;
        for (int j : tempArr) {
            sum += j;
        }
        double avg = (double) sum / tempArr.length;
        logger.log(Level.DEBUG, "The average value of elements from array {} is {}!", array, avg);
        return Optional.of(avg);
    }
}