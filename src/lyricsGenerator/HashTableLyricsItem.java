package lyricsGenerator;

import java.util.Vector;

public class HashTableLyricsItem {
	private Vector<Vector<LyricsItem>> table;
	private int insertions = 0;
	private int currentSize = 0;
	private int maxSize = 1024 * 1024;
	private boolean fixingSize = false;
	
	public HashTableLyricsItem()
	{
		table = new Vector<Vector<LyricsItem>>(512);
		table.setSize(512);
		currentSize = 512;
	}
	
	private void FixSize()
	{
		fixingSize = true;
		if((insertions  > currentSize && currentSize * 2 <= maxSize))
		{
			Vector<Vector<LyricsItem> > tempVector = table;
			table = new Vector<Vector<LyricsItem>>(currentSize * 2);
			table.setSize(currentSize * 2);
			currentSize = currentSize * 2;
			insertions = 0;
			
			for(int i = 0; i < tempVector.size(); i ++)
			{
				if(tempVector.get(i) != null)
				{
					for(int j = 0; j < tempVector.get(i).size(); j ++)
					{
						LyricsItem tempItem = tempVector.get(i).get(j);
						
						insertItem(tempItem);
					}
				}
			}
			
		}
		fixingSize = false;
	}
	
	public void insertItem(final LyricsItem theItem)
	{
		int hashValue = theItem.hashCode()%currentSize;
		if(table.get(hashValue)==null)
		{
			
			Vector<LyricsItem> tempVector = new Vector<LyricsItem>();
			tempVector.add(theItem.copyMe());
			table.setElementAt(tempVector, hashValue);
			insertions++;
		}
		else
		{
			
			for(int i=0;i<table.get(hashValue).size();i++)
			{
				if(table.get(hashValue).get(i).equals(theItem))
				{
					return;
				}
			}
			table.get(hashValue).add(theItem.copyMe());
			insertions++;
			
		}
		if(!fixingSize)
			FixSize();;
	}
	
	public boolean contains(final LyricsItem theItem)
	{
		int index = theItem.hashCode()%currentSize;
			
			if(table.get(index)==null)
				return false;
		
		for(int i=0;i<table.get(index).size();i++)
		{
			
			if(table.get(index).get(i).equals(theItem))
				return true;
		}
		return false;
	}
}
