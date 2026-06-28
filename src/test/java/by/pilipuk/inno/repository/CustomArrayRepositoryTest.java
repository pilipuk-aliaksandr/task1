package by.pilipuk.inno.repository;

import by.pilipuk.inno.comparator.CustomArrayComparator;
import by.pilipuk.inno.entity.CustomArray;
import by.pilipuk.inno.exception.CustomArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CustomArrayRepository Tests")
public class CustomArrayRepositoryTest {
    private CustomArrayRepository repository;
    private CustomArray array1;
    private CustomArray array2;

    @BeforeEach
    void setUp() {
        repository = CustomArrayRepository.getInstance();
        repository.findAll().clear();

        array1 = new CustomArray(new int[]{1, 2, 3, 4});
        array2 = new CustomArray(new int[]{5, 6});
    }

    @Test
    @DisplayName("Should successfully add an array to the repository and attach observer")
    void testAddShouldInsertArrayIntoList() throws CustomArrayException {
        repository.add(array1);

        List<CustomArray> currentArrays = repository.findAll();

        assertAll(
                () -> assertEquals(1, currentArrays.size(), "Repository should contain exactly 1 element"),
                () -> assertEquals(array1, currentArrays.getFirst(), "The contained element should be array1")
        );
    }

    @Test
    @DisplayName("remove: Should successfully remove an existing array from the repository")
    void testRemoveShouldDeleteArrayFromList() throws CustomArrayException {
        repository.add(array1);
        repository.add(array2);

        repository.remove(array1);

        List<CustomArray> currentArrays = repository.findAll();

        assertAll(
                () -> assertEquals(1, currentArrays.size(), "Repository should contain 1 element after removal"),
                () -> assertEquals(array2, currentArrays.getFirst(), "The remaining element should be array2")
        );
    }

    @Test
    @DisplayName("findAll: Should return an empty list when no elements have been added")
    void testFindAllShouldReturnEmptyListInitially() {
        List<CustomArray> currentArrays = repository.findAll();

        assertTrue(currentArrays.isEmpty(), "Repository should be empty initially");
    }

    @Test
    @DisplayName("findByQuerySpecification: Should filter repository elements using specification logic")
    void testFindByQuerySpecificationFiltersCorrectly() throws CustomArrayException {
        repository.add(array1);
        repository.add(array2);

        List<CustomArray> filtered = repository.findByQuerySpecification(arr -> arr.length() < 3);

        assertAll(
                () -> assertEquals(1, filtered.size()),
                () -> assertEquals(array2, filtered.getFirst(), "Should match array2 because its length is 2")
        );
    }

    @Test
    @DisplayName("sort: Should sort the internal collection in place according to the chosen comparator")
    void testSortShouldMutateInternalListInPlace() throws CustomArrayException {
        repository.add(array1);
        repository.add(array2);

        repository.sort(CustomArrayComparator.BY_ARRAY_ELEMENTS_AMOUNT);

        List<CustomArray> sortedList = repository.findAll();

        assertAll(
                () -> assertEquals(2, sortedList.size()),
                () -> assertEquals(array2, sortedList.get(0), "First element after sorting should be array2 (length 2)"),
                () -> assertEquals(array1, sortedList.get(1), "Second element after sorting should be array1 (length 4)")
        );
    }
}
