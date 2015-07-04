package markov.util;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class HashTable<Element extends Hashable>  implements Table<Element>{
	
	private List<List<Element>> table;
	private int insertions = 0;
	private int currentSize = 0;
	private static final int maxSize = 1024 * 1024 * 1024;
	private boolean fixingSize = false;

	public HashTable(int startSize)
	{
		table = new ArrayList<>(startSize);
		for(int i = 0; i < startSize; i ++)
			table.add(null);
		currentSize = startSize;
	}
	
	private void addToTable(List<Element> theList, int index)
	{
		table.remove(index);
		table.add(index, theList);
	}
	
	private void FixSize()
	{
		fixingSize = true;
		if((insertions > currentSize && currentSize * 2 <= maxSize))
		{
			List<List<Element> > tempVector = table;
			table = new ArrayList<>(currentSize * 2);
			for(int i = 0; i < currentSize * 2; i ++)
				table.add(null);
			currentSize = currentSize * 2;
			insertions = 0;

            for (List<Element> aTempVector : tempVector) {
                if (aTempVector != null) {
                    for (Element tempElement : aTempVector) {
                        insert(tempElement);
                    }
                }
            }
            for (List<Element> aTempVector : tempVector) {
                if (aTempVector != null)
                    aTempVector.clear();
            }
			tempVector.clear();

		}
		fixingSize = false;
	}
	
	
	public Element insert(final Element theElement)
	{
		if(!fixingSize)
			FixSize();

        int hashValue = getIndex(theElement);
		if(table.get(hashValue)==null)
		{
			
			List<Element> tempVector = new ArrayList<>();
			tempVector.add(theElement);
			//table.add(hashValue, tempVector);
			addToTable(tempVector, hashValue);
			insertions++;
			return tempVector.get(0);
		}
		else
		{
            for (Element temp : table.get(hashValue)) {
                if (temp.equals(theElement))
                    return temp;
            }

			table.get(hashValue).add(theElement);
			insertions++;
			return table.get(hashValue).get(table.get(hashValue).size()-1);
			
		}
	}

    private int getIndex(Element theElement) {
        int hash = theElement.hashCode();
        if(hash < 0) hash = hash * -1;
        return hash % currentSize;
    }


    public Element contains(final Element theElement)
	{
		int index = getIndex(theElement);
			
		if(table.get(index)==null)
		{
			return null;
		}

        for (Element temp : table.get(index)) {
            if (temp.equals(theElement))
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
			if(theLocalIterator != null && theLocalIterator.hasNext())
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
