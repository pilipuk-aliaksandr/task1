package by.pilipuk.inno.entity;

import by.pilipuk.inno.entity.base.BaseCustomArray;

import java.util.Arrays;

public class CustomIntArray extends BaseCustomArray {
    private int[] arr;

    public CustomIntArray() {
        this.arr = new int[0];
    }

    public CustomIntArray(int[] arr) {
        this.arr = Arrays.copyOf(arr, arr.length);
    }

    public int[] getArr() {
        return Arrays.copyOf(arr, arr.length);
    }

    public void setArr(int[] arr) {
        this.arr = Arrays.copyOf(arr, arr.length);
    }

    @Override
    public int length() {
        return arr.length;
    }

    @Override
    public boolean isEmpty() {
        return length() == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CustomIntArray that = (CustomIntArray) o;
        return Arrays.equals(arr, that.arr);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arr);
    }

    @Override
    public String toString() {
        return "CustomIntArray{arr=" + Arrays.toString(arr) + "}";
    }
}