package lyricsGenerator;


public class LyricsCreator {

	protected Dictionary theDictionary;
	protected String song = ""; // The string containing the song
	protected int songLength = 5000; // Max length of the song string
	public void setInput(Dictionary d)
	{
		theDictionary = d;
		createSong(songLength);
	}
	
	public void setSongLengt(int theLength)
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
		while(song.length() < theLength)
		song+=theDictionary.getItem();
		
	}
	
}
