package by.pilipuk.inno.observer.impl;

import by.pilipuk.inno.entity.CustomArray;
import by.pilipuk.inno.service.calculator.CustomArrayCalculator;
import by.pilipuk.inno.service.calculator.impl.CustomArrayCalculatorImpl;
import by.pilipuk.inno.observer.CustomArrayObserver;
import by.pilipuk.inno.statistic.CustomArrayStatistic;
import by.pilipuk.inno.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayObserverImpl implements CustomArrayObserver {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void update(CustomArray customArray) {
        CustomArrayCalculator calculator = new CustomArrayCalculatorImpl();
        int min = calculator.findMinValue(customArray).orElse(0);
        int max = calculator.findMaxValue(customArray).orElse(0);
        int sum = calculator.calculateSumOfElements(customArray).orElse(0);
        double avg = calculator.calculateAverageOfElements(customArray).orElse(0.0);

        CustomArrayStatistic statistics = new CustomArrayStatistic(min, max, avg, sum);

        Warehouse warehouse = Warehouse.getInstance();

        long id = customArray.getId();
        warehouse.setStatistics(id, statistics);
        logger.log(Level.DEBUG, "The statistics in the warehouse was set to custom array with id={}.", id);

    }
}
