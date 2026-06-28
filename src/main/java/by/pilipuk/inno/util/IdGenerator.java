package by.pilipuk.inno.util;

public class IdGenerator {
    public static Long id = 0L;

    public static Long generateId() {
        return ++id;
    }

    public static void resetId() {
        id = 0L;
    }
}
