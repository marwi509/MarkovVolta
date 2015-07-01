package markov.lyricsGenerator;

import java.util.Iterator;
import java.util.Vector;

import markov.util.Comparable;
import markov.util.Copyable;
import markov.util.HashTable;
import markov.util.Hashable;
import markov.util.Table;

public class SequenceList implements Hashable{
	private final Sequence theSequence;
	private Table<Pair> theListIndices;
	private int insertions = 0;
	
	public SequenceList(Sequence theSequenceIn)
	{
		theSequence = theSequenceIn.copyMe();
		theListIndices = new HashTable<>(2);
	}
	
	public SequenceList(Sequence theSequenceIn, Table<Pair> theTableIn, int insertionsIn)
	{
		theSequence = theSequenceIn.copyMe();
		theListIndices = theTableIn;
		insertions = insertionsIn;
	}
	
	public void addItem(LyricsItem theItem)
	{
		insertions++;
		Pair tempPair = theListIndices.insert(new Pair(theItem, 0));
		tempPair.setAmount(tempPair.getAmount() + 1);
	}
	
	public Iterator<Pair> iterator()
	{
		return theListIndices.iterator();
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
		SequenceList sequenceOut = new SequenceList(theSequence, theListIndices, insertions);
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

