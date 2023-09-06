package sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringSorterTest {
    private StringSorter stringSorter;

    @BeforeEach
    public void setUp() {
        stringSorter = new StringSorter();
    }

    @Test
    public void testSortStrings_Ok() {
        List<String> unsortedStrings = Arrays.asList("apple", "banana", "grape", "avocado", "cherry");
        String exceptionChar = "a";

        List<String> sortedList = stringSorter.sortStrings(unsortedStrings, exceptionChar);

        List<String> expectedList = Arrays.asList("banana", "cherry", "grape", "avocado", "apple");
        assertIterableEquals(expectedList, sortedList);
    }

    @Test
    public void testSortStringsWithEmptyList() {
        List<String> unsortedList = new ArrayList<>();
        String exceptionChar = "a";

        List<String> sortedList = stringSorter.sortStrings(unsortedList, exceptionChar);
        assertTrue(sortedList.isEmpty());
    }

    @Test
    public void testSortStringsWithOutApplicableExceptionChar() {
        List<String> unsortedList = Arrays.asList("pear", "orange", "apple", "banana");
        String exceptionChar = "w";

        List<String> sortedList = stringSorter.sortStrings(unsortedList, exceptionChar);

        List<String> expectedList = Arrays.asList("apple", "banana", "orange", "pear");
        assertIterableEquals(expectedList, sortedList);
    }
}

