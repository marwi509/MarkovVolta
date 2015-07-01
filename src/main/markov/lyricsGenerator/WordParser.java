package markov.lyricsGenerator;

import java.util.StringTokenizer;
import java.util.Vector;


public class WordParser implements Parser{

	@Override
	public Vector<LyricsItem> parse(String theString) {
		Vector<LyricsItem> resultVector = new Vector<LyricsItem>();
		StringTokenizer tokenizer = new StringTokenizer(theString);
		while(tokenizer.hasMoreTokens())
		{	
			resultVector.add(new WordItem(tokenizer.nextToken()));
			
		}
		
		return resultVector;
	}

}
