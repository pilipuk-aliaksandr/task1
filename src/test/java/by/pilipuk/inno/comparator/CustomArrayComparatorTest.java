package by.pilipuk.inno.comparator;

import by.pilipuk.inno.entity.CustomArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("CustomArrayComparator Enum Tests")
public class CustomArrayComparatorTest {
    private CustomArray array1;
    private CustomArray array2;
    private CustomArray array3;

    @BeforeEach
    void setUp() {
        array1 = new CustomArray(new int[]{10, 20, 30});
        array2 = new CustomArray(new int[]{5, 6, 7, 8, 9});
        array3 = new CustomArray(new int[]{10, 100});
    }

    @Test
    @DisplayName("Sorting BY_ID: Should return a negative value when the first array ID is smaller")
    void testByIdShouldReturnNegativeWhenFirstIdIsSmaller() {
        int result = CustomArrayComparator.BY_ID.compare(array1, array2);
        assertTrue(result < 0);
    }

    @Test
    @DisplayName("Sorting BY_ID: Should return a positive value when the first array ID is greater")
    void testByIdShouldReturnPositiveWhenFirstIdIsGreater() {
        int result = CustomArrayComparator.BY_ID.compare(array2, array1);
        assertTrue(result > 0);
    }

    @Test
    @DisplayName("Sorting BY_FIRST_ELEMENT_FROM_ARRAY: Should return a positive value when the first element is greater")
    void testByFirstElementShouldReturnPositiveWhenFirstElementIsGreater() {
        int result = CustomArrayComparator.BY_FIRST_ELEMENT_FROM_ARRAY.compare(array1, array2);
        assertTrue(result > 0);
    }

    @Test
    @DisplayName("Sorting BY_FIRST_ELEMENT_FROM_ARRAY: Should return a negative value when the first element is smaller")
    void testByFirstElementShouldReturnNegativeWhenFirstElementIsSmaller() {
        int result = CustomArrayComparator.BY_FIRST_ELEMENT_FROM_ARRAY.compare(array2, array1);
        assertTrue(result < 0);
    }

    @Test
    @DisplayName("Sorting BY_FIRST_ELEMENT_FROM_ARRAY: Should return zero when the first elements are equal")
    void testByFirstElementShouldReturnZeroWhenFirstElementsAreEqual() {
        int result = CustomArrayComparator.BY_FIRST_ELEMENT_FROM_ARRAY.compare(array1, array3);
        assertTrue(result == 0);
    }

    @Test
    @DisplayName("Sorting BY_ARRAY_ELEMENTS_AMOUNT: Should return a negative value when the first array length is smaller")
    void testByArrayElementsAmountShouldReturnNegativeWhenLengthIsSmaller() {
        int result = CustomArrayComparator.BY_ARRAY_ELEMENTS_AMOUNT.compare(array1, array2);
        assertTrue(result < 0);
    }

    @Test
    @DisplayName("Sorting BY_ARRAY_ELEMENTS_AMOUNT: Should return a positive value when the first array length is greater")
    void testByArrayElementsAmountShouldReturnPositiveWhenLengthIsGreater() {
        int result = CustomArrayComparator.BY_ARRAY_ELEMENTS_AMOUNT.compare(array2, array1);
        assertTrue(result > 0);
    }

    @Test
    @DisplayName("Sorting BY_ARRAY_ELEMENTS_AMOUNT: Should return zero when both array lengths are equal")
    void testByArrayElementsAmountShouldReturnZeroWhenLengthsAreEqual() {
        CustomArray anotherArrayWithLengthThree = new CustomArray(new int[]{1, 2, 3});
        int result = CustomArrayComparator.BY_ARRAY_ELEMENTS_AMOUNT.compare(array1, anotherArrayWithLengthThree);
        assertTrue(result == 0);
    }

    @Test
    @DisplayName("Sorting BY_ID: Should return zero when both array IDs are equal")
    void testByIdShouldReturnZeroWhenIdsAreEqual() {
        int result = CustomArrayComparator.BY_ID.compare(array1, array1);
        assertTrue(result == 0);
    }
}
