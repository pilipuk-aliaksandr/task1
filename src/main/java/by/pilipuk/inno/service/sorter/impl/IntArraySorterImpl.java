package by.pilipuk.inno.service.sorter.impl;

import by.pilipuk.inno.entity.CustomIntArray;
import by.pilipuk.inno.service.sorter.CustomIntArraySorter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntArraySorterImpl implements CustomIntArraySorter {

    private static final Logger logger = LogManager.getLogger(IntArraySorterImpl.class);

    @Override
    public void selectionSort(CustomIntArray array) {
        int[] tempArr = array.getArr();
        for (int i = 0; i < tempArr.length; i++) {
            int minIndx = i;

            for (int j = i + 1; j < tempArr.length; j++) {
                if (tempArr[j] < tempArr[minIndx]) {
                    minIndx = j;
                }
            }
            if (minIndx > i) {
                int tempVal = tempArr[minIndx];

                tempArr[minIndx] = tempArr[i];
                tempArr[i] = tempVal;
            }
        }
        array.setArr(tempArr);
        logger.log(Level.DEBUG, "Custom array was sorted with selection sort!");
    }

    @Override
    public void quickSort(CustomIntArray array) {
        int[] tempArr = array.getArr();
        int left = 0;
        int right = tempArr.length - 1;

        quickSort(tempArr, left, right);
        array.setArr(tempArr);
        logger.log(Level.DEBUG, "Custom array was sorted with quick sort!");
    }

    private void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return;
        }

        int pivot = arr[leftIndex + (rightIndex - leftIndex) / 2];
        int leftMarkerIndex = leftIndex;
        int rightMarkerIndex = rightIndex;

        while (leftMarkerIndex <= rightMarkerIndex) {

            while (arr[leftMarkerIndex] < pivot) {
                leftMarkerIndex++;
            }

            while (arr[rightMarkerIndex] > pivot) {
                rightMarkerIndex--;
            }

            if (leftMarkerIndex <= rightMarkerIndex) {
                int temp = arr[leftMarkerIndex];
                arr[leftMarkerIndex] = arr[rightMarkerIndex];
                arr[rightMarkerIndex] = temp;
                leftMarkerIndex++;
                rightMarkerIndex--;
            }
        }
        if (leftIndex < rightMarkerIndex) {
            quickSort(arr, leftIndex, rightMarkerIndex);
        }
        if (leftMarkerIndex < rightIndex) {
            quickSort(arr, leftMarkerIndex, rightIndex);
        }
    }
}