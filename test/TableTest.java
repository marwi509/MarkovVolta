package markov.lyricsGenerator;

import static org.junit.Assert.*;
import markov.util.ArrayTable;
import markov.util.HashTable;

import org.junit.Before;
import org.junit.Test;

public class TableTest {
	HashTable<LyricsItem> theHashTable;
	ArrayTable<LyricsItem> theArrayTable;
	
	@Before
	public void Allocate()
	{
		theHashTable = new HashTable<LyricsItem>(128);
		theArrayTable = new ArrayTable<LyricsItem>();
	}
	
	@Test
	public void testHash()
	{
		LyricsItem theItem = new WordItem("abc");
		assertTrue(theHashTable.insert(theItem) != theItem);
		assertTrue(theHashTable.insert(theItem) == theHashTable.contains(theItem));
		assertTrue(theHashTable.insert(theItem).equals(theItem));
		assertTrue(theHashTable.contains(theItem).equals(theItem));
		
		LyricsItem theOtherItem = new CharacterItem("a");
		assertTrue(theHashTable.insert(theOtherItem) != theHashTable.contains(theItem));
		assertTrue(theHashTable.contains(theOtherItem) != theHashTable.contains(theItem));
	}
	
	@Test
	public void arrayTest()
	{
		LyricsItem theItem = new WordItem("abc");
		assertTrue(theArrayTable.insert(theItem) != theItem);
		assertTrue(theArrayTable.insert(theItem) == theArrayTable.contains(theItem));
		assertTrue(theArrayTable.insert(theItem).equals(theItem));
		assertTrue(theArrayTable.contains(theItem).equals(theItem));
		
		LyricsItem theOtherItem = new CharacterItem("a");
		assertTrue(theArrayTable.insert(theOtherItem) != theArrayTable.contains(theItem));
		assertTrue(theArrayTable.contains(theOtherItem) != theArrayTable.contains(theItem));
	}
}
