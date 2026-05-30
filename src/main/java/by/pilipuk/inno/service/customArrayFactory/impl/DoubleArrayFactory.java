package by.pilipuk.inno.service.customArrayFactory.impl;

import by.pilipuk.inno.entity.CustomDoubleArray;
import by.pilipuk.inno.entity.base.BaseCustomArray;
import by.pilipuk.inno.service.customArrayFactory.CustomArrayFactory;

public class DoubleArrayFactory implements CustomArrayFactory {

    @Override
    public BaseCustomArray create(String[] elements) {
        double[] doubleArray = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            doubleArray[i] = Double.parseDouble(elements[i]);
        }
        return new CustomDoubleArray(doubleArray);
    }
}