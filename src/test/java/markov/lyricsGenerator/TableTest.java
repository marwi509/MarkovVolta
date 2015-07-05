package markov.lyricsGenerator;

import markov.util.ArrayTable;
import markov.util.HashSetTable;
import markov.util.Table;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertTrue;

public class TableTest {
	Table<LyricsItem> theTable;
	
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

	public void tableTest()
	{
		LyricsItem theItem = new WordItem("abc");
		theTable.insert(theItem);
		assertTrue(theTable.insert(theItem) == theTable.get(theItem));
		assertTrue(theTable.insert(theItem).equals(theItem));
		assertTrue(theTable.get(theItem).equals(theItem));
		
		LyricsItem theOtherItem = new CharacterItem('a');
		assertTrue(theTable.insert(theOtherItem) != theTable.get(theItem));
		assertTrue(theTable.get(theOtherItem) != theTable.get(theItem));
		
		Iterator<LyricsItem> theIter = theTable.iterator();
		LyricsItem tempItem = theIter.next();
		assertTrue(tempItem.equals(theItem) || tempItem.equals(theOtherItem));
		tempItem = theIter.next();
		assertTrue(tempItem.equals(theItem) || tempItem.equals(theOtherItem));
	}
}
