package markov.lyricsGenerator;

import markov.util.Hashable;

public final class Pair implements Hashable{
	
	private final LyricsItem item;
	private final int amount;
	
	public Pair(LyricsItem theItem,int theInt) {
		item = theItem;
		amount = theInt;
	}

    public Pair withAmount(int a) {

		return new Pair(item, a);
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
	public boolean equals(Object C)
	{
		if(C.getClass() != this.getClass())
			return false;
		Pair tempPair = (Pair)C;
		return this.getItem().equals(tempPair.getItem());
	}
}
