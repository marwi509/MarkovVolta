package markov.lyricsGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * CharParser
 * implements Parser
 *
 *
 */
public class CharParser implements Parser{

	@Override
	public List<LyricsItem> parse(String theString) {
		List<LyricsItem> resultVector = new ArrayList<>();
		
		for(int i=0;i<theString.length();i++)
			resultVector.add(new CharacterItem(theString.substring(i, i+1)));
		return resultVector;
	}
	
	

}
