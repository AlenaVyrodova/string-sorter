package sample;

import java.util.*;
import java.util.stream.Stream;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * <p>
 * <p>
 * Implement in single class.
 */
public class StringSorter {
    /**
     * The StringSorter class defines the contract for sorting strings based on
     * alphabetical order while skipping words that start with a specific prefix.
     * <p>
     * Example:
     * Input: ["apple", "banana", "grape", "avocado", "cherry"], Exception prefix: "a"
     * Output: ["banana", "cherry", "grape", "avocado", "apple"]
     * <p>
     * Here, "banana", "cherry", and "grape" are sorted in alphabetical order
     * whereas "avocado" and "apple" (that start with 'a') are sorted in reverse alphabetical order
     * at the end of the list.
     */
    public List<String> sortStrings(List<String> unsortedStrings, String exceptionChar) {

        var sortedWithPrefix = unsortedStrings.stream()
                .filter(word -> word.startsWith(exceptionChar))
                .sorted(Collections.reverseOrder());
        var sortedWithoutPrefix = unsortedStrings.stream()
                .filter(word -> !word.startsWith(exceptionChar))
                .sorted();

        return Stream.concat(sortedWithoutPrefix, sortedWithPrefix)
                .toList();
    }
}

