package by.pilipuk.inno.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomArrayValidatorTest {

    @Test
    @DisplayName("Valid integer elements PASS validation")
    void isValidIntLineTrue() {
        // given
        String[] intLine = new String[] {"1", "2", "3", "-4"};

        // when
        boolean expected = CustomArrayValidator.isValidLine(intLine);

        // then
        assertTrue(expected);
    }

    @Test
    @DisplayName("Valid integer elements FAIL validation")
    void isValidIntLineFalse() {
        // given
        String[] intLine = new String[] {"1", "2", "3", "-4a"};

        // when
        boolean expected = CustomArrayValidator.isValidLine(intLine);

        // then
        assertFalse(expected);
    }

    @Test
    @DisplayName("Valid double elements PASS validation")
    void isValidDoubleLineTrue() {
        // given
        String[] doubleLine = new String[] {"1.0", "2.0", "3.0", "-4.00"};

        // when
        boolean expected = CustomArrayValidator.isValidLine(doubleLine);

        // then
        assertTrue(expected);
    }

    @Test
    @DisplayName("Valid double elements FAIL validation")
    void isValidDoubleLineFalse() {
        // given
        String[] doubleLine = new String[] {"1.0", "2.0", "3.00", "-4.0a"};

        // when
        boolean expected = CustomArrayValidator.isValidLine(doubleLine);

        // then
        assertFalse(expected);
    }

    @Test
    @DisplayName("Array elements include double values")
    void isDoubleTrue() {
        // given
        String[] doubleLine = new String[] {"1", "2", "3", "-4.0"};

        // when
        boolean expected = CustomArrayValidator.isDouble(doubleLine);

        // then
        assertTrue(expected);
    }

    @Test
    @DisplayName("Array elements DOESN'T include double values")
    void isDoubleFalse() {
        // given
        String[] incorrectDoubleLine = new String[] {"1", "2", "3", "-4"};

        // when
        boolean expected = CustomArrayValidator.isDouble(incorrectDoubleLine);

        // then
        assertFalse(expected);
    }
}