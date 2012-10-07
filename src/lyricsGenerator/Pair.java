package lyricsGenerator;


public class Pair implements Hashable{
	
	private LyricsItem item;
	private int amount;
	
	public Pair(LyricsItem theItem,int theInt)
	{
		item = theItem;
		amount = theInt;
	}
	public void setChar(LyricsItem theItem)
	{
		item = theItem;
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
		return item.hashCode();
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
