package markov.lyricsGenerator;


public class SimpleLyricsCreator extends LyricsCreator{
	
	private int charsPerRow = 40;
	private int rowsPerParagraph = 4;

	public void setRowLength(int length)
	{
		charsPerRow = length;
	}
	
	public void setRowsPerParagraph(int num)
	{
		rowsPerParagraph = num;
	}
	@Override
	public void createSong(int length) {
		while(song.length() < songLength)
		{
			int numRows = 0;
			while(numRows < rowsPerParagraph)
			{
				int charsInRow = 0;
				while(charsInRow < charsPerRow)
				{
					String obtainedString = theDictionary.getItem().toString();
					charsInRow+=obtainedString.length();
					song+=obtainedString;
				}
				song+='\n';
				numRows++;
			}
			song+='\n';
		}
		
	}
	


}
