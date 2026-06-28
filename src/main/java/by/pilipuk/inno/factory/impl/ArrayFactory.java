package by.pilipuk.inno.factory.impl;

import by.pilipuk.inno.entity.CustomArray;
import by.pilipuk.inno.factory.CustomArrayFactory;

public class ArrayFactory implements CustomArrayFactory {

    @Override
    public CustomArray create(int[] intArray) {
        return new CustomArray(intArray);
    }
}
