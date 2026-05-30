package by.pilipuk.inno;

import by.pilipuk.inno.entity.base.BaseCustomArray;
import by.pilipuk.inno.parser.CustomArrayParser;
import by.pilipuk.inno.parser.impl.CustomArrayParserImpl;
import by.pilipuk.inno.reader.ArrayReader;
import by.pilipuk.inno.reader.impl.ArrayReaderImpl;
import by.pilipuk.inno.service.customArrayFactory.impl.DoubleArrayFactory;
import by.pilipuk.inno.service.customArrayFactory.impl.IntArrayFactory;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayReader reader = new ArrayReaderImpl();
        List<String> lines = reader.readArraysFromFile("file/input.txt");

        CustomArrayParser parser = new CustomArrayParserImpl(
                new IntArrayFactory(),
                new DoubleArrayFactory()
        );
        List<BaseCustomArray> arrays = parser.parseLines(lines);

        for (BaseCustomArray array : arrays) {
            System.out.println(array);
        }
    }
}