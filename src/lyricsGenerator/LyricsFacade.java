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
		theParser = new CharParser();
		theDictionary = new MarkovDictionary();
		theLyricsCreator = new LyricsCreator();
		Sequence.setSequenceLength(4);
	}
	
	/* Add a song to the dictionary */
	public void addSong(String filename)
	{
		FileReader theFileReader = new FileReader();
		theFileReader.readFile(filename);
		String fileContent = theFileReader.toString();
		Vector<LyricsItem> theItems = theParser.parse(fileContent);
		theDictionary.addItemVector(theItems);
	}
	
	/* Generate a song */
	public String generateSong()
	{
		theLyricsCreator.setInput(theDictionary);
		theLyricsCreator.setSongLengt(songLength);
		return theLyricsCreator.toString();
	}
}
