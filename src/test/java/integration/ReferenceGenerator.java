package integration;

import markov.lyricsGenerator.LyricsFacade;
import markov.util.io.FileStringWriter;

import java.util.Random;

public class ReferenceGenerator {

    public final static long seed = 1337;
    public final static String referenceLocation = "src/test/resources/reference/";
    private final static String lyricsLocation = "/lyrics/";

    public static void main(String[] args) {
        generateReferenceForSong("goliath");
        generateReferenceForSong("bohemianrhapsody");
        generateReferenceForSong("meccamputechture");
        generateReferenceForSong("thongsong");
        generateReferenceForSong("thunderroad");
        generateReferenceForSong("zed");
    }

    private static void generateReferenceForSong(String songName) {
        String result = generateSong(songName);
        FileStringWriter.toFile(result, referenceLocation + songName + "-reference.txt");
    }

    public static String generateSong(String songName) {
        final LyricsFacade facade = new LyricsFacade(new Random(seed));
        facade.setCharacterSequenceLength(4);
        facade.setUseCharacter();
        facade.addSong(facade.getClass().getResourceAsStream(lyricsLocation + songName + ".txt"));
        return facade.generateSong();
    }

}
