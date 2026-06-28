package by.pilipuk.inno.observer.impl;

import by.pilipuk.inno.entity.CustomArray;
import by.pilipuk.inno.observer.CustomArrayObserver;
import by.pilipuk.inno.statistic.CustomArrayStatistic;
import by.pilipuk.inno.warehouse.Warehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CustomArrayObserverImpl Tests")
public class CustomArrayObserverImplTest {
    private CustomArrayObserver observer;
    private Warehouse warehouse;
    private CustomArray testArray;

    @BeforeEach
    void setUp() {
        observer = new CustomArrayObserverImpl();
        warehouse = Warehouse.getInstance();

        testArray = new CustomArray(new int[]{10, -5, 15, 0});

        warehouse.removeStatistics(testArray.getId());
    }

    @Test
    @DisplayName("update: Should calculate correct statistics and store them in the Warehouse")
    void testUpdateShouldCalculateAndStoreStatsInWarehouse() {
        observer.update(testArray);

        CustomArrayStatistic actualStats = warehouse.getStatistics(testArray.getId());

        assertAll(
                () -> assertNotNull(actualStats, "Statistics should be present in the warehouse after update"),
                () -> assertEquals(-5, actualStats.min(), "Calculated minimum value is incorrect"),
                () -> assertEquals(15, actualStats.max(), "Calculated maximum value is incorrect"),
                () -> assertEquals(20, actualStats.sum(), "Calculated sum of elements is incorrect"),
                () -> assertEquals(5.0, actualStats.avg(), "Calculated average of elements is incorrect")
        );
    }

    @Test
    @DisplayName("update: Should handle empty array correctly by inserting default zeros")
    void testUpdateShouldHandleEmptyArrayWithDefaults() {
        CustomArray emptyArray = new CustomArray(new int[]{});
        warehouse.removeStatistics(emptyArray.getId());

        observer.update(emptyArray);

        CustomArrayStatistic actualStats = warehouse.getStatistics(emptyArray.getId());

        assertAll(
                () -> assertNotNull(actualStats, "Statistics for empty array should be present"),
                () -> assertEquals(0, actualStats.min(), "Min for empty array should fall back to 0"),
                () -> assertEquals(0, actualStats.max(), "Max for empty array should fall back to 0"),
                () -> assertEquals(0, actualStats.sum(), "Sum for empty array should fall back to 0"),
                () -> assertEquals(0.0, actualStats.avg(), "Avg for empty array should fall back to 0.0")
        );
    }
}
