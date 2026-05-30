package by.pilipuk.inno.service.calculator.impl;

import by.pilipuk.inno.entity.CustomDoubleArray;
import by.pilipuk.inno.service.calculator.CustomArrayCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DoubleArrayCalculatorImplTest {

    private static final CustomDoubleArray baseArray = new CustomDoubleArray(new double[] {1.0, 2.0, 3.0, -4.0});
    private static final CustomDoubleArray emptyArray = new CustomDoubleArray(new double[0]);

    private static final CustomArrayCalculator<Double, CustomDoubleArray> calculator = new DoubleArrayCalculatorImpl();

    @Test
    @DisplayName("Find minimum value from basic custom array")
    void findMinValueBasic() {
        var expectedMinValue = Optional.of(-4.0);
        var actualMinValue = calculator.findMinValue(baseArray);
        assertEquals(expectedMinValue, actualMinValue);
    }

    @Test
    @DisplayName("Find minimum value from empty custom array")
    void findMinValueEmpty() {
        var expectedMinValue = Optional.empty();
        var actualMinValue = calculator.findMinValue(emptyArray);
        assertEquals(expectedMinValue, actualMinValue);
    }

    @Test
    @DisplayName("Find maximum value from basic custom array")
    void findMaxValueBasic() {
        var expectedMaxValue = Optional.of(3.0);
        var actualMaxValue = calculator.findMaxValue(baseArray);
        assertEquals(expectedMaxValue, actualMaxValue);
    }

    @Test
    @DisplayName("Find maximum value from empty custom array")
    void findMaxValueEmpty() {
        var expectedMaxValue = Optional.empty();
        var actualMaxValue = calculator.findMaxValue(emptyArray);
        assertEquals(expectedMaxValue, actualMaxValue);

    }

    @Test
    @DisplayName("Find sum of all elements from basic custom array")
    void calculateSumOfElementsBasic() {
        var expectedSumValue = Optional.of(2.0);
        var actualSumValue = calculator.calculateSumOfElements(baseArray);
        assertEquals(expectedSumValue, actualSumValue);

    }

    @Test
    @DisplayName("Find sum of all elements from empty custom array")
    void calculateSumOfElementsEmpty() {
        var expectedSumValue = Optional.empty();
        var actualSumValue = calculator.calculateSumOfElements(emptyArray);
        assertEquals(expectedSumValue, actualSumValue);
    }

    @Test
    @DisplayName("Find average value of all elements from basic custom array")
    void calculateAverageOfElementsBasic() {
        var expectedAvgValue = Optional.of(0.5);
        var actualAvgValue = calculator.calculateAverageOfElements(baseArray);
        assertEquals(expectedAvgValue, actualAvgValue);
    }

    @Test
    @DisplayName("Find average value of all elements from empty custom array")
    void calculateAverageOfElementsEmpty() {
        var expectedAvgValue = Optional.empty();
        var actualAvgValue = calculator.calculateAverageOfElements(emptyArray);
        assertEquals(expectedAvgValue, actualAvgValue);
    }
}