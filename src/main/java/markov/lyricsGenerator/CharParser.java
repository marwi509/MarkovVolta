package markov.lyricsGenerator;
import java.util.Vector;

/**
 * CharParser
 * implements Parser
 *
 *
 */
public class CharParser implements Parser{

	@Override
	public Vector<LyricsItem> parse(String theString) {
		Vector<LyricsItem> resultVector = new Vector<LyricsItem>();
		
		for(int i=0;i<theString.length();i++)
			resultVector.add(new CharacterItem(theString.substring(i, i+1)));
		return resultVector;
	}
	
	

}
