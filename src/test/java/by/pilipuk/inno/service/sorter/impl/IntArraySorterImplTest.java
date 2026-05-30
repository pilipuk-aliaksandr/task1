package by.pilipuk.inno.service.sorter.impl;

import by.pilipuk.inno.entity.CustomIntArray;
import by.pilipuk.inno.service.sorter.CustomArraySorter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntArraySorterImplTest {

    private static CustomIntArray baseArray;
    private static CustomIntArray emptyArray;

    private static final CustomArraySorter<CustomIntArray> sorter = new IntArraySorterImpl();

    @BeforeEach
    void setUp() {
        baseArray = new CustomIntArray(new int[] {1, 2, 3, -4});
        emptyArray = new CustomIntArray(new int[0]);
    }

    @Test
    @DisplayName("Selection sorting the basic custom array")
    void selectionSortBasic() {
        var expectedArray = new CustomIntArray(new int[] {-4, 1, 2, 3});

        sorter.selectionSort(baseArray);
        var actualArray = baseArray;
        assertEquals(expectedArray, actualArray);
    }

    @Test
    @DisplayName("Selection sorting the empty custom array")
    void selectionSortEmpty() {
        var expectedArray = new CustomIntArray(new int[0]);

        sorter.selectionSort(emptyArray);
        var actualArray = emptyArray;
        assertEquals(expectedArray, actualArray);
    }

    @Test
    @DisplayName("Quick sort the basic custom array")
    void quickSortBasic() {
        var expectedArray = new CustomIntArray(new int[] {-4, 1, 2, 3});

        sorter.quickSort(baseArray);
        var actualArray = baseArray;
        assertEquals(expectedArray, actualArray);
    }

    @Test
    @DisplayName("Quick sort the empty custom array")
    void quickSortEmpty() {
        var expectedArray = new CustomIntArray(new int[0]);

        sorter.quickSort(emptyArray);
        var actualArray = emptyArray;
        assertEquals(expectedArray, actualArray);
    }
}