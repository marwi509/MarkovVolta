package markov.lyricsGenerator;

import markov.util.HashSetTable;
import markov.util.Hashable;
import markov.util.Table;

import java.util.Iterator;

public final class SequenceList implements Hashable, Iterable<Pair> {
	private final Sequence theSequence;
	private final Table<Pair> theListIndices;
	private int insertions = 0;
	
	public SequenceList(Sequence theSequenceIn)
	{
		theSequence = theSequenceIn.copyMe();
		theListIndices = new HashSetTable<>();
	}

    public SequenceList addItem(LyricsItem theItem)
	{
		insertions++;
		Pair tempPair = theListIndices.insert(new Pair(theItem, 0));
		tempPair.setAmount(tempPair.getAmount() + 1);
        return this;
	}
	
	public Iterator<Pair> iterator()
	{
		return theListIndices.iterator();
	}
	
	public int insertions()
	{
		return insertions;
	}
	
	public Sequence getSequence() {
        return theSequence;
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

