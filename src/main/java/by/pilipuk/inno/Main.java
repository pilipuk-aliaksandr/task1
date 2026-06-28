package by.pilipuk.inno;

import by.pilipuk.inno.comparator.CustomArrayComparator;
import by.pilipuk.inno.entity.CustomArray;
import by.pilipuk.inno.exception.CustomArrayException;
import by.pilipuk.inno.factory.CustomArrayFactory;
import by.pilipuk.inno.factory.impl.ArrayFactory;
import by.pilipuk.inno.parser.CustomArrayParser;
import by.pilipuk.inno.parser.impl.CustomArrayParserImpl;
import by.pilipuk.inno.reader.ArrayReader;
import by.pilipuk.inno.reader.impl.ArrayReaderImpl;
import by.pilipuk.inno.repository.CustomArrayRepository;
import by.pilipuk.inno.repository.specification.Operator;
import by.pilipuk.inno.repository.specification.impl.FindByAvgArrayValueSpecification;
import by.pilipuk.inno.repository.specification.impl.FindByIdSpecification;
import by.pilipuk.inno.validator.impl.CustomArrayValidatorImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CustomArrayException {

        ArrayReader reader = new ArrayReaderImpl();
        List<String> lines1 = reader.readDataFromFile("file/input1.txt");
        List<String> lines2 = reader.readDataFromFile("file/input2.txt");
        String line1 = lines1.getFirst();
        String line2 = lines2.getFirst();

        CustomArrayParser parser;
        parser = new CustomArrayParserImpl(
                new CustomArrayValidatorImpl()
        );

        int[] array1 = parser.parseLine(line1);
        int[] array2 = parser.parseLine(line2);

        CustomArrayFactory factory = new ArrayFactory();
        CustomArray customArray1 = factory.create(array1);
        CustomArray customArray2 = factory.create(array2);

        CustomArrayRepository repository = CustomArrayRepository.getInstance();

        repository.add(customArray1);
        repository.add(customArray2);

        repository.sort(CustomArrayComparator.BY_ARRAY_ELEMENTS_AMOUNT);
        System.out.println(repository.findAll());

        System.out.println(repository.findByQuerySpecification(new FindByIdSpecification(2L)));

        System.out.println(repository.findByQuerySpecification(new FindByAvgArrayValueSpecification(1.0, Operator.LESS_OR_EQUAL)));

    }
}