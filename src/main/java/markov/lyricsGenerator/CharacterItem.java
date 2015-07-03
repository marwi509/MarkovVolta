package markov.lyricsGenerator;

/**
 * CharacterItem
 * Implements LyricsItem.
 * The class for containing a character as an item.
 *
 */

public class CharacterItem extends LyricsItem {

	private final byte character;
	
	/**
	 * CharacterItem(String c)
	 * Create a CharacterItem from a string. Takes only the first character
	 * of the string.
	 * @param c The input string.
	 */
	public CharacterItem(String c)
	{
		if(c.length() != 0)
		{
			character = (byte)c.charAt(0);
		} else
		{
			throw new IllegalArgumentException("String must be set");
		}
	}
	/**
	 * CharacterItem copyMe()
	 * Performs a deep copy of the class
	 * @return CharacterItem the copied class
	 */
	public CharacterItem copyMe()
	{
		return new CharacterItem("" + (char) character);
	}
	
	/**
	 * boolean equals(LyricsItem item)
	 * Checks if a CharacterItem is equal to another CharacterItem
	 * @return true/false
	 */
	public boolean equals(Object item) {

		return (item instanceof CharacterItem) &&
				this.toString().equals(item.toString());
	}

	@Override
	public int hashCode()
	{
		return (int)character ;
	}
	
	public String toString() {
		return "" + (char) character;
	}

}
