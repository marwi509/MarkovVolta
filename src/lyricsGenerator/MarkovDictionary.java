package lyricsGenerator;

import java.util.Random;
import java.util.Vector;


public class MarkovDictionary implements Dictionary{

	private Vector<SequenceProb> items = new Vector<SequenceProb>();
	private Sequence theSequence = new Sequence();
	private HashTable<Sequence> table = new HashTable<Sequence>();
	private HashTable<Pair> theItemTable = new HashTable<Pair>();
	private Random randomGenerator = new Random();
	
	@Override
	public void addItemVector(Vector<LyricsItem> theVector) {
		
		theSequence = new Sequence();
		for(int i=0;i<theVector.size();i++)
		{
			Pair tempPair = theItemTable.contains(new Pair(theVector.get(i), 0));
			//int alreadyExists = theItemTable.contains(new Pair(theVector.get(i), 0));
			boolean found = false;
			if(tempPair != null)
			{
				items.get(tempPair.getAmount()).addSequence(theSequence);
			}
			if(!found)
			{
				theItemTable.insert(new Pair(theVector.get(i), items.size()));
				items.add(new SequenceProb(theVector.get(i),theSequence));
			}
			Sequence tempSequence = table.insert(theSequence);
			tempSequence.increment();
			theSequence.push(theVector.get(i));
		}
		theSequence = new Sequence();
	}

	@Override
	public LyricsItem getItem() {
		if(table.contains(theSequence) == null)
		{
			theSequence = new Sequence();
		}
		float totalAmount = 0.0f;
		Sequence tempSequence = table.contains(theSequence);
		if(tempSequence != null)
		{
			totalAmount = (float)tempSequence.getAmount();
		}
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
