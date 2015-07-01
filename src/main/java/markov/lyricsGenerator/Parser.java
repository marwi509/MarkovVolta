package markov.lyricsGenerator;

import java.util.List;


public abstract interface Parser {

	List<LyricsItem> parse(String theString);
}
