package markov.lyricsGenerator;

import markov.util.HashTable;



public class SequenceProb {
	
	private LyricsItem item;
	private HashTable<Sequence> table = new HashTable<Sequence>(1024);
	
	public SequenceProb(LyricsItem theItem, final Sequence theSequence)
	{
		item = theItem;
		Sequence tempSequence = table.insert(theSequence);
		tempSequence.increment();
	}
	public void addSequence(final Sequence theSequence)
	{
		Sequence tempSequence = table.insert(theSequence);
		tempSequence.increment();
	}
	public int getAmount(final Sequence theSequence)
	{
		Sequence tempSequence =  table.contains(theSequence);
		if(tempSequence == null)
			return 0;
		return tempSequence.getAmount();
		
	}
	public LyricsItem getItem()
	{
		return item;
	}
}
