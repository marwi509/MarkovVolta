package markov.lyricsGenerator;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import markov.util.HashTable;
import markov.util.Table;

public class MarkovDictionary
    implements Dictionary {
    private Sequence theSequence = new Sequence();
    private Table<SequenceList> theSequenceListTable = new HashSetTable<>();
    private final Random randomGenerator = new Random();

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
        SequenceList theSList = theSequenceListTable.contains(new SequenceList(theSequence));
        if (theSList == null) {
            //throw new RuntimeException("WHAT?!");
            theSequence = new Sequence();
            return getItem();
        }
        int randNumber = randomGenerator.nextInt(theSList.insertions());
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

}
