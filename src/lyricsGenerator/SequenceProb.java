package lyricsGenerator;



public class SequenceProb {
	
	private LyricsItem item;
	private HashTable table = new HashTable();
	
	public SequenceProb(LyricsItem theItem, final Sequence theSequence)
	{
		item = theItem;
		table.insertSequence(theSequence);
	}
	public void addSequence(final Sequence theSequence)
	{
		table.insertSequence(theSequence);
	}
	public int getAmount(final Sequence theSequence)
	{
		return table.getAmount(theSequence);
	}
	public LyricsItem getItem()
	{
		return item;
	}
}
