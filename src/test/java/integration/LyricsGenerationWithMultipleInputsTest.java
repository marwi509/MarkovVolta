package integration;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class LyricsGenerationWithMultipleInputsTest {

    @Test
    public void testAllSongsAgainstReference() {
        System.out.println("Testing for all songs");
        String reference = TestUtils.getReferenceText(TestUtils.generateFilePrefix(TestUtils.songs));

        String generatedSong = TestUtils.generateSong(TestUtils.songs);

        assertEquals("Generated song did not match reference for all songs ",
                reference, generatedSong);
    }

}
