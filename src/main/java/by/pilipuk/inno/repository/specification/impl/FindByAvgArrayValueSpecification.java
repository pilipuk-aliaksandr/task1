package by.pilipuk.inno.repository.specification.impl;

import by.pilipuk.inno.entity.CustomArray;
import by.pilipuk.inno.repository.specification.Operator;
import by.pilipuk.inno.repository.specification.Specification;
import by.pilipuk.inno.service.calculator.CustomArrayCalculator;
import by.pilipuk.inno.service.calculator.impl.CustomArrayCalculatorImpl;

public class FindByAvgArrayValueSpecification implements Specification {
    Double avg;
    CustomArrayCalculator arrayCalculator;
    Operator operator;

    public FindByAvgArrayValueSpecification(double avg, Operator operator) {
        this.avg = avg;
        this.arrayCalculator = new CustomArrayCalculatorImpl();
        this.operator = operator;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        return operator.compare(arrayCalculator.calculateAverageOfElements(customArray).orElse(0.0), avg);
    }
}
