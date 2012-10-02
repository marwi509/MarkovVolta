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
		Parser parser = new CharParser();
		Sequence.setSequenceLength(4);
		MarkovDictionary dictionary = new MarkovDictionary();
		//reader.readFile();
		//Vector<LyricsItem> vector = parser.parse(reader.getContent());
		
		
		//reader.readFile("/home/marcus/Dokument/Mars Volta/goliath.txt");
		//vector = parser.parse(reader.getContent());
		
		//reader.readFile();
		//vector = parser.parse(reader.getContent());
		/*
		reader.readFile("C:/a/Mars Volta lyrics/drunkshipoflanterns.txt");
		vector = parser.parse(reader.getContent());
		*/
Vector<String> Files = new Vector<String>();
		
		//Files.add(new String("C:/a/bible.txt"));
		Files.add(new String("/home/marcus/Dokument/Mars Volta/aegis.txt"));
		Files.add(new String("/home/marcus/Dokument/Mars Volta/goliath.txt"));
		Files.add(new String("/home/marcus/Dokument/Mars Volta/lvia.txt"));
		Files.add(new String("/home/marcus/Dokument/Mars Volta/roulette.txt"));
		Files.add(new String("/home/marcus/Dokument/Mars Volta/esp.txt"));
		Files.add(new String("/home/marcus/Dokument/Mars Volta/son.txt"));
		Files.add(new String("/home/marcus/Dokument/Mars Volta/drunkship.txt"));
		for(int i = 0; i < Files.size(); i ++)
		{
			reader.readFile(Files.get(i));
			Vector<LyricsItem> vector = parser.parse(reader.getContent());
			dictionary.addItemVector(vector);
		}
		
		//dictionary.addItemVector(vector);
		LyricsCreator Cedric = new LyricsCreator();
		Cedric.setInput(dictionary);
		System.out.println(Cedric);
		
	}
}
