package lyricsGenerator;

import java.util.Vector;


public class MarkovVolta {
	public static void main(String args[])
	{
		Vector<String> Files = new Vector<String>();
		
		Files.add(new String("/home/marcus/Dokument/Mars Volta/aegis.txt"));
		Files.add(new String("/home/marcus/Dokument/Mars Volta/goliath.txt"));
		Files.add(new String("/home/marcus/Dokument/Mars Volta/lvia.txt"));
		Files.add(new String("/home/marcus/Dokument/Mars Volta/roulette.txt"));
		Files.add(new String("/home/marcus/Dokument/Mars Volta/esp.txt"));
		Files.add(new String("/home/marcus/Dokument/Mars Volta/son.txt"));
		Files.add(new String("/home/marcus/Dokument/Mars Volta/drunkship.txt"));
		
		//Files.add(new String("/home/marcus/Dokument/Mars Volta/Genesis.txt"));
		LyricsFacade theFacade = new LyricsFacade();
		theFacade.setUseCharacter();
		theFacade.setSequenceLength(6);
		
		
		for(int i = 0; i < Files.size(); i ++)
		{
			theFacade.addSong(Files.get(i));
		}

		System.out.println(theFacade.generateSong());
		theFacade.toFile("/home/marcus/Dokument/Mars Volta/output/song.txt");
		
	}
}
