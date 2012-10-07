package lyricsGenerator;

import java.util.Vector;

/**
 * 
 * @author Marcus Widegren
 *	LyricsFacade is the main interface for the lyricsCreator package.
 */

public class LyricsFacade {
	private Parser theParser;
	private Dictionary theDictionary;
	private LyricsCreator theLyricsCreator;
	private int songLength = 200;
	
	/* Standard constructor */
	public LyricsFacade()
	{
		setUseCharacter();
	}
	
	/* Set the facade to use characters */
	public void setUseCharacter()
	{
		theParser = new CharParser();
		theDictionary = new MarkovDictionary();
		theLyricsCreator = new LyricsCreator();
		Sequence.setSequenceLength(4);
	}
	
	/* Set the facade to use words */
	public void setUseWord()
	{
		theParser = new WordParser();
		theDictionary = new MarkovDictionary();
		theLyricsCreator = new SimpleLyricsCreator();
		Sequence.setSequenceLength(1);
	}
	
	/* Add a song to the dictionary */
	public void addSong(String filename)
	{
		FileReader theFileReader = new FileReader();
		theFileReader.readFile(filename);
		System.out.println("File read.");
		
		String fileContent = theFileReader.toString();
		Vector<LyricsItem> theItems = theParser.parse(fileContent);
		System.out.println("File content parsed.");
		
		theDictionary.addItemVector(theItems);
		System.out.println("File content added to dictionary.");
	}
	
	/* Generate a song */
	public String generateSong()
	{
		theLyricsCreator.setInput(theDictionary);
		theLyricsCreator.setSongLengt(songLength);
		return theLyricsCreator.toString();
	}
	
	public void setSequenceLength(int length)
	{
		Sequence.setSequenceLength(length);
	}
}
