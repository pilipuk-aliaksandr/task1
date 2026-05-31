package by.pilipuk.inno.entity;

import by.pilipuk.inno.entity.base.BaseCustomArray;

import java.util.Arrays;

public class CustomDoubleArray extends BaseCustomArray {
    private double[] arr;

    public CustomDoubleArray() {
        this.arr = new double[0];
    }

    public CustomDoubleArray(double[] arr) {
        this.arr = Arrays.copyOf(arr, arr.length);
    }

    public double[] getArr() {
        return Arrays.copyOf(arr, arr.length);
    }

    public void setArr(double[] arr) {
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
        if (o == null || getClass() != o.getClass()) return false;

        CustomDoubleArray that = (CustomDoubleArray) o;
        return Arrays.equals(arr, that.arr);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arr);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomDoubleArray{");
        sb.append("arr=").append(Arrays.toString(arr));
        sb.append('}');
        return sb.toString();
    }
}