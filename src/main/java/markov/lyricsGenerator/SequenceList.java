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
		theSequence = theSequenceIn;
		theListIndices = new HashSetTable<>();
	}

    public SequenceList addItem(LyricsItem theItem)
	{
		insertions++;
        Pair pair = new Pair(theItem, 0);
        if(theListIndices.contains(pair)) {
            pair = theListIndices.get(pair);
        }

        pair = pair.withAmount(pair.getAmount() + 1);
        theListIndices.insert(pair);
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

