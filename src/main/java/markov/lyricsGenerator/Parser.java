package markov.lyricsGenerator;

import java.util.List;


public interface Parser {

	List<LyricsItem> parse(String theString);
}
