package by.pilipuk.inno.service.sorter.impl;

import by.pilipuk.inno.entity.CustomArray;
import by.pilipuk.inno.exception.CustomArrayException;
import by.pilipuk.inno.observer.CustomArrayObserver;
import by.pilipuk.inno.observer.impl.CustomArrayObserverImpl;
import by.pilipuk.inno.service.sorter.CustomArraySorter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static by.pilipuk.inno.util.IdGenerator.resetId;
import static org.junit.jupiter.api.Assertions.*;

class CustomArraySorterImplTest {

    private static CustomArray baseArray;
    private static CustomArray emptyArray;

    private static final CustomArraySorter<CustomArray> sorter = new CustomArraySorterImpl();
    private static final CustomArrayObserver observer = new CustomArrayObserverImpl();

    @BeforeEach
    void setUp() throws CustomArrayException {
        resetId();
        baseArray = new CustomArray(new int[] {1, 2, 3, -4});
        resetId();
        emptyArray = new CustomArray(new int[0]);
        resetId();
        baseArray.attachObserver(observer);
        emptyArray.attachObserver(observer);
    }

    @Test
    @DisplayName("Selection sorting the basic custom array")
    void selectionSortBasic() {
        //given
        var expectedArray = new CustomArray(new int[] {-4, 1, 2, 3});

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
        var expectedArray = new CustomArray(new int[0]);

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
        var expectedArray = new CustomArray(new int[] {-4, 1, 2, 3});

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
        var expectedArray = new CustomArray(new int[0]);

        // when
        sorter.quickSort(emptyArray);
        var actualArray = emptyArray;

        //then
        assertEquals(expectedArray, actualArray);
    }
}
