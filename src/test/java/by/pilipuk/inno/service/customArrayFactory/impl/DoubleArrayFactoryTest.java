package by.pilipuk.inno.service.customArrayFactory.impl;

import by.pilipuk.inno.entity.CustomDoubleArray;
import by.pilipuk.inno.entity.base.BaseCustomArray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoubleArrayFactoryTest {

    private static final DoubleArrayFactory factory = new DoubleArrayFactory();

    @Test
    @DisplayName("Create CustomDoubleArray by factory creation method")
    void create() {
        // given
        BaseCustomArray expectedCustomArray = new CustomDoubleArray(new double[] {1.0, 2.0, -3.0});

        // when
        BaseCustomArray actualCustomArray = factory.create(new String[] {"1.0", "2.0", "-3.0"});

        // then
        assertEquals(expectedCustomArray, actualCustomArray);
    }
}