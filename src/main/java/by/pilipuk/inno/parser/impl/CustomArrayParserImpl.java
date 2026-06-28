package by.pilipuk.inno.parser.impl;

import by.pilipuk.inno.exception.CustomArrayException;
import by.pilipuk.inno.parser.CustomArrayParser;
import by.pilipuk.inno.validator.CustomArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayParserImpl implements CustomArrayParser {

    private static final Logger logger = LogManager.getLogger(CustomArrayParserImpl.class);
    private static final String REGEXP_DELIMITER = ",\\s*";

    private final CustomArrayValidator customArrayValidator;

    public CustomArrayParserImpl(CustomArrayValidator customArrayValidator) {
        this.customArrayValidator = customArrayValidator;
    }

    @Override
    public int[] parseLine(String line)  throws CustomArrayException {
        if (line.isBlank()) {
            logger.log(Level.DEBUG, "The line {} is valid to be converted to empty CustomArray", line);
            return new int[0];

        } else if (customArrayValidator.isValidLine(line)) {
            logger.log(Level.DEBUG, "The line {} is valid to be converted to CustomArray", line);

            String[] stringArray = line.trim().split(REGEXP_DELIMITER);
            int n = stringArray.length;

            int[] intArray = new int[n];
            for (int i = 0; i < n; i++) {
                intArray[i] = Integer.parseInt(stringArray[i]);
            }

            return intArray;

        } else {
            logger.log(Level.DEBUG, "The line {} ISN'T VALID to be converted to CustomArray", line);
            throw new CustomArrayException("The line " + line + " ISN'T VALID to be converted to CustomArray");
        }
    }
}