package lyricsGenerator;

import java.util.Vector;


public class HashTable {
	
	private Vector<Vector<Sequence>> table = new Vector<Vector<Sequence>>(512);
	
	public HashTable()
	{
		table.setSize(512);
	}
	public void insertSequence(final Sequence theSequence)
	{
		int hashValue = theSequence.getHash()%512;
		
		if(table.get(hashValue)==null)
		{
			
			Vector<Sequence> tempVector = new Vector<Sequence>();
			tempVector.add(theSequence.copyMe());
			table.setElementAt(tempVector, hashValue);
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
		int index = theSequence.getHash()%512;
			
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
