package by.pilipuk.inno.parser.impl;

import by.pilipuk.inno.exception.CustomArrayException;
import by.pilipuk.inno.parser.CustomArrayParser;
import by.pilipuk.inno.validator.impl.CustomArrayValidatorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomArrayParserImplTest {

    private static final CustomArrayParser parser = new CustomArrayParserImpl(new CustomArrayValidatorImpl());

    private static final String baseIntLine = "1, 2, -3";
    private static final String baseEmptyLine = "";

    @Test
    @DisplayName("Valid integer line is parsed into Integer Array")
    void parseLineProducesIntArray() throws CustomArrayException {
        // given
        int[] expectedIntegerArray = new int[] {1, 2, -3};

        // when
        int[] actualIntegerArray = parser.parseLine(baseIntLine);

        // then
        assertArrayEquals(expectedIntegerArray, actualIntegerArray);
    }

    @Test
    @DisplayName("Empty list of lines returns empty result")
    void parseLinesWithEmptyInput() throws CustomArrayException {
        // given

        // when
        int[] actual = parser.parseLine(baseEmptyLine);

        // then
        assertTrue(actual.length == 0);
    }
}