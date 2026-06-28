package by.pilipuk.inno.service.calculator;

import by.pilipuk.inno.entity.CustomArray;
import java.util.Optional;

public interface CustomArrayCalculator {

    Optional<Integer> findMinValue(CustomArray array);

    Optional<Integer> findMaxValue(CustomArray array);

    Optional<Integer> calculateSumOfElements(CustomArray array);

    Optional<Double> calculateAverageOfElements(CustomArray array);
}