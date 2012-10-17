package markov.lyricsGenerator;
/**
 * CharacterItem
 * Implements LyricsItem.
 * The class for containing a character as an item.
 *
 */

public class CharacterItem extends LyricsItem{

	private String character;
	
	/**
	 * CharacterItem(String c)
	 * Create a CharacterItem from a string. Takes only the first character
	 * of the string.
	 * @param c The input string.
	 */
	public CharacterItem(String c)
	{
		if(c.length()!=0)
		{
			character = new String();
			character+=c.charAt(0);
		}
	}
	/**
	 * CharacterItem copyMe()
	 * Performs a deep copy of the class
	 * @return CharacterItem the copied class
	 */
	public CharacterItem copyMe()
	{
		CharacterItem tempItem = new CharacterItem(character);
		return tempItem;
	}
	
	/**
	 * boolean equals(LyricsItem item)
	 * Checks if a CharacterItem is equal to another CharacterItem
	 * @return true/false
	 */
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
