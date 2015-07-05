package markov.lyricsGenerator;

/**
 * CharacterItem
 * Implements LyricsItem.
 * The class for containing a character as an item.
 *
 */

public final class CharacterItem implements LyricsItem {

	private final char character;

    public CharacterItem(char c)
    {
        character = c;
    }

    @Override
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
		return "" + character;
	}

}
