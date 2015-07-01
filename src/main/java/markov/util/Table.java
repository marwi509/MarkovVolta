package markov.util;

import java.util.Iterator;

public interface Table<Element extends Copyable & Comparable> {
	public Element contains(Element theElement);
	public Element insert(Element theElement);
	public Iterator<Element> iterator();
}
