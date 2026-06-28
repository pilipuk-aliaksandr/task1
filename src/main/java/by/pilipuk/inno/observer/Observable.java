package by.pilipuk.inno.observer;

import by.pilipuk.inno.exception.CustomArrayException;

public interface Observable {
    void attachObserver(CustomArrayObserver customArrayObserver) throws CustomArrayException;
    void notifyObserver();
}
