package markov.lyricsGenerator;

import java.util.List;
import java.util.Vector;


public interface Dictionary {

	void addItemVector(List<LyricsItem> theVector);
	LyricsItem getItem();
	
}
