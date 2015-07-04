package markov.lyricsGenerator;

import markov.util.Table;
import markov.util.io.FileReader;
import markov.util.io.FileStringWriter;

import java.io.InputStream;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author Marcus Widegren
 *	LyricsFacade is the main interface for the lyricsCreator package.
 */

public class LyricsFacade {
	private Parser theParser;
	private Dictionary theDictionary;
	private LyricsCreator theLyricsCreator;
	private final static int songLength = 40000;
	private String song;
	private int wordSequenceLength = 1;
	private int characterSequenceLength = 4;
	private final Table<SequenceList> table;

	private final Random random;

	/* Standard constructor */
	public LyricsFacade(Random random, Table<SequenceList> table)
	{
		setUseCharacter();
		this.random = random;
		this.table = table;
	}
	
	/* Set the facade to use characters */
	public void setUseCharacter()
	{
		theParser = new CharParser();
		theDictionary = new MarkovDictionary(random, table);
		theLyricsCreator = new LyricsCreator();
		Sequence.setSequenceLength(characterSequenceLength);
	}
	
	/* Set the facade to use words */
	public void setUseWord()
	{
		theParser = new WordParser();
		theDictionary = new MarkovDictionary(random, table);
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
		List<LyricsItem> theItems = theParser.parse(fileContent);
		System.out.println("File content parsed.");
		
		theDictionary.addItemVector(theItems);
		System.out.println("File content added to dictionary.");
	}

	public void addSong(InputStream stream) {
		FileReader theFileReader = new FileReader();
		theFileReader.readFile(stream);
		System.out.println("File read.");

		String fileContent = theFileReader.toString();
		List<LyricsItem> theItems = theParser.parse(fileContent);
		System.out.println("File content parsed.");

		theDictionary.addItemVector(theItems);
		System.out.println("File content added to dictionary.");
	}
	
	/* Generate a song */
	public String generateSong()
	{
		theLyricsCreator.setSongLength(songLength);
		theLyricsCreator.setInput(theDictionary);
		song = theLyricsCreator.toString();
		return song;
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
