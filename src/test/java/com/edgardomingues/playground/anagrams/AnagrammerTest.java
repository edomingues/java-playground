package com.edgardomingues.playground.anagrams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class AnagrammerTest {

    private Anagrammer anagrammer = new Anagrammer();

    @Test
    void returnAnagramsInBuckets() {
        List<String> input = List.of("star", "rats", "star", "rats", "cognitio", "gnitioco", "arts", "rats");

        List<List<String>> output = anagrammer.groupInBucketsWithoutDuplicates(input);

        assertThat(output, is(List.of(List.of("arts", "rats", "star"),
                                      List.of("cognitio", "gnitioco"))));
    }

}