package markov.util;

public interface Table<Element extends Copyable & Comparable> {
	public Element contains(Element theElement);
	public Element insert(Element theElement);
}
