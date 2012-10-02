package lyricsGenerator;

import java.util.Vector;


public class HashTable {
	
	private Vector<Vector<Sequence>> table;
	private int insertions = 0;
	private int currentSize = 0;
	private int maxSize = 512 * 512; 
	
	public HashTable()
	{
		table = new Vector<Vector<Sequence>>(512);
		table.setSize(512);
		currentSize = 512;
	}
	
	public HashTable(HashTable H)
	{
		
	}
	
	public void insertSequence(final Sequence theSequence)
	{
		int hashValue = theSequence.hashCode()%512;
		
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
			
		}
	}
	
	public int getAmount(final Sequence theSequence)
	{
		int index = theSequence.hashCode()%512;
			
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
