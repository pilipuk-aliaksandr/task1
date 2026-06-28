package by.pilipuk.inno.validator;

import by.pilipuk.inno.validator.impl.CustomArrayValidatorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomArrayValidatorImplTest {

    private static final CustomArrayValidator customArrayValidator = new CustomArrayValidatorImpl();

    @Test
    @DisplayName("Valid line to be converted into integer array")
    void isValidIntLineTrue() {
        // given
        String line = "1, 2, 3, -4";

        // when
        boolean expected = customArrayValidator.isValidLine(line);

        // then
        assertTrue(expected);
    }

    @Test
    @DisplayName("Invalid integer elements FAIL validation")
    void isValidIntLineFalse() {
        // given
        String line = "1, 2, 3, -4a";

        // when
        boolean expected = customArrayValidator.isValidLine(line);

        // then
        assertFalse(expected);
    }
}