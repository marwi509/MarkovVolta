package markov.util;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Vector;


public class HashTable<Element extends Hashable> implements Table<Element>{
	
	private Vector<LinkedList<Element>> table;
	private int insertions = 0;
	private int currentSize = 0;
	private int maxSize = 1024 * 1024;
	private boolean fixingSize = false;
	
	public HashTable(int startSize)
	{
		table = new Vector<LinkedList<Element>>(startSize);
		table.setSize(startSize);
		currentSize = startSize;
	}
	
	private void FixSize()
	{
		fixingSize = true;
		if((insertions > currentSize && currentSize * 2 <= maxSize))
		{
			Vector<LinkedList<Element> > tempVector = table;
			table = new Vector<LinkedList<Element>>(currentSize * 2);
			table.setSize(currentSize * 2);
			currentSize = currentSize * 2;
			insertions = 0;
			
			for(int i = 0; i < tempVector.size(); i ++)
			{
				if(tempVector.get(i) != null)
				{
					for(int j = 0; j < tempVector.get(i).size(); j ++)
					{
						Element tempElement = tempVector.get(i).get(j);
						
						insert(tempElement);
					}
				}
			}
			for(int i = 0; i < tempVector.size(); i ++)
			{
				if(tempVector.get(i) != null)
					tempVector.get(i).clear();
			}
			tempVector.clear();

		}
		fixingSize = false;
	}
	
	
	public Element insert(final Element theElement)
	{
		if(!fixingSize)
			FixSize();
		
		int hashValue = theElement.hashCode() % currentSize;
		if(table.get(hashValue)==null)
		{
			
			LinkedList<Element> tempVector = new LinkedList<Element>();
			tempVector.add((Element)theElement.copyMe());
			table.setElementAt(tempVector, hashValue);
			insertions++;
			return tempVector.get(0);
		}
		else
		{
			ListIterator<Element> iter = table.get(hashValue).listIterator();
			while(iter.hasNext())
			{
				Element temp = iter.next();
				if(temp.equals(theElement))
					return temp;
			}

			table.get(hashValue).add((Element)theElement.copyMe());
			insertions++;
			return table.get(hashValue).get(table.get(hashValue).size()-1);
			
		}
	}
	
	
	public Element contains(final Element theElement)
	{
		int index = theElement.hashCode() % currentSize;
			
		if(table.get(index)==null)
		{
			return null;
		}
		
		ListIterator<Element> iter = table.get(index).listIterator();
		while(iter.hasNext())
		{
			Element temp = iter.next();
			if(temp.equals(theElement))
				return temp;
		}
		return null;
	}
	
	private class HashIterator implements Iterator<Element>
	{
		int index = 0;
		Iterator<Element> theLocalIterator;
		
		@Override
		public boolean hasNext() {
			if(theLocalIterator == null)
			{
				if(table.get(index) != null)
				{
					theLocalIterator = table.get(index).listIterator();
				}
			}
			if(theLocalIterator != null && theLocalIterator.hasNext() == true)
				return true;
			for(int i = index + 1; i < table.size(); i ++)
			{
				if(table.get(i) != null)
				{
					index = i;
					theLocalIterator = table.get(i).listIterator();
					return true;
				}
			}
			return false;
		}

		@Override
		public Element next() {
			hasNext();
			return theLocalIterator.next();
		}

		@Override
		public void remove() {
			// Stub
			
		}
		
	}

	@Override
	public Iterator<Element> iterator() {
		return this.new HashIterator();
	}
}
