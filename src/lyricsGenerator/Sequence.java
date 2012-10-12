package lyricsGenerator;

import java.util.LinkedList;


public class Sequence implements Hashable{

	private LinkedList<LyricsItem> items = new LinkedList<LyricsItem>();
	private static int sequenceLength = 4;
	private int amount = 0;
	
	public Sequence copyMe()
	{
		Sequence tempSequence = new Sequence();
		for(int i=0;i<items.size();i++)
		{
			tempSequence.push(items.get(i).copyMe());
		}
		tempSequence.setAmount(amount);
		return tempSequence;
	}
	public void push(LyricsItem theItem)
	{
		items.add(theItem);
		if(items.size() > sequenceLength)
			items.removeFirst();
	}
	
	public void increment()
	{
		amount++;
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
		for(int i=0;i<items.size();i++)
		{
			result+=items.get(i).hashCode()*Math.pow(2,i+6);
		}
		return result;
	}
	
	public int getAmount()
	{
		return amount;
	}
	public void setAmount(int amountIn)
	{
		amount = amountIn;
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
	
	@Override
	public boolean equals(Comparable C) 
	{
		if(C.getClass() != this.getClass())
			return false;
		Sequence tempSequence = (Sequence)C;
		return this.equals(tempSequence);
	}
	
}
