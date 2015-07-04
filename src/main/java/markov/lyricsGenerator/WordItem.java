package markov.lyricsGenerator;

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
		int result = 0;
        for (char aWord : word) {
            result = result * 31 + aWord;
        }
		return result;
	}
	
	public String toString() {
		return new String(word) + " ";
	}
}
