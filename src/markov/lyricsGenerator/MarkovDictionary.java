package markov.lyricsGenerator;

import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

import markov.util.HashTable;


public class MarkovDictionary implements Dictionary{
	private Sequence theSequence = new Sequence();
	private HashTable<SequenceList> theSequenceListTable = new HashTable<SequenceList>(2);
	private Random randomGenerator = new Random();
	
	@Override
	public void addItemVector(Vector<LyricsItem> theVector) 
	{
		theSequence = new Sequence();
		for(int i=0;i<theVector.size();i++)
		{
			if(i % 100000 == 0)
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
		int sum = 0;
		Iterator<Pair> theIterator = theSList.iterator();
		Pair tempPair = null;
		while(theIterator.hasNext())
		{
			tempPair = theIterator.next();
			if(randNumber < tempPair.getAmount() + sum)
			{
				theSequence.push(tempPair.getItem());
				return tempPair.getItem();
			}
			sum += tempPair.getAmount();
		}
		theSequence.push(tempPair.getItem());
		return tempPair.getItem();
	}

}
