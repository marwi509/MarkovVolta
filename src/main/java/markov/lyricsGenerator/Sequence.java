package markov.lyricsGenerator;

import java.util.Iterator;
import java.util.LinkedList;

import markov.util.Comparable;
import markov.util.Hashable;


public class Sequence implements Hashable{

	private LinkedList<LyricsItem> items = new LinkedList<LyricsItem>();
	private static int sequenceLength = 4;
	
	public Sequence copyMe()
	{
		Sequence tempSequence = new Sequence();
		Iterator<LyricsItem> theIter = items.iterator();
		while(theIter.hasNext())
		{
			tempSequence.push(theIter.next());
		}
		return tempSequence;
	}
	public void push(LyricsItem theItem)
	{
		items.add(theItem);
		if(items.size() > sequenceLength)
			items.removeFirst();
	}
	
	public static void setSequenceLength(int theLength)
	{
		sequenceLength = theLength;
	}
	
	public int hashCode()
	{
		if(items.isEmpty())
			return 0;
		int result = 0;//items.get(0).hashCode();
		Iterator<LyricsItem> theIter = items.iterator(); 
		int counter = 0;
		while(theIter.hasNext())
		{
			result += theIter.next().hashCode()*Math.pow(2,counter+++6);
		}
		return result;
	}
	
	public LinkedList<LyricsItem> getList()
	{
		return items;
	}
	
	public boolean equals(Sequence theSequence)
	{
		LinkedList<LyricsItem> otherItems = theSequence.getList();
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
		Iterator<LyricsItem> theIter = items.iterator();
		while(theIter.hasNext())
		{
			returnString += theIter.next();
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
