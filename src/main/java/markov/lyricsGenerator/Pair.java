package markov.lyricsGenerator;

import markov.util.Comparable;
import markov.util.Hashable;

public class Pair implements Hashable{
	
	private LyricsItem item;
	private int amount;
	
	public Pair(LyricsItem theItem,int theInt)
	{
		item = theItem;
		amount = theInt;
	}

    public void setAmount(int a)
	{
		amount = a;
	}
	
	public void addAmount(int a)
	{
		amount+=a;
	}
	
	public LyricsItem getItem()
	{
		return item;
	}
	
	public int getAmount()
	{
		return amount;
	}
	
	@Override
	public int hashCode()
	{
		int res = item.hashCode();
		return res > 0 ? res : res * -1;
	}
	
	@Override
	public Pair copyMe()
	{
		return new Pair(item.copyMe(), amount);
	}
	
	@Override
	public boolean equals(Comparable C) 
	{
		if(C.getClass() != this.getClass())
			return false;
		Pair tempPair = (Pair)C;
		return this.getItem().equals(tempPair.getItem());
	}
}
