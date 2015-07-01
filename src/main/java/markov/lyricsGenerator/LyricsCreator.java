package markov.lyricsGenerator;


public class LyricsCreator {

	protected Dictionary theDictionary;
	protected String song = ""; // The string containing the song
	protected int songLength = 5000; // Max length of the song string
	public void setInput(Dictionary d)
	{
		theDictionary = d;
		createSong(songLength);
	}
	
	public void setSongLength(int theLength)
	{
		songLength=theLength;
	}
	public void printSong(String filename)
	{
		
	}
	public String toString()
	{
		return song;
	}
	protected void createSong(int theLength)
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
