package markov.lyricsGenerator;

import java.util.Vector;

import markov.util.Comparable;
import markov.util.Copyable;
import markov.util.HashTable;
import markov.util.Hashable;
import markov.util.Table;

public class SequenceList implements Hashable{
	private Sequence theSequence;
	private Vector<Pair> theList;
	private Table<Pair> theListIndices;
	private int insertions = 0;
	
	public SequenceList(Sequence theSequenceIn)
	{
		theSequence = theSequenceIn.copyMe();
		theList = new Vector<Pair>();
		theListIndices = new HashTable<Pair>(2);
	}
	
	public void addItem(LyricsItem theItem)
	{
		insertions++;
		Pair tempPair = theListIndices.contains(new Pair(theItem, 0));
		if(tempPair != null)
		{
			int index = tempPair.getAmount();
			theList.get(index).setAmount(theList.get(index).getAmount() + 1);
		}
		else
		{
			Pair newPair = new Pair(theItem, 1);
			theList.add(newPair);
			theListIndices.insert(new Pair(theItem, theList.size() - 1));
		}
	}
	
	public Pair getItemNumber(int index)
	{
		if(index >= size())
			return null;
		return theList.get(index);
	}
	
	public int size()
	{
		return theList.size();
	}
	
	public int insertions()
	{
		return insertions;
	}
	
	public Sequence getSequence()
	{
		return theSequence;
	}

	@Override
	public Copyable copyMe() {
		SequenceList sequenceOut = new SequenceList(theSequence);
		return sequenceOut;
	}

	@Override
	public boolean equals(Comparable C) {
		if(this.getClass() != C.getClass())
			return false;
		SequenceList S = (SequenceList) C;
		return S.getSequence().equals(this.getSequence());
	}
	
	public int hashCode()
	{
		return this.getSequence().hashCode();
	}
}

