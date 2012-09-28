package lyricsGenerator;

import java.util.Vector;


public class MarkovVolta {
	public static void main(String args[])
	{
	/*	HashTable table = new HashTable();
		Sequence seq = new Sequence();
		CharacterItem item = new CharacterItem("cs");
		seq.push(item);

		seq.push(item);
		table.insertSequence(seq);
		System.out.println(seq.getHash());

		table.insertSequence(seq);
		System.out.println(seq.getHash());
		System.out.println(seq.equals(seq));
		*/
		
		FileReader reader = new FileReader();
		CharParser parser = new CharParser();
		MarkovDictionary dictionary = new MarkovDictionary();
		reader.readFile("C:/a/zed.txt");
		Vector<LyricsItem> vector = parser.parse(reader.getContent());
		
		reader.readFile("C:/a/Mars Volta lyrics/inertiaticesp.txt");
		vector = parser.parse(reader.getContent());
		
		reader.readFile("C:/a/Mars Volta lyrics/roulettedares.txt");
		vector = parser.parse(reader.getContent());
		
		reader.readFile("C:/a/Mars Volta lyrics/drunkshipoflanterns.txt");
		vector = parser.parse(reader.getContent());
		
		dictionary.addItemVector(vector);
		LyricsCreator Cedric = new LyricsCreator();
		Cedric.setInput(dictionary);
		System.out.println(Cedric);
		
	}
}
