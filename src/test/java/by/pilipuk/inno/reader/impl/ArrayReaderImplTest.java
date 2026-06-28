package by.pilipuk.inno.reader.impl;

import by.pilipuk.inno.exception.CustomArrayException;
import by.pilipuk.inno.reader.ArrayReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayReaderImplTest {

    private static final ArrayReader reader = new ArrayReaderImpl();

    @Test
    @DisplayName("Existing file is read and lines are returned")
    void readArraysFromExistsFile() throws CustomArrayException {
        // given
        String path = "file/input.txt";

        // when
        List<String> actual = reader.readDataFromFile(path);

        // then
        assertEquals(List.of("1, 2, 3", "4 5 6"), actual);
    }

    @Test
    @DisplayName("Non-existing file throws CustomArrayException")
    void readArraysFromMissingFile() {
        // given
        String path = "file/test_input.txt";

        // when

        // then
        assertThrows(CustomArrayException.class, () -> reader.readDataFromFile(path));

    }
}