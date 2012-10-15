package markov.lyricsGenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LyricsItemTest {
	WordItem theWordItem;
	WordItem theSameWordItem;
	WordItem theOtherWordItem;
	CharacterItem theChItem;
	CharacterItem theSameChItem;
	CharacterItem theOtherChItem;
	
	@Before
	public void setUp()
	{
	}
	
	@Test
	public void testCharacterItem()
	{
		theChItem = new CharacterItem("a");
		theSameChItem = new CharacterItem("a");
		theOtherChItem = new CharacterItem("b");
		
		assertTrue(theChItem.equals(theSameChItem));
		assertFalse(theChItem.equals(theOtherChItem));
	}
	
	@Test
	public void testWordItem()
	{
		theWordItem = new WordItem("abc");
		theSameWordItem = new WordItem("abc");
		theOtherWordItem = new WordItem("abcas");
		
		assertTrue(theWordItem.equals(theSameWordItem));
		assertFalse(theWordItem.equals(theOtherWordItem));
	}
}
