package by.pilipuk.inno.comparator;

import by.pilipuk.inno.entity.CustomArray;
import by.pilipuk.inno.exception.CustomArrayException;
import by.pilipuk.inno.repository.CustomArrayRepository;
import by.pilipuk.inno.repository.specification.Operator;
import by.pilipuk.inno.repository.specification.Specification;
import by.pilipuk.inno.repository.specification.impl.FindByAvgArrayValueSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("FindByAvgArrayValueSpecification Tests")
public class FindByAvgArrayValueSpecificationTest {
    private CustomArrayRepository repository;
    private CustomArray arrayWithAvgTwo;
    private CustomArray arrayWithAvgFive;

    @BeforeEach
    void setUp() throws CustomArrayException {
        repository = CustomArrayRepository.getInstance();
        repository.findAll().clear();

        arrayWithAvgTwo = new CustomArray(new int[]{1, 2, 3});
        arrayWithAvgFive = new CustomArray(new int[]{4, 5, 6});

        repository.add(arrayWithAvgTwo);
        repository.add(arrayWithAvgFive);
    }

    @Test
    @DisplayName("Operator.GREATER: Should return arrays with an average greater than the target value")
    void testSpecifyWithGreaterOperator() {
        Specification specification = new FindByAvgArrayValueSpecification(3.0, Operator.GREATER);

        List<CustomArray> result = repository.findByQuerySpecification(specification);

        assertAll(
                () -> assertEquals(1, result.size()),
                () -> assertEquals(arrayWithAvgFive, result.getFirst())
        );
    }

    @Test
    @DisplayName("Operator.LESS: Should return arrays with an average less than the target value")
    void testSpecifyWithLessOperator() {
        Specification specification = new FindByAvgArrayValueSpecification(3.0, Operator.LESS);

        List<CustomArray> result = repository.findByQuerySpecification(specification);

        assertAll(
                () -> assertEquals(1, result.size()),
                () -> assertEquals(arrayWithAvgTwo, result.getFirst())
        );
    }

    @Test
    @DisplayName("Operator.EQUAL: Should return arrays with an average exactly equal to the target value")
    void testSpecifyWithEqualOperator() {
        Specification specification = new FindByAvgArrayValueSpecification(2.0, Operator.EQUAL);

        List<CustomArray> result = repository.findByQuerySpecification(specification);

        assertAll(
                () -> assertEquals(1, result.size()),
                () -> assertEquals(arrayWithAvgTwo, result.getFirst())
        );
    }

    @Test
    @DisplayName("Should return an empty list when no arrays match the average condition")
    void testSpecifyShouldReturnEmptyListWhenNoMatches() {
        Specification specification = new FindByAvgArrayValueSpecification(10.0, Operator.GREATER);

        List<CustomArray> result = repository.findByQuerySpecification(specification);

        assertTrue(result.isEmpty());
    }
}
