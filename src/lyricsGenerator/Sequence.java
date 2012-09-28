package lyricsGenerator;

import java.util.LinkedList;


public class Sequence {

	private LinkedList<LyricsItem> items = new LinkedList<LyricsItem>();
	private static int sequenceLength = 4;
	private int amount = 1;
	
	public Sequence copyMe()
	{
		Sequence tempSequence = new Sequence();
		tempSequence.setSequenceLength(sequenceLength);
		for(int i=0;i<items.size();i++)
		{
			tempSequence.push(items.get(i).copyMe());
		}
		return tempSequence;
	}
	public void push(LyricsItem theItem)
	{
		if(items.size() >= sequenceLength)
			items.removeFirst();
		
		items.add(theItem);
	}
	
	public void increment()
	{
		amount++;
	}
	public void setSequenceLength(int theLength)
	{
		sequenceLength = theLength;
	}
	
	public int getHash()
	{
		if(items.isEmpty())
			return 0;
		int result=items.get(0).getHash();
		for(int i=1;i<items.size();i++)
		{
			result+=items.get(i).getHash()*Math.pow(2,i);
		}
		return result;
	}
	public int getAmount()
	{
		return amount;
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
		
		for(int i=0;i<items.size();i++) // Compare each element in the list
		{
			if(!items.get(i).equals(otherItems.get(i)))
				return false;
		}
		return true;
	}
	public String toString()
	{
		String returnString="";
		for(int i=0;i<items.size();i++)
		{
			returnString+=items.get(i);
		}
		return returnString;
	}
	
}
