package by.pilipuk.inno.validator.impl;

import by.pilipuk.inno.validator.CustomArrayValidator;

public class CustomArrayValidatorImpl implements CustomArrayValidator {

    private static final String REGEXP_VALID_ELEMENT = "(-?\\d+(,\\s*)?)*";

    @Override
    public boolean isValidLine(String line) {
        return line.matches(REGEXP_VALID_ELEMENT);
    }
}
