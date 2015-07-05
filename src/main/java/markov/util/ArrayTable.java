package markov.util;

import java.util.Iterator;
import java.util.Vector;

public class ArrayTable<Element> implements Table<Element>{
	private Vector<Element> theList;
	
	public ArrayTable()
	{
		theList = new Vector<>();
	}
	
	@Override
	public Element get(Element theElement) {
		for (Element aTheList : theList) {
			if (theElement.equals(aTheList)) {
				return aTheList;
			}
		}
		throw new IllegalStateException(theElement + " was not in the list");
	}

	@Override
	public Element insert(Element theElement) {
		theList.add(theElement);
		return theList.get(theList.size()-1);
	}

	@Override
	public Iterator<Element> iterator() {
		return theList.iterator();
	}

	@Override
	public boolean contains(Element element) {
		return theList.contains(element);
	}

}
