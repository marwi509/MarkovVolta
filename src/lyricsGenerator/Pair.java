package lyricsGenerator;


public class Pair {
	
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
	
	public int hashCode()
	{
		return item.hashCode();
	}
}
