package markov.lyricsGenerator;

import markov.util.Hashable;

import java.util.Arrays;


public class Sequence implements Hashable{

	private final LyricsItem[] items;
	private static int sequenceLength = 4;

    private Sequence(LyricsItem[] items){
        this.items = items;
    }

    public static Sequence empty() {
        return new Sequence(new LyricsItem[] {});
    }

	public Sequence push(LyricsItem theItem)
	{
        if(items.length > sequenceLength - 1) {
            return new Sequence(createNewSequenceFromFullSequence(theItem));
        }
        else {
            return new Sequence(createNewSequenceFromPartialSequence(theItem));
        }
	}

    private LyricsItem[] createNewSequenceFromPartialSequence(LyricsItem theItem) {
        LyricsItem[] newArray;
        newArray = new LyricsItem[items.length + 1];
        System.arraycopy(items, 0, newArray, 0, items.length);
        newArray[items.length] = theItem;
        return newArray;
    }

    private LyricsItem[] createNewSequenceFromFullSequence(LyricsItem theItem) {
        LyricsItem[] newArray;
        newArray = new LyricsItem[sequenceLength];
        System.arraycopy(items, 1, newArray, 0, items.length  - 1);
        newArray[sequenceLength - 1] = theItem;
        return newArray;
    }

    public static void setSequenceLength(int theLength)
	{
		sequenceLength = theLength;
	}

	@Override
	public int hashCode()
	{
		if(items.length == 0)
			return 42;
		int result = 0;
        for (LyricsItem item : items) {
            result = result * 31 + item.hashCode();
        }
		return result;
	}

	public boolean equals(Sequence theSequence) {
        return items.length == theSequence.items.length &&
                Arrays.equals(items, theSequence.items);

    }
	public String toString()
	{
		String returnString="";
        for (LyricsItem item : items) {
            returnString += item;
        }
		return returnString;
	}
	
	@Override
	public boolean equals(Object C)
	{
		if(C.getClass() != this.getClass())
			return false;
		Sequence tempSequence = (Sequence)C;
		return this.equals(tempSequence);
	}
	
}
