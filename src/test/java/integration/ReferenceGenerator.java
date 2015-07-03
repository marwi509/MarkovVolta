package integration;

import markov.util.io.FileStringWriter;

import java.util.Arrays;

public class ReferenceGenerator {

    public static void main(String[] args) {
        Arrays.stream(TestUtils.songs).forEach(ReferenceGenerator::generateReferenceForSong);
        generateReferenceForMultipleSongs(TestUtils.songs);
    }

    private static void generateReferenceForMultipleSongs(String... songNames) {
        String result = TestUtils.generateSong(songNames);
        FileStringWriter.toFile(result, TestUtils.referenceFilename(TestUtils.generateFilePrefix(songNames)));
    }

    private static void generateReferenceForSong(String songName) {
        String result = TestUtils.generateSong(songName);
        FileStringWriter.toFile(result, TestUtils.referenceFilename(songName));
    }

}
