package by.pilipuk.inno.parser;

import by.pilipuk.inno.entity.base.BaseCustomArray;
import java.util.List;

public interface CustomArrayParser {

    List<BaseCustomArray> parseLines(List<String> lines);
}