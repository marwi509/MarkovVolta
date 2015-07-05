package markov.util;

import java.util.Iterator;

public interface Table<Element> {
	Element get(Element theElement);
	Element insert(Element theElement);
	Iterator<Element> iterator();
	boolean contains(Element element);
}
