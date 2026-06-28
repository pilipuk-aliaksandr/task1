package by.pilipuk.inno.service.sorter;

import by.pilipuk.inno.entity.CustomArray;

public interface CustomArraySorter<T extends CustomArray> {

    void selectionSort(T array);

    void quickSort(T array);
}