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
        //given
        var expectedArray = new CustomDoubleArray(new double[] {-4.0, 1.0, 2.0, 3.0});

        // when
        sorter.selectionSort(baseArray);
        var actualArray = baseArray;

        //then
        assertEquals(expectedArray, actualArray);
    }

    @Test
    @DisplayName("Selection sorting the empty custom array")
    void selectionSortEmpty() {
        //given
        var expectedArray = new CustomDoubleArray(new double[0]);

        // when
        sorter.selectionSort(emptyArray);
        var actualArray = emptyArray;

        //then
        assertEquals(expectedArray, actualArray);
    }

    @Test
    @DisplayName("Quick sort the basic custom array")
    void quickSortBasic() {
        //given
        var expectedArray = new CustomDoubleArray(new double[] {-4, 1, 2, 3});

        // when
        sorter.quickSort(baseArray);
        var actualArray = baseArray;

        //then
        assertEquals(expectedArray, actualArray);
    }

    @Test
    @DisplayName("Quick sort the empty custom array")
    void quickSortEmpty() {
        //given
        var expectedArray = new CustomDoubleArray(new double[0]);

        // when
        sorter.quickSort(emptyArray);
        var actualArray = emptyArray;

        //then
        assertEquals(expectedArray, actualArray);
    }
}