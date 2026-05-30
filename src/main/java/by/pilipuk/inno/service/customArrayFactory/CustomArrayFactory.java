package by.pilipuk.inno.service.customArrayFactory;

import by.pilipuk.inno.entity.base.BaseCustomArray;

public interface CustomArrayFactory {

    BaseCustomArray create(String[] elements);

}