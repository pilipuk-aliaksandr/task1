package by.pilipuk.inno.service.sorter;

import by.pilipuk.inno.entity.base.BaseCustomArray;

public interface CustomArraySorter<T extends BaseCustomArray> {

    void selectionSort(T array);

    void quickSort(T array);
}