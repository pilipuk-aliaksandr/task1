package by.pilipuk.inno.service.calculator.impl;

import by.pilipuk.inno.entity.CustomIntArray;
import by.pilipuk.inno.service.calculator.CustomArrayCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class IntArrayCalculatorImplTest {

    private static final CustomIntArray baseArray = new CustomIntArray(new int[] {1, 2, 3, -4});
    private static final CustomIntArray emptyArray = new CustomIntArray(new int[0]);

    private static final CustomArrayCalculator<Integer, CustomIntArray> calculator = new IntArrayCalculatorImpl();

    @Test
    @DisplayName("Find minimum value from basic custom array")
    void findMinValueBasic() {
        var expectedMinValue = Optional.of(-4);
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
        var expectedMaxValue = Optional.of(3);
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
        var expectedSumValue = Optional.of(2);
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