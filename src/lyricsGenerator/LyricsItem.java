package lyricsGenerator;


public abstract interface LyricsItem {

	public abstract LyricsItem copyMe();
	public abstract boolean equals(LyricsItem item);
	public abstract String toString();
	public int hashCode();
}
