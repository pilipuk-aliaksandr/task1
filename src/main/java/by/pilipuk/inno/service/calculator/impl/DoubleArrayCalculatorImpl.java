package by.pilipuk.inno.service.calculator.impl;

import by.pilipuk.inno.entity.CustomDoubleArray;
import by.pilipuk.inno.service.calculator.CustomDoubleArrayCalculator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Optional;

public class DoubleArrayCalculatorImpl implements CustomDoubleArrayCalculator {

    private static final Logger logger = LogManager.getLogger(DoubleArrayCalculatorImpl.class);

    @Override
    public Optional<Double> findMinValue(CustomDoubleArray array) {
        if (array.isEmpty()) {
            logger.log(Level.DEBUG, "The min value from array {} didn't find, because this custom array is empty!", array);
            return Optional.empty();
        }
        double[] tempArr = array.getArr();
        double min = tempArr[0];
        for (int i = 1; i < tempArr.length; i++) {
            if (tempArr[i] < min) {
                min = tempArr[i];
            }
        }
        logger.log(Level.DEBUG, "The min value from array {} is {}!", array, min);
        return Optional.of(min);
    }

    @Override
    public Optional<Double> findMaxValue(CustomDoubleArray array) {
        if (array.isEmpty()) {
            logger.log(Level.DEBUG, "The max value from array {} didn't find, because this custom array is empty!", array);
            return Optional.empty();
        }
        double[] tempArr = array.getArr();
        double max = tempArr[0];
        for (int i = 1; i < tempArr.length; i++) {
            if (tempArr[i] > max) {
                max = tempArr[i];
            }
        }
        logger.log(Level.DEBUG, "The max value from array {} is {}!", array, max);
        return Optional.of(max);
    }

    @Override
    public Optional<Double> calculateSumOfElements(CustomDoubleArray array) {
        if (array.isEmpty()) {
            logger.log(Level.DEBUG, "The sum of elements from array {} didn't find, because this custom array is empty!", array);
            return Optional.empty();
        }
        double[] tempArr = array.getArr();
        double sum = 0;
        for (double j : tempArr) {
            sum += j;
        }
        logger.log(Level.DEBUG, "The sum of elements from array {} is {}!", array, sum);
        return Optional.of(sum);
    }

    @Override
    public Optional<Double> calculateAverageOfElements(CustomDoubleArray array) {
        if (array.isEmpty()) {
            logger.log(Level.DEBUG, "The average value of elements from array {} didn't find, because this custom array is empty!", array);
            return Optional.empty();
        }
        double[] tempArr = array.getArr();
        double sum = 0;
        for (double j : tempArr) {
            sum += j;
        }
        double avg = sum / tempArr.length;
        logger.log(Level.DEBUG, "The average value of elements from array {} is {}!", array, avg);
        return Optional.of(avg);
    }
}