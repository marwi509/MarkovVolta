package markov.lyricsGenerator;

import markov.util.Copyable;
import markov.util.Hashable;

public abstract class LyricsItem implements Hashable, Copyable<LyricsItem> {
	public abstract LyricsItem copyMe();
	public abstract boolean equals(Object item);
	public abstract String toString();
	public abstract int hashCode();
}
