package by.pilipuk.inno.service.calculator;

import by.pilipuk.inno.entity.base.BaseCustomArray;
import java.util.Optional;

public interface CustomArrayCalculator<T extends Number, A extends BaseCustomArray> {

    Optional<T> findMinValue(A array);

    Optional<T> findMaxValue(A array);

    Optional<T> calculateSumOfElements(A array);

    Optional<Double> calculateAverageOfElements(A array);
}