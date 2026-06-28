package by.pilipuk.inno.entity;

import by.pilipuk.inno.exception.CustomArrayException;
import by.pilipuk.inno.observer.CustomArrayObserver;
import by.pilipuk.inno.observer.Subject;
import by.pilipuk.inno.util.IdGenerator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class CustomArray implements Subject {
    private static final Logger logger = LogManager.getLogger();
    private final Long id;
    private int[] array;
    private CustomArrayObserver observer;

    public CustomArray(int[] array) {
        this.id = IdGenerator.generateId();
        this.array = Arrays.copyOf(array, array.length);
        logger.log(Level.INFO, "Created CustomArray with id: {} and length: {}", id, length());
    }

    public Long getId() {
        return id;
    }

    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public void setArray(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
        notifyObserver();
    }

    public int length() {
        return array.length;
    }

    public boolean isEmpty() {
        return length() == 0;
    }

    @Override
    public void attach(CustomArrayObserver customArrayObserver) throws CustomArrayException {
        if (customArrayObserver == null) {
            throw new CustomArrayException("Observer cannot be null");
        }
        observer = customArrayObserver;
    }

    @Override
    public void detach(CustomArrayObserver customArrayObserver) {
        if (observer == customArrayObserver) {
            observer = null;
        }
    }

    @Override
    public void notifyObserver() {
        observer.update(this);
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof CustomArray that)) return false;

        return id.equals(that.id) && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomArray{");
        sb.append("id=").append(id);
        sb.append(", arr=").append(Arrays.toString(array));
        sb.append('}');
        return sb.toString();
    }
}
