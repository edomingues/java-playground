package com.edgardomingues.playground.anagrams;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class Anagrammer {

    public List<List<String>> groupInBucketsWithoutDuplicates(final List<String> input) {
        Map<Integer, Set<String>> buckets = new ConcurrentHashMap<>();

        input.parallelStream()
             .forEach(word -> addToBucket(word, buckets));

        return listOfLists(buckets);
    }

    private void addToBucket(final String word, final Map<Integer, Set<String>> buckets) {
        int hash = anagramHash(word);
        buckets.compute(hash, (__, words) -> {
            if (words == null) {
                words = new TreeSet<>();
            }
            words.add(word);
            return words;
        });
    }

    private int anagramHash(final String word) {
        return word.chars().sum();
    }

    private List<List<String>> listOfLists(final Map<Integer, Set<String>> buckets) {
        return buckets.values()
                      .stream()
                      .map(set -> set.stream().toList())
                      .toList();
    }
}
