package lyricsGenerator;

import java.util.Vector;


public abstract interface Parser {

	public abstract Vector<LyricsItem> parse(String theString);
}
