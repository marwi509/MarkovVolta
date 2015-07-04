package markov.lyricsGenerator;

import markov.util.Hashable;

public interface LyricsItem extends Hashable {
	boolean equals(Object item);
	String toString();
	int hashCode();
}
