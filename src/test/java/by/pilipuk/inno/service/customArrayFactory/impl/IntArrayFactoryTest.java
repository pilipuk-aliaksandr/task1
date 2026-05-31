package by.pilipuk.inno.service.customArrayFactory.impl;

import by.pilipuk.inno.entity.CustomIntArray;
import by.pilipuk.inno.entity.base.BaseCustomArray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntArrayFactoryTest {

    private static final IntArrayFactory factory = new IntArrayFactory();

    @Test
    @DisplayName("Create CustomIntArray by factory creation method")
    void create() {
        // given
        BaseCustomArray expectedCustomArray = new CustomIntArray(new int[] {1, 2, -3});

        // when
        BaseCustomArray actualCustomArray = factory.create(new String[] {"1", "2", "-3"});

        // then
        assertEquals(expectedCustomArray, actualCustomArray);
    }
}