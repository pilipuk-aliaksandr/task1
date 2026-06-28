package by.pilipuk.inno.repository;

import by.pilipuk.inno.comparator.CustomArrayComparator;
import by.pilipuk.inno.entity.CustomArray;
import by.pilipuk.inno.exception.CustomArrayException;
import by.pilipuk.inno.observer.impl.CustomArrayObserverImpl;
import by.pilipuk.inno.repository.specification.Specification;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class CustomArrayRepository {
    private static final Logger logger = LogManager.getLogger();
    private final static CustomArrayRepository INSTANCE = new CustomArrayRepository();
    private final List<CustomArray> customArrays = new ArrayList<>();

    private CustomArrayRepository() {
    }

    public static CustomArrayRepository getInstance() {
        return INSTANCE;
    }

    public void add(CustomArray customArray) throws CustomArrayException {
        customArrays.add(customArray);
        customArray.attach(new CustomArrayObserverImpl());
        customArray.notifyObserver();
        logger.log(Level.INFO, "The array with id={} was added to repository", customArray.getId());
    }

    public void remove(CustomArray customArray) throws CustomArrayException {
        customArrays.remove(customArray);
        customArray.attach(new CustomArrayObserverImpl());
        customArray.notifyObserver();
        logger.log(Level.INFO, "The array with id={} was removed from repository", customArray.getId());
    }

    public List<CustomArray> findAll() {
        return customArrays;
    }

    public List<CustomArray> findByQuerySpecification(Specification specification) {
        return customArrays.stream()
                .filter(specification::specify)
                .toList();
    }

    public void sort(CustomArrayComparator comparator) {
        customArrays.sort(comparator);
    }
}
