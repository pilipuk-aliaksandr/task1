package by.pilipuk.inno.reader.impl;

import by.pilipuk.inno.exception.CustomArrayException;
import by.pilipuk.inno.reader.ArrayReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ArrayReaderImpl implements ArrayReader {

    private static final Logger logger = LogManager.getLogger(ArrayReaderImpl.class);

    @Override
    public List<String> readArraysFromFile(String path) {
        logger.log(Level.DEBUG, "Reading file: {}", path);
        URL resource = ArrayReaderImpl.class.getClassLoader().getResource(path);
        if (resource == null) {
            throw new CustomArrayException("File not found in classpath: " + path);
        }
        try {
            return Files.readAllLines(Paths.get(resource.toURI()));
        } catch (IOException | URISyntaxException e) {
            logger.log(Level.ERROR, "Failed to read file: {}", path, e);
            throw new CustomArrayException("Failed to read file: " + path, e);
        }
    }
}