package integration;

import markov.util.io.FileReader;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MarkovVoltaTest {

    @Test
    public void generateAllSongsAndCompareAgainstReference() {
        testSongAgainstReference("goliath");
        testSongAgainstReference("bohemianrhapsody");
        testSongAgainstReference("meccamputechture");
        testSongAgainstReference("thongsong");
        testSongAgainstReference("thunderroad");
        testSongAgainstReference("zed");
    }

    private void testSongAgainstReference(String songName) {
        System.out.println("Testing for song " + songName);
        String reference = getReferenceText(songName);

        String generatedSong = ReferenceGenerator.generateSong(songName);

        assertEquals("Generated song did not match reference for song " + songName ,
                reference, generatedSong);
    }

    private String getReferenceText(String songName) {
        FileReader fr = new FileReader();
        fr.readFile(this.getClass().getResourceAsStream("/reference/" + songName + "-reference.txt"));
        return fr.getContent();
    }

}
