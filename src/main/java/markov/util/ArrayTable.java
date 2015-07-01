package markov.util;

import java.util.Iterator;
import java.util.Vector;

public class ArrayTable<Element extends Copyable & Comparable> implements Table<Element>{
	private Vector<Element> theList;
	
	public ArrayTable()
	{
		theList = new Vector<>();
	}
	
	@Override
	public Element contains(Element theElement) {
		for (Element aTheList : theList) {
			if (theElement.equals(aTheList)) {
				return aTheList;
			}
		}
		return null;
	}

	@Override
	public Element insert(Element theElement) {
		for (Element aTheList : theList) {
			if (theElement.equals(aTheList)) {
				return aTheList;
			}
		}
		theList.add((Element)theElement.copyMe());
		return theList.get(theList.size()-1);
	}

	@Override
	public Iterator<Element> iterator() {
		return theList.iterator();
	}

}
