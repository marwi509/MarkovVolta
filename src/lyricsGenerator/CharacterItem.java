package lyricsGenerator;


public class CharacterItem implements LyricsItem{

	private String character;
	public CharacterItem(String c)
	{
		if(!c.isEmpty())
		{
			character = new String();
			character+=c.charAt(0);
		}
	}
	
	public CharacterItem copyMe()
	{
		CharacterItem tempItem = new CharacterItem(character);
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
		return character.charAt(0);
	}
	
	public String toString() {
		return character;
	}

}
