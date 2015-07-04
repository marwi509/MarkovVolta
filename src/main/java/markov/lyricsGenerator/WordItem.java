package markov.lyricsGenerator;

import java.util.Arrays;

public class WordItem implements LyricsItem{

	private char[] word;
	public WordItem(String c)
	{
		if(c.length()!=0)
		{
			word = new char[c.length()];
			word = c.toCharArray();
		}
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
