package markov.lyricsGenerator;


class LyricsCreator {

	Dictionary theDictionary;
	String song = ""; // The string containing the song
	int songLength = 5000; // Max length of the song string

	public void setInput(Dictionary d)
	{
		theDictionary = d;
		createSong(songLength);
	}
	
	public void setSongLength(int theLength)
	{
		songLength=theLength;
	}

	public String toString()
	{
		return song;
	}

	void createSong(int theLength)
	{
		int counter = 0;
		StringBuilder theBuilder = new StringBuilder();
		while(theBuilder.length() < theLength)
		{
			if(theBuilder.length() > counter * 1000 -1)
			{
				counter++;
				System.out.println("Character " + theBuilder.length() + " of " + theLength + ".");
			}
			theBuilder.append(theDictionary.getItem());
		}
		song = theBuilder.toString();
	}
	
}
