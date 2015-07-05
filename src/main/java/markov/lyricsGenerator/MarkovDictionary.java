package markov.lyricsGenerator;

import markov.util.Table;

import java.util.List;
import java.util.Random;

public final class MarkovDictionary
    implements Dictionary {
    private final Table<SequenceList> theSequenceListTable;
    private final Random randomGenerator;
    private Sequence currentSequence;

    public MarkovDictionary(Random random, Table<SequenceList> table) {

        randomGenerator = random;
        this.theSequenceListTable = table;
        currentSequence = Sequence.empty();
    }

    @Override
    public void addItemVector(List<LyricsItem> lyricsItems) {
        Sequence theSequence = Sequence.empty();
        for (int i = 0; i < lyricsItems.size(); i++) {
            if (i % 100000 == 0)
                System.out.println("Item " + i + " of " + lyricsItems.size());
            SequenceList sList = new SequenceList(theSequence);
            if(theSequenceListTable.contains(sList)) {
                sList = theSequenceListTable.get(sList);
            }

            sList.addItem(lyricsItems.get(i));
            theSequenceListTable.insert(sList);
            theSequence = theSequence.push(lyricsItems.get(i));
        }
    }

    @Override
    public LyricsItem getItem() {
        SequenceList sequenceList = new SequenceList(currentSequence);
        if (theSequenceListTable.contains(sequenceList)) {
            sequenceList = theSequenceListTable.get(sequenceList);
        } else {
            sequenceList = retryWithEmptySequence();
        }
        return getRandomItemFromSequence(sequenceList);
    }

    private LyricsItem getRandomItemFromSequence(SequenceList theSList) {
        int randNumber = randomNumber(theSList);
        int sum = 0;

        for(Pair pair : theSList) {

            if (randNumber < pair.getAmount() + sum) {
                currentSequence = currentSequence.push(pair.getItem());
                return pair.getItem();
            }

            sum += pair.getAmount();
        }

        throw new RuntimeException("Should be unreachable code");
    }

    private int randomNumber(SequenceList theSList) {
        return randomGenerator.nextInt(theSList.insertions());
    }

    private SequenceList retryWithEmptySequence() {
        currentSequence = Sequence.empty();
        return theSequenceListTable.get(new SequenceList(currentSequence));
    }

}
