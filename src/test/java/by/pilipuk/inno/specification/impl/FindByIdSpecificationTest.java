package by.pilipuk.inno.specification.impl;

import by.pilipuk.inno.entity.CustomArray;
import by.pilipuk.inno.exception.CustomArrayException;
import by.pilipuk.inno.repository.CustomArrayRepository;
import by.pilipuk.inno.repository.specification.Specification;
import by.pilipuk.inno.repository.specification.impl.FindByIdSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("FindByIdSpecification Tests")
public class FindByIdSpecificationTest {
    private CustomArrayRepository repository;
    private CustomArray array1;
    private CustomArray array2;

    @BeforeEach
    void setUp() throws CustomArrayException {
        repository = CustomArrayRepository.getInstance();
        repository.findAll().clear();

        array1 = new CustomArray(new int[]{1, 2, 3});
        array2 = new CustomArray(new int[]{4, 5, 6});

        repository.add(array1);
        repository.add(array2);
    }

    @Test
    @DisplayName("Should find the exact array when a valid existing ID is provided")
    void testSpecifyShouldReturnTrueWhenIdMatches() {
        Specification specification = new FindByIdSpecification(array1.getId());

        List<CustomArray> result = repository.findByQuerySpecification(specification);

        assertAll(
                () -> assertEquals(1, result.size()),
                () -> assertEquals(array1, result.getFirst())
        );
    }

    @Test
    @DisplayName("Should return an empty list when a non-existing ID is provided")
    void testSpecifyShouldReturnFalseWhenIdDoesNotExist() {
        long nonExistingId = 0L;
        Specification specification = new FindByIdSpecification(nonExistingId);

        List<CustomArray> result = repository.findByQuerySpecification(specification);

        assertTrue(result.isEmpty());
    }
}
