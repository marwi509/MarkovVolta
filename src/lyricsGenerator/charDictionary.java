package lyricsGenerator;

import java.util.Random;
import java.util.Vector;


public class charDictionary implements Dictionary{

	private Vector<Pair> theDictionary = new Vector<Pair>();
	private int totalItems = 0;
	private Random randomGenerator = new Random();
	@Override
	public void addItemVector(Vector<LyricsItem> theVector) {
		
		for(int i=0;i<theVector.size();i++)
		{
			//System.out.println(theVector.elementAt(i));
			addItem(theVector.elementAt(i));
		}
	}
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
	
	

	public LyricsItem getItem() {
		float randomNumber = randomGenerator.nextFloat();
		float lowerLimit = 0;
		float upperLimit = (float)theDictionary.elementAt(0).getAmount()/(float)totalItems;
		
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
