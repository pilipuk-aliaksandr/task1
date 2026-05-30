package by.pilipuk.inno.service.customArrayFactory.impl;

import by.pilipuk.inno.entity.CustomIntArray;
import by.pilipuk.inno.entity.base.BaseCustomArray;
import by.pilipuk.inno.service.customArrayFactory.CustomArrayFactory;

public class IntArrayFactory implements CustomArrayFactory {

    @Override
    public BaseCustomArray create(String[] elements) {
        int[] intArray = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            intArray[i] = Integer.parseInt(elements[i]);
        }
        return new CustomIntArray(intArray);
    }
}