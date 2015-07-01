package markov.lyricsGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;


public class WordParser implements Parser{

	@Override
	public List<LyricsItem> parse(String theString) {
		List<LyricsItem> resultVector = new ArrayList<>();
		StringTokenizer tokenizer = new StringTokenizer(theString);
		while(tokenizer.hasMoreTokens())
		{	
			resultVector.add(new WordItem(tokenizer.nextToken()));
			
		}
		
		return resultVector;
	}

}
