package integration;

import markov.lyricsGenerator.LyricsFacade;
import markov.util.io.FileReader;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Random;

public class TestUtils {

    public final static String[] songs = new String[]
            {"goliath", "bohemianrhapsody", "meccamputechture", "thongsong", "thunderroad", "zed"};
    public final static long seed = 1337;
    public final static String referenceLocation = "src/test/resources/reference/";

    public static String generateFilePrefix(String[] songNames) {
        String filePrefix = "";

        for(String songName : songNames) {
            filePrefix += songName.charAt(0);
        }
        return filePrefix;
    }

    public static String referenceFilename(String songName) {
        return referenceLocation + songName + "-reference.txt";
    }

    public static String generateSong(String... songNames) {
        final LyricsFacade facade = new LyricsFacade(new Random(seed));

        facade.setCharacterSequenceLength(4);
        facade.setUseCharacter();

        Arrays.stream(songNames)
                .forEach(s -> facade.addSong(songFileStream(s)));
        return facade.generateSong();
    }

    private static InputStream songFileStream(String songName) {
        return getStreamForResource("/lyrics/" + songName + ".txt");
    }

    public static InputStream getStreamForResource(String file) {
        return file.getClass()
                .getResourceAsStream(file);
    }

    public static String readFile(InputStream is) {
        FileReader fr = new FileReader();
        fr.readFile(is);
        return fr.getContent();
    }

    public static String getReferenceText(String songName) {
        return readFile(getStreamForResource("/reference/" + songName + "-reference.txt"));
    }
}
