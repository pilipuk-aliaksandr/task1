package by.pilipuk.inno.service.calculator.impl;

import by.pilipuk.inno.entity.CustomArray;
import by.pilipuk.inno.service.calculator.CustomArrayCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class CustomArrayCalculatorImplTest {

    private static final CustomArray baseArray = new CustomArray(new int[] {1, 2, 3, -4});
    private static final CustomArray emptyArray = new CustomArray(new int[0]);

    private static final CustomArrayCalculator calculator = new CustomArrayCalculatorImpl();

    @Test
    @DisplayName("Find minimum value from basic custom array")
    void findMinValueBasic() {
        // given
        var expectedMinValue = Optional.of(-4);

        // when
        var actualMinValue = calculator.findMinValue(baseArray);

        //then
        assertEquals(expectedMinValue, actualMinValue);
    }

    @Test
    @DisplayName("Find minimum value from empty custom array")
    void findMinValueEmpty() {
        // given
        var expectedMinValue = Optional.empty();

        // when
        var actualMinValue = calculator.findMinValue(emptyArray);

        //then
        assertEquals(expectedMinValue, actualMinValue);
    }

    @Test
    @DisplayName("Find maximum value from basic custom array")
    void findMaxValueBasic() {
        // given
        var expectedMaxValue = Optional.of(3);

        // when
        var actualMaxValue = calculator.findMaxValue(baseArray);

        //then
        assertEquals(expectedMaxValue, actualMaxValue);
    }

    @Test
    @DisplayName("Find maximum value from empty custom array")
    void findMaxValueEmpty() {
        // given
        var expectedMaxValue = Optional.empty();

        // when
        var actualMaxValue = calculator.findMaxValue(emptyArray);

        //then
        assertEquals(expectedMaxValue, actualMaxValue);

    }

    @Test
    @DisplayName("Find sum of all elements from basic custom array")
    void calculateSumOfElementsBasic() {
        // given
        var expectedSumValue = Optional.of(2);

        // when
        var actualSumValue = calculator.calculateSumOfElements(baseArray);

        //then
        assertEquals(expectedSumValue, actualSumValue);

    }

    @Test
    @DisplayName("Find sum of all elements from empty custom array")
    void calculateSumOfElementsEmpty() {
        // given
        var expectedSumValue = Optional.empty();

        // when
        var actualSumValue = calculator.calculateSumOfElements(emptyArray);

        //then
        assertEquals(expectedSumValue, actualSumValue);
    }

    @Test
    @DisplayName("Find average value of all elements from basic custom array")
    void calculateAverageOfElementsBasic() {
        // given
        var expectedAvgValue = Optional.of(0.5);

        // when
        var actualAvgValue = calculator.calculateAverageOfElements(baseArray);

        //then
        assertEquals(expectedAvgValue, actualAvgValue);
    }

    @Test
    @DisplayName("Find average value of all elements from empty custom array")
    void calculateAverageOfElementsEmpty() {
        // given
        var expectedAvgValue = Optional.empty();

        // when
        var actualAvgValue = calculator.calculateAverageOfElements(emptyArray);

        //then
        assertEquals(expectedAvgValue, actualAvgValue);
    }
}
