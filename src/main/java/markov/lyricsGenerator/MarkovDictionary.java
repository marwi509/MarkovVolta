package markov.lyricsGenerator;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import markov.util.HashSetTable;
import markov.util.HashTable;
import markov.util.Table;

public class MarkovDictionary
    implements Dictionary {
    private Sequence theSequence = new Sequence();
    private Table<SequenceList> theSequenceListTable = new HashSetTable<>();
    private final Random randomGenerator;

    public MarkovDictionary(Random random) {
        randomGenerator = random;
    }

    @Override
    public void addItemVector(List<LyricsItem> theVector) {
        theSequence = new Sequence();
        for (int i = 0; i < theVector.size(); i++) {
            if (i % 100000 == 0)
                System.out.println("Item " + i + " of " + theVector.size());
            SequenceList theSList = theSequenceListTable.insert(new SequenceList(theSequence));
            theSList.addItem(theVector.get(i));
            theSequence.push(theVector.get(i));
        }
        theSequence = new Sequence();
    }

    @Override
    public LyricsItem getItem() {
        while( true ) {
            LyricsItem tempPair = getLyricsItem();
            if (tempPair != null) return tempPair;
        }
    }

    private LyricsItem getLyricsItem() {
        SequenceList theSList = theSequenceListTable.contains(new SequenceList(theSequence));
        if (theSList == null) {
            retryWithEmptySequence();
        } else {
            return getRandomItemFromSequence(theSList);
        }
        return null;
    }

    private LyricsItem getRandomItemFromSequence(SequenceList theSList) {
        int randNumber = randomNumber(theSList);
        int sum = 0;
        Iterator<Pair> theIterator = theSList.iterator();
        Pair tempPair = null;

        while (theIterator.hasNext()) {
            tempPair = theIterator.next();
            if (randNumber < tempPair.getAmount() + sum) {
                theSequence.push(tempPair.getItem());
                return tempPair.getItem();
            }
            sum += tempPair.getAmount();
        }
        theSequence.push(tempPair.getItem());
        return tempPair.getItem();
    }

    private int randomNumber(SequenceList theSList) {
        return randomGenerator.nextInt(theSList.insertions());
    }

    private void retryWithEmptySequence() {
        theSequence = new Sequence();
    }

}
