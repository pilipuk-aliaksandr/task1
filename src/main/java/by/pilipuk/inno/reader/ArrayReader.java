package by.pilipuk.inno.reader;

import by.pilipuk.inno.exception.CustomArrayException;

import java.util.List;

public interface ArrayReader {

    List<String> readDataFromFile(String path) throws CustomArrayException;
}