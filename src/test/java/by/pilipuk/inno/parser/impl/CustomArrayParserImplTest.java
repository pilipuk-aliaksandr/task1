package by.pilipuk.inno.parser.impl;

import by.pilipuk.inno.entity.CustomDoubleArray;
import by.pilipuk.inno.entity.CustomIntArray;
import by.pilipuk.inno.entity.base.BaseCustomArray;
import by.pilipuk.inno.parser.CustomArrayParser;
import by.pilipuk.inno.service.customArrayFactory.impl.DoubleArrayFactory;
import by.pilipuk.inno.service.customArrayFactory.impl.IntArrayFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CustomArrayParserImplTest {

    private static final CustomArrayParser parser = new CustomArrayParserImpl(
            new IntArrayFactory(),
            new DoubleArrayFactory()
    );

    private static final List<String> baseIntLine = List.of("1, 2, -3");
    private static final List<String> baseDoubleLine = List.of("1.0, 2.0, -3.0");
    private static final List<String> baseEmptyLine = List.of("1y1 2 3");
    private static final List<String> baseCommaSeparatedLine = List.of("1, 2, -3");
    private static final List<String> baseSemicolonSeparatedLine = List.of("1; 2; -3");
    private static final List<String> baseDashSeparatedLine = List.of("1 - 2 - -3");

    @Test
    @DisplayName("Valid integer line is parsed into CustomIntArray")
    void parseLinesProducesIntArray() {
        // given
        List<BaseCustomArray> expectedCustomArray = List.of(new CustomIntArray(new int[] {1, 2, -3}));

        // when
        List<BaseCustomArray> actualCustomArray = parser.parseLines(baseIntLine);

        // then
        assertEquals(expectedCustomArray, actualCustomArray);
    }

    @Test
    @DisplayName("Valid double line is parsed into CustomDoubleArray")
    void parseLinesProducesDoubleArray() {
        // given
        List<BaseCustomArray> expectedCustomArray = List.of(new CustomDoubleArray(new double[] {1.0, 2.0, -3.0}));

        // when
        List<BaseCustomArray> actualCustomArray = parser.parseLines(baseDoubleLine);

        // then
        assertEquals(expectedCustomArray, actualCustomArray);
    }

    @Test
    @DisplayName("Comma-separated line is parsed correctly")
    void parseLinesWithCommaSeparatedLine() {
        // given
        List<BaseCustomArray> expectedCustomArray = List.of(new CustomIntArray(new int[] {1, 2, -3}));

        // when
        List<BaseCustomArray> actualCustomArray = parser.parseLines(baseCommaSeparatedLine);

        // then
        assertEquals(expectedCustomArray, actualCustomArray);
    }

    @Test
    @DisplayName("Semicolon-separated line is parsed correctly")
    void parseLinesWithSemicolonSeparatedLine() {
        // given
        List<BaseCustomArray> expectedCustomArray = List.of(new CustomIntArray(new int[] {1, 2, -3}));

        // when
        List<BaseCustomArray> actualCustomArray = parser.parseLines(baseSemicolonSeparatedLine);

        // then
        assertEquals(expectedCustomArray, actualCustomArray);
    }

    @Test
    @DisplayName("Dash-separated line is parsed correctly")
    void parseLinesWithDashSeparatedLine() {
        // given
        List<BaseCustomArray> expectedCustomArray = List.of(new CustomIntArray(new int[] {1, 2, -3}));

        // when
        List<BaseCustomArray> actualCustomArray = parser.parseLines(baseDashSeparatedLine);

        // then
        assertEquals(expectedCustomArray, actualCustomArray);
    }

    @Test
    @DisplayName("Empty list of lines returns empty result")
    void parseLinesWithEmptyInput() {
        // given

        // when
        List<BaseCustomArray> actual = parser.parseLines(baseEmptyLine);

        // then
        assertTrue(actual.isEmpty());
    }
}