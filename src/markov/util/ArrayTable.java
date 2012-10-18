package markov.util;

import java.util.Iterator;
import java.util.Vector;

public class ArrayTable<Element extends Copyable & Comparable> implements Table<Element>{
	private Vector<Element> theList;
	
	public ArrayTable()
	{
		theList = new Vector<Element>();
	}
	
	@Override
	public Element contains(Element theElement) {
		for(int i = 0; i < theList.size(); i ++)
		{
			if(theElement.equals(theList.get(i)))
			{
				return theList.get(i);
			}
		}
		return null;
	}

	@Override
	public Element insert(Element theElement) {
		for(int i = 0; i < theList.size(); i ++)
		{
			if(theElement.equals(theList.get(i)))
			{
				return theList.get(i);
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
