package by.pilipuk.inno.factory.impl;

import by.pilipuk.inno.entity.CustomArray;
import by.pilipuk.inno.util.IdGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static by.pilipuk.inno.util.IdGenerator.resetId;
import static org.junit.jupiter.api.Assertions.*;

class ArrayFactoryTest {

    private static final ArrayFactory factory = new ArrayFactory();

    @Test
    @DisplayName("Create CustomIntArray by factory creation method")
    void create() {
        // given
        IdGenerator.resetId();
        CustomArray expectedCustomArray = new CustomArray(new int[] {1, 2, -3});

        // when
        resetId();
        CustomArray actualCustomArray = factory.create(new int[] {1, 2, -3});

        // then
        assertEquals(expectedCustomArray, actualCustomArray);
    }
}
