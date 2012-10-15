package markov.lyricsGenerator;

import static org.junit.Assert.*;
import markov.util.ArrayTable;
import markov.util.HashTable;
import markov.util.Table;

import org.junit.Before;
import org.junit.Test;

public class TableTest {
	HashTable<LyricsItem> theHashTable;
	ArrayTable<LyricsItem> theArrayTable;
	Table<LyricsItem> theTable;
	
	@Before
	public void Allocate()
	{
		theHashTable = new HashTable<LyricsItem>(128);
		theArrayTable = new ArrayTable<LyricsItem>();
	}
	
	@Test
	public void testHash()
	{
		theTable = new HashTable<LyricsItem>(1024);
		tableTest();
	}
	
	@Test
	public void arrayTest()
	{
		theTable = new ArrayTable<LyricsItem>();
		tableTest();
	}
	
	public void tableTest()
	{
		LyricsItem theItem = new WordItem("abc");
		assertTrue(theTable.insert(theItem) != theItem);
		assertTrue(theTable.insert(theItem) == theTable.contains(theItem));
		assertTrue(theTable.insert(theItem).equals(theItem));
		assertTrue(theTable.contains(theItem).equals(theItem));
		
		LyricsItem theOtherItem = new CharacterItem("a");
		assertTrue(theTable.insert(theOtherItem) != theTable.contains(theItem));
		assertTrue(theTable.contains(theOtherItem) != theTable.contains(theItem));
	}
}
