package markov.lyricsGenerator;

import markov.util.Table;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MarkovDictionary
    implements Dictionary {
    private Sequence theSequence = new Sequence();
    private final Table<SequenceList> theSequenceListTable;
    private final Random randomGenerator;

    public MarkovDictionary(Random random, Table table) {

        randomGenerator = random;
        this.theSequenceListTable = table;
    }

    @Override
    public void addItemVector(List<LyricsItem> lyricsItems) {
        theSequence = new Sequence();
        for (int i = 0; i < lyricsItems.size(); i++) {
            if (i % 100000 == 0)
                System.out.println("Item " + i + " of " + lyricsItems.size());
            SequenceList theSList = theSequenceListTable.insert(new SequenceList(theSequence));
            theSList.addItem(lyricsItems.get(i));
            theSequence.push(lyricsItems.get(i));
        }
        theSequence = new Sequence();
    }

    @Override
    public LyricsItem getItem() {
        SequenceList theSList = theSequenceListTable.contains(new SequenceList(theSequence));
        if (theSList == null) {
            theSList = retryWithEmptySequence();
        }
        return getRandomItemFromSequence(theSList);
    }

    private LyricsItem getRandomItemFromSequence(SequenceList theSList) {
        int randNumber = randomNumber(theSList);
        int sum = 0;
        Iterator<Pair> theIterator = theSList.iterator();
        Pair tempPair;

        while (theIterator.hasNext()) {
            tempPair = theIterator.next();

            if (randNumber < tempPair.getAmount() + sum) {
                theSequence.push(tempPair.getItem());
                return tempPair.getItem();
            }

            sum += tempPair.getAmount();
        }

        throw new RuntimeException("Should be unreachable code");
    }

    private int randomNumber(SequenceList theSList) {
        return randomGenerator.nextInt(theSList.insertions());
    }

    private SequenceList retryWithEmptySequence() {
        theSequence = new Sequence();
        return theSequenceListTable.contains(new SequenceList(theSequence));
    }

}
