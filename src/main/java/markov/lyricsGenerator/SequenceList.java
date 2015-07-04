package markov.lyricsGenerator;

import markov.util.Copyable;
import markov.util.HashSetTable;
import markov.util.Hashable;
import markov.util.Table;

import java.util.Iterator;

public class SequenceList implements Hashable, Copyable<SequenceList>, Iterable<Pair> {
	private final Sequence theSequence;
	private Table<Pair> theListIndices;
	private int insertions = 0;
	
	public SequenceList(Sequence theSequenceIn)
	{
		theSequence = theSequenceIn.copyMe();
		theListIndices = new HashSetTable<>();
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
	public SequenceList copyMe() {
		return new SequenceList(theSequence, theListIndices, insertions);
	}

	@Override
	public boolean equals(Object C) {
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

