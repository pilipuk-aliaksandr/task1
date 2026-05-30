package by.pilipuk.inno.service.sorter.impl;

import by.pilipuk.inno.entity.CustomDoubleArray;
import by.pilipuk.inno.service.sorter.CustomArraySorter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DoubleArraySorterImplTest {

    private static CustomDoubleArray baseArray;
    private static CustomDoubleArray emptyArray;

    private static final CustomArraySorter<CustomDoubleArray> sorter = new DoubleArraySorterImpl();

    @BeforeEach
    void setUp() {
        baseArray = new CustomDoubleArray(new double[] {1.0, 2.0, 3.0, -4.0});
        emptyArray = new CustomDoubleArray(new double[0]);
    }

    @Test
    @DisplayName("Selection sorting the basic custom array")
    void selectionSortBasic() {
        var expectedArray = new CustomDoubleArray(new double[] {-4.0, 1.0, 2.0, 3.0});

        sorter.selectionSort(baseArray);
        var actualArray = baseArray;
        assertEquals(expectedArray, actualArray);
    }

    @Test
    @DisplayName("Selection sorting the empty custom array")
    void selectionSortEmpty() {
        var expectedArray = new CustomDoubleArray(new double[0]);

        sorter.selectionSort(emptyArray);
        var actualArray = emptyArray;
        assertEquals(expectedArray, actualArray);
    }

    @Test
    @DisplayName("Quick sort the basic custom array")
    void quickSortBasic() {
        var expectedArray = new CustomDoubleArray(new double[] {-4, 1, 2, 3});

        sorter.quickSort(baseArray);
        var actualArray = baseArray;
        assertEquals(expectedArray, actualArray);
    }

    @Test
    @DisplayName("Quick sort the empty custom array")
    void quickSortEmpty() {
        var expectedArray = new CustomDoubleArray(new double[0]);

        sorter.quickSort(emptyArray);
        var actualArray = emptyArray;
        assertEquals(expectedArray, actualArray);
    }
}