package markov.lyricsGenerator;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import markov.util.ArrayTable;
import markov.util.HashTable;
import markov.util.Table;

import markov.util.HashSetTable;
import org.junit.Before;
import org.junit.Test;

public class TableTest {
	Table<LyricsItem> theTable;
	
	@Before
	public void Allocate()
	{
	}
	
	@Test
	public void testHash()
	{
		theTable = new HashTable<>(1024);
		tableTest();
	}
	
	@Test
	public void arrayTest()
	{
		theTable = new ArrayTable<>();
		tableTest();
	}

    @Test
    public void setTest()
    {
        theTable = new HashSetTable<>();
        tableTest();
    }

    @Test
    public void what() {
        Set<Character> set = new HashSet<>();
        set.add('a');

        assertTrue(set.contains('a'));
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
		
		Iterator<LyricsItem> theIter = theTable.iterator();
		LyricsItem tempItem = theIter.next();
		assertTrue(tempItem.equals(theItem) || tempItem.equals(theOtherItem));
		tempItem = theIter.next();
		assertTrue(tempItem.equals(theItem) || tempItem.equals(theOtherItem));
	}
}
