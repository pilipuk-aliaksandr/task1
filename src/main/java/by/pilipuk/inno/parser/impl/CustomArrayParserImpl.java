package by.pilipuk.inno.parser.impl;

import by.pilipuk.inno.entity.base.BaseCustomArray;
import by.pilipuk.inno.service.customArrayFactory.CustomArrayFactory;
import by.pilipuk.inno.parser.CustomArrayParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static by.pilipuk.inno.validator.CustomArrayValidator.isDouble;
import static by.pilipuk.inno.validator.CustomArrayValidator.isValidLine;

public class CustomArrayParserImpl implements CustomArrayParser {

    private static final Logger logger = LogManager.getLogger(CustomArrayParserImpl.class);
    private static final String REGEXP_DELIMITER = "\\s+-\\s+|\\s+|[,;]\\s*";

    private final CustomArrayFactory intArrayFactory;
    private final CustomArrayFactory doubleArrayFactory;

    public CustomArrayParserImpl(CustomArrayFactory intArrayFactory, CustomArrayFactory doubleArrayFactory) {
        this.intArrayFactory = intArrayFactory;
        this.doubleArrayFactory = doubleArrayFactory;
    }

    @Override
    public List<BaseCustomArray> parseLines(List<String> lines) {
        List<BaseCustomArray> list = new ArrayList<>();
        for (String line : lines) {
            Optional<BaseCustomArray> array = parseOneLine(line);
            if (array.isPresent()) {
                list.add(array.get());
            }
        }
        return list;
    }

    private Optional<BaseCustomArray> parseOneLine(String line) {
        if (line.isBlank()) {
            logger.log(Level.DEBUG, "The line {} is valid to be converted to CustomArray", line);
            return Optional.of(intArrayFactory.create(new String[0]));
        }
        String[] elements = line.trim().split(REGEXP_DELIMITER);
        if (isValidLine(elements)) {
            logger.log(Level.DEBUG, "The line {} is valid to be converted to CustomArray", line);

            if (isDouble(elements)) {
                return Optional.of(doubleArrayFactory.create(elements));

            } else {
                return Optional.of(intArrayFactory.create(elements));
            }

        } else {
            logger.log(Level.DEBUG, "The line {} ISN'T VALID to be converted to CustomArray", line);
            return Optional.empty();
        }
    }
}