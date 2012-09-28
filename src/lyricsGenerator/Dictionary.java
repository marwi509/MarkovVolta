package lyricsGenerator;

import java.util.Vector;


public abstract interface Dictionary {

	public abstract void addItemVector(Vector<LyricsItem> theVector);
	public abstract LyricsItem getItem();
	
}
