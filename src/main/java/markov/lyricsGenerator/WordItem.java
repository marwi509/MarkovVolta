package markov.lyricsGenerator;

import java.util.Arrays;

public final class WordItem implements LyricsItem{

	private final char[] word;

	public WordItem(String c)
	{
        word = c.toCharArray();
	}

	@Override
	public boolean equals(Object item) {

		return (item instanceof WordItem) &&
				this.toString().equals(item.toString());
	}
	
	@Override
	public int hashCode()
	{
        return Arrays.hashCode(word);
    }
	
	public String toString() {
		return new String(word) + " ";
	}
}
