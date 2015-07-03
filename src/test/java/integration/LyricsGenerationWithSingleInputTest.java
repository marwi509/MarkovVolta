package integration;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

public class LyricsGenerationWithSingleInputTest {

    @Test
    public void generateAllSongsAndCompareAgainstReference() {
        Arrays.stream(TestUtils.songs)
        .forEach(songName -> {

            System.out.println("Testing for song " + songName);
            String reference = TestUtils.getReferenceText(songName);

            String generatedSong = TestUtils.generateSong(songName);

            assertEquals("Generated song did not match reference for song " + songName,
                    reference, generatedSong);

        });
    }
}
