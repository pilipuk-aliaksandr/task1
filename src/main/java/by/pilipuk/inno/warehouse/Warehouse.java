package by.pilipuk.inno.warehouse;

import by.pilipuk.inno.statistic.CustomArrayStatistic;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Logger logger = LogManager.getLogger();
    private static final Warehouse INSTANCE = new Warehouse();

    private final Map<Long, CustomArrayStatistic> statistics = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return INSTANCE;
    }

    public void setStatistics(Long id, CustomArrayStatistic parameters) {
        statistics.put(id, parameters);
        logger.log(Level.DEBUG, "Parameters was successfully set for the array with id={}", id);
    }

    public CustomArrayStatistic getStatistics(Long id) {
        return statistics.get(id);
    }

    public void removeStatistics(Long id) {
        statistics.remove(id);
        logger.log(Level.DEBUG, "Parameters was successfully removed from the array with id={}", id);
    }
}
