package by.pilipuk.inno.parser;

import by.pilipuk.inno.exception.CustomArrayException;

public interface CustomArrayParser {

    int[] parseLine(String line) throws CustomArrayException;
}