package markov.util;

import java.util.Iterator;

public interface Table<Element extends Copyable & Comparable> {
	Element contains(Element theElement);
	Element insert(Element theElement);
	Iterator<Element> iterator();
}
