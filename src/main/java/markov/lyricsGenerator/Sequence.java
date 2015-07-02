package markov.lyricsGenerator;

import markov.util.Comparable;
import markov.util.Hashable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Sequence implements Hashable{

	private List<LyricsItem> items = new ArrayList<>();
	private static int sequenceLength = 4;

    public Sequence copyMe()
	{
		Sequence tempSequence = new Sequence();
        for (LyricsItem item : items) {
            tempSequence.push(item);
        }
		return tempSequence;
	}
	public void push(LyricsItem theItem)
	{
		items.add(theItem);
		if(items.size() > sequenceLength)
			items.remove(0);
	}
	
	public static void setSequenceLength(int theLength)
	{
		sequenceLength = theLength;
	}

	@Override
	public int hashCode()
	{
		if(items.isEmpty())
			return 0;
		int result = 0;//items.get(0).hashCode();
        for (LyricsItem item : items) {
            result = result * 31 + item.hashCode();
        }
		return result;
	}
	
	public List<LyricsItem> getList()
	{
		return items;
	}
	
	public boolean equals(Sequence theSequence)
	{
		List<LyricsItem> otherItems = theSequence.getList();
		if(items.size()!=otherItems.size())
			return false;
		
		Iterator<LyricsItem> theIter = items.iterator();
		Iterator<LyricsItem> theOtherIter = theSequence.getList().iterator();
		while(theIter.hasNext())
		{
			if(!theIter.next().equals(theOtherIter.next()))
				return false;
		}
		return true;
	}
	public String toString()
	{
		String returnString="";
        for (LyricsItem item : items) {
            returnString += item;
        }
		return returnString;
	}
	
	@Override
	public boolean equals(Comparable C) 
	{
		if(C.getClass() != this.getClass())
			return false;
		Sequence tempSequence = (Sequence)C;
		return this.equals(tempSequence);
	}
	
}
