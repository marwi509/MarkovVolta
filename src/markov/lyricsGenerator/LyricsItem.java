package markov.lyricsGenerator;


public abstract class LyricsItem implements Hashable{
	public abstract LyricsItem copyMe();
	public abstract boolean equals(LyricsItem item);
	public abstract String toString();
	public abstract int hashCode();
	
	@Override
	public boolean equals(Comparable C)
	{
		if(this.getClass() != C.getClass())
			return false;
		LyricsItem tempItem = (LyricsItem)C;
		return this.equals(tempItem);
	}
}
