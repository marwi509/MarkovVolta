package markov.lyricsGenerator;

public class WordItem extends LyricsItem{

	private String word;
	public WordItem(String c)
	{
		if(c.length()!=0)
		{
			word = new String(c);
		}
	}
	
	public WordItem copyMe()
	{
		WordItem tempItem = new WordItem(new String(word));
		return tempItem;
	}
	public boolean equals(LyricsItem item) {
		if(this.toString().equals(item.toString()))
			return true;
		else
			return false;
	}
	
	
	public int hashCode()
	{
		int result = 0;//word.charAt(0);
		for(int i = 0;i<word.length();i++)
		{
			result+=word.charAt(i)*Math.pow(2,i+3);
		}
		return result;
	}
	
	public String toString() {
		return word+" ";
	}


}
