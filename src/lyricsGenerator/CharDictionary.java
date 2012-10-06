package lyricsGenerator;

import java.util.Random;
import java.util.Vector;

/**
 * charDictionary
 * Implements Dictionary.
 * The class for keeping a dictionary with characters and the number
 * of occurrences of each character. This is kept in a Vector of the class Pair
 *
 */
public class CharDictionary implements Dictionary{

	private Vector<Pair> theDictionary = new Vector<Pair>(); // The dictionary with characters and number of occurrences.
	private int totalItems = 0;
	private Random randomGenerator = new Random();
	/**
	 * void addItemVector(Vector<LyricsItem> theVector)
	 * Adds a Vector with LyricsItem to the dictionary
	 * @param theVector - A Vector containing LyricsItems
	 */
	@Override
	public void addItemVector(Vector<LyricsItem> theVector) {
		
		for(int i=0;i<theVector.size();i++)
		{
			//System.out.println(theVector.elementAt(i));
			addItem(theVector.elementAt(i));
		}
	}
	/**
	 * void addItem(LyricsItem item)
	 * Adds a LyricsItem to the dictionary. If the LyricsItem already exists in 
	 * the dictionary. The number of occurrences is incremented. At the end the
	 * total number of items in the dictionary is incremented.
	 * @param item
	 */
	private void addItem(LyricsItem item) {
		boolean itemFound=false;
		for(int i=0;i<theDictionary.size();i++)
		{
			if(item.equals(theDictionary.elementAt(i)))
			{
				theDictionary.elementAt(i).addAmount(1);
				break;
			}
				
		}
			if(itemFound==false)
				theDictionary.add(new Pair(item,1));
		
		totalItems++;
	}
	
	/**
	 * LyricsItem getItem()
	 * Returns a LyricsItem from the dictionary. The LyricsItem is obtained by
	 * creating a random number between 0 and 1 and returning the character in the right interval
	 * @return LyricsItem a LyricsItem
	 */
	public LyricsItem getItem() {
		float randomNumber = randomGenerator.nextFloat();
		float lowerLimit = 0;
		float upperLimit = (float)theDictionary.elementAt(0).getAmount()/(float)totalItems;
		
		// Create an upper an lower limit using the number of occurrences of each
		// character. If the random number is inbetween these values, return the
		// current character.
		for(int i=0;i<theDictionary.size()-1;i++)
		{
			
			if(randomNumber > lowerLimit && randomNumber < upperLimit)
				return theDictionary.elementAt(i).getItem();
			
			lowerLimit+=(float)theDictionary.elementAt(i).getAmount()/(float)totalItems;
			upperLimit=lowerLimit+(float)theDictionary.elementAt(i+1).getAmount()/(float)totalItems;
			
			
		}
		return theDictionary.lastElement().getItem();
	}

	

}
