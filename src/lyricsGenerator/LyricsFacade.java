package lyricsGenerator;

import java.util.Vector;

import markov.util.FileReader;
import markov.util.FileStringWriter;

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
	private String song;
	private int wordSequenceLength = 1;
	private int characterSequenceLength = 4;
	
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
		Sequence.setSequenceLength(characterSequenceLength);
	}
	
	/* Set the facade to use words */
	public void setUseWord()
	{
		theParser = new WordParser();
		theDictionary = new MarkovDictionary();
		theLyricsCreator = new SimpleLyricsCreator();
		Sequence.setSequenceLength(wordSequenceLength);
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
		song = theLyricsCreator.toString();
		return theLyricsCreator.toString();
	}
	
	/* Write the song to a file */
	public void toFile(String filename)
	{
		FileStringWriter.toFile(song, filename);
	}
	
	/* Change the sequence lengths */
	public void setWordSequenceLength(int length){ wordSequenceLength  = length;}
	public void setCharacterSequenceLength(int length){ characterSequenceLength  = length;}
}
