package by.pilipuk.inno.observer;

import by.pilipuk.inno.exception.CustomArrayException;

public interface Subject {
    void attach(CustomArrayObserver customArrayObserver) throws CustomArrayException;
    void detach(CustomArrayObserver customArrayObserver);
    void notifyObserver();
}
