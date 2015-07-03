package markov.lyricsGenerator;

public class WordItem extends LyricsItem{

	private char[] word;
	public WordItem(String c)
	{
		if(c.length()!=0)
		{
			word = new char[c.length()];
			word = c.toCharArray();
		}
	}
	
	public WordItem copyMe()
	{
		return new WordItem(new String(word));
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
		for(int i = 0; i < word.length; i++)
		{
			result += word[i] * Math.pow(2,i+3);
		}
		return result;
	}
	
	public String toString() {
		return new String(word) + " ";
	}
}
