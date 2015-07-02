package markov.lyricsGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * charDictionary
 * Implements Dictionary.
 * The class for keeping a dictionary with characters and the number
 * of occurrences of each character. This is kept in a Vector of the class Pair
 */
public class CharDictionary implements Dictionary {

    private List<Pair> theDictionary = new ArrayList<>(); // The dictionary with characters and number of occurrences.
    private int totalItems = 0;
    private Random randomGenerator = new Random();

    /**
     * void addItemVector(Vector<LyricsItem> theVector)
     * Adds a Vector with LyricsItem to the dictionary
     *
     * @param theVector - A Vector containing LyricsItems
     */
    @Override
    public void addItemVector(List<LyricsItem> theVector) {

        for (LyricsItem aTheVector : theVector) {
            //System.out.println(theVector.elementAt(i));
            addItem(aTheVector);
        }
    }

    /**
     * void addItem(LyricsItem item)
     * Adds a LyricsItem to the dictionary. If the LyricsItem already exists in
     * the dictionary. The number of occurrences is incremented. At the end the
     * total number of items in the dictionary is incremented.
     */
    private void addItem(LyricsItem item) {
        theDictionary.stream()
                .filter(p -> p.equals(item))
                .findFirst().get()
                .addAmount(1);

        theDictionary.add(new Pair(item, 1));
        totalItems++;
    }

    /**
     * LyricsItem getItem()
     * Returns a LyricsItem from the dictionary. The LyricsItem is obtained by
     * creating a random number between 0 and 1 and returning the character in the right interval
     *
     * @return LyricsItem a LyricsItem
     */
    public LyricsItem getItem() {
        float randomNumber = randomGenerator.nextFloat();
        float lowerLimit = 0;
        float upperLimit = (float) theDictionary.get(0).getAmount() / (float) totalItems;

        // Create an upper an lower limit using the number of occurrences of each
        // character. If the random number is inbetween these values, return the
        // current character.
        for (int i = 0; i < theDictionary.size() - 1; i++) {

            if (randomNumber > lowerLimit && randomNumber < upperLimit)
                return theDictionary.get(i).getItem();

            lowerLimit += (float) theDictionary.get(i).getAmount() / (float) totalItems;
            upperLimit = lowerLimit + (float) theDictionary.get(i + 1).getAmount() / (float) totalItems;


        }
        return theDictionary.get(theDictionary.size() - 1).getItem();
    }


}
