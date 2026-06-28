package by.pilipuk.inno.warehouse;

import by.pilipuk.inno.statistic.CustomArrayStatistic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Warehouse Tests")
public class WarehouseTest {
    private Warehouse warehouse;
    private CustomArrayStatistic statistics;
    private final Long testId = 100L;

    @BeforeEach
    void setUp() {
        warehouse = Warehouse.getInstance();
        warehouse.removeStatistics(testId);
        statistics = new CustomArrayStatistic(-5, 15, 5.0, 20);
    }

    @Test
    @DisplayName("setStatistics: Should successfully save and link statistics to a specific array ID")
    void testSetStatisticsShouldAddElementToMap() {
        warehouse.setStatistics(testId, statistics);

        CustomArrayStatistic savedStatistics = warehouse.getStatistics(testId);

        assertEquals(statistics, savedStatistics, "The retrieved statistics should match the one we saved");
    }

    @Test
    @DisplayName("getStatistics: Should return null when trying to fetch statistics for a non-existing ID")
    void testGetStatisticsShouldReturnNullForNonExistingId() {
        long nonExistingId = 999L;

        CustomArrayStatistic result = warehouse.getStatistics(nonExistingId);

        assertNull(result, "Should return null because this ID was never added");
    }

    @Test
    @DisplayName("removeStatistics: Should successfully delete statistical data from the warehouse by ID")
    void testRemoveStatisticsShouldDeleteElementFromMap() {
        warehouse.setStatistics(testId, statistics);

        warehouse.removeStatistics(testId);

        CustomArrayStatistic result = warehouse.getStatistics(testId);

        assertNull(result, "Statistics should be null after explicit removal");
    }

    @Test
    @DisplayName("setStatistics: Should overwrite old statistics if the same ID is saved again")
    void testSetStatisticsShouldOverwriteExistingValue() {
        warehouse.setStatistics(testId, statistics);

        CustomArrayStatistic newStatistics = new CustomArrayStatistic(0, 10, 5.0, 10);
        warehouse.setStatistics(testId, newStatistics);

        CustomArrayStatistic result = warehouse.getStatistics(testId);

        assertEquals(newStatistics, result, "The warehouse should hold the updated statistics value");
    }
}
