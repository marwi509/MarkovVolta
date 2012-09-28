package lyricsGenerator;

import java.util.Random;
import java.util.Vector;


public class MarkovDictionary implements Dictionary{

	private Vector<SequenceProb> items = new Vector<SequenceProb>();
	private Sequence theSequence = new Sequence();
	private HashTable table = new HashTable();
	private Random randomGenerator = new Random();
	
	@Override
	public void addItemVector(Vector<LyricsItem> theVector) {
		
		theSequence = new Sequence();
		for(int i=0;i<theVector.size();i++)
		{
			
			boolean found = false;
			for(int j=0;j<items.size();j++)
			{
				
				if(theVector.get(i).equals(items.get(j).getItem()))
				{
					items.get(j).addSequence(theSequence);
					found = true;
					
				}
				
			}
			if(!found)
			{

				items.add(new SequenceProb(theVector.get(i),theSequence));
				
			}
			table.insertSequence(theSequence);
			theSequence.push(theVector.get(i));
		}
		theSequence = new Sequence();
	}

	@Override
	public LyricsItem getItem() {
		if(table.getAmount(theSequence)==0)
		{
			theSequence = new Sequence();
		}
		float totalAmount =(float)table.getAmount(theSequence);
		float randomNumber = randomGenerator.nextFloat();
		float lowerLimit = 0;
		float upperLimit = (float)items.elementAt(0).getAmount(theSequence)/totalAmount;
		
		for(int i=0;i<items.size()-1;i++)
		{
		
			/*System.out.println("lower: "+lowerLimit);
			System.out.println("random: "+randomNumber);
			System.out.println("upper: "+upperLimit);
			*/
			if(randomNumber > lowerLimit && randomNumber < upperLimit)
			{	
				theSequence.push(items.elementAt(i).getItem());
				return items.elementAt(i).getItem();
			}
			lowerLimit+=(float)items.elementAt(i).getAmount(theSequence)/totalAmount;
			upperLimit=lowerLimit+(float)items.elementAt(i+1).getAmount(theSequence)/totalAmount;
			
			
		}
		theSequence.push(items.lastElement().getItem());
		return items.lastElement().getItem();
	}

}
