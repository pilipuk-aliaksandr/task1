package by.pilipuk.inno.validator;

public class CustomArrayValidator {

    private static final String REGEXP_VALID_ELEMENT = "-?\\d+(\\.\\d+)?";
    private static final String REGEXP_IS_DOUBLE = "-?\\d+\\.\\d+";

    public static boolean isValidLine(String[] elements) {
        for (String element : elements) {
            if (!element.matches(REGEXP_VALID_ELEMENT)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDouble(String[] elements) {
        for (String element : elements) {
            if (element.matches(REGEXP_IS_DOUBLE)) {
                return true;
            }
        }
        return false;
    }
}