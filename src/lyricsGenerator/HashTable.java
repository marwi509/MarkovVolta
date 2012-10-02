package lyricsGenerator;

import java.util.Vector;


public class HashTable {
	
	private Vector<Vector<Sequence>> table;
	private int insertions = 0;
	private int currentSize = 0;
	private int maxSize = 1024 * 1024;
	private boolean fixingSize = false;
	
	public HashTable()
	{
		table = new Vector<Vector<Sequence>>(512);
		table.setSize(512);
		currentSize = 512;
	}
	
	private void FixSize()
	{
		fixingSize = true;
		if((insertions  > currentSize && currentSize * 2 <= maxSize))
		{
			Vector<Vector<Sequence> > tempVector = table;
			table = new Vector<Vector<Sequence>>(currentSize * 2);
			table.setSize(currentSize * 2);
			currentSize = currentSize * 2;
			insertions = 0;
			
			for(int i = 0; i < tempVector.size(); i ++)
			{
				if(tempVector.get(i) != null)
				{
					for(int j = 0; j < tempVector.get(i).size(); j ++)
					{
						Sequence tempSequence = tempVector.get(i).get(j);
						
						insertSequence(tempSequence);
					}
				}
			}
			
		}
		fixingSize = false;
	}
	
	public void insertSequence(final Sequence theSequence)
	{
		int hashValue = theSequence.hashCode()%currentSize;
		if(table.get(hashValue)==null)
		{
			
			Vector<Sequence> tempVector = new Vector<Sequence>();
			tempVector.add(theSequence.copyMe());
			table.setElementAt(tempVector, hashValue);
			insertions++;
		}
		else
		{
			
			for(int i=0;i<table.get(hashValue).size();i++)
			{
				if(table.get(hashValue).get(i).equals(theSequence))
				{
					table.get(hashValue).get(i).increment();
					return;
				}
			}
			table.get(hashValue).add(theSequence.copyMe());
			insertions++;
			
		}
		if(!fixingSize)
			FixSize();;
	}
	
	public int getAmount(final Sequence theSequence)
	{
		int index = theSequence.hashCode()%currentSize;
			
			if(table.get(index)==null)
				return 0;
		
		for(int i=0;i<table.get(index).size();i++)
		{
			
			if(table.get(index).get(i).equals(theSequence))
				return table.get(index).get(i).getAmount();
		}
		return 0;
	}
}
