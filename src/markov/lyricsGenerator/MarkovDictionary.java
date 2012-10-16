package markov.lyricsGenerator;

import java.util.Random;
import java.util.Vector;

import markov.util.HashTable;


public class MarkovDictionary implements Dictionary{
	private Sequence theSequence = new Sequence();
	private HashTable<SequenceList> theSequenceListTable = new HashTable<SequenceList>(1024 * 1024);
	private Random randomGenerator = new Random();
	
	@Override
	public void addItemVector(Vector<LyricsItem> theVector) 
	{
		theSequence = new Sequence();
		for(int i=0;i<theVector.size();i++)
		{
			if(i % 50000 == 0)
				System.out.println("Item " + i + " of " + theVector.size());	
			SequenceList theSList = theSequenceListTable.insert(new SequenceList(theSequence));
			theSList.addItem(theVector.get(i));
			theSequence.push(theVector.get(i));
		}
		theSequence = new Sequence();
	}

	@Override
	public LyricsItem getItem() 
	{
		SequenceList theSList = theSequenceListTable.contains(new SequenceList(theSequence));
		if(theSList == null)
		{
			theSequence = new Sequence();
			return getItem();
		}
		int randNumber = randomGenerator.nextInt(theSList.insertions());
		
		for(int i = 0; i < theSList.size(); i ++)
		{
			if(randNumber < theSList.getItemNumber(i).getAmount())
			{
				theSequence.push(theSList.getItemNumber(i).getItem());
				return theSList.getItemNumber(i).getItem();
			}
		}
		theSequence.push(theSList.getItemNumber(theSList.size() - 1).getItem());
		return theSList.getItemNumber(theSList.size() - 1).getItem();
	}

}
