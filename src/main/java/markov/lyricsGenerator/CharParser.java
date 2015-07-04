package markov.lyricsGenerator;

import java.util.ArrayList;
import java.util.List;

public class CharParser implements Parser{

	@Override
	public List<LyricsItem> parse(String theString) {
		List<LyricsItem> resultVector = new ArrayList<>(theString.length());

		for(char c : theString.toCharArray()) {
            resultVector.add(new CharacterItem(c));
        }

		return resultVector;
	}
	
	

}
