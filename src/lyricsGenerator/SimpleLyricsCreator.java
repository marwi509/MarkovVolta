package lyricsGenerator;


public class SimpleLyricsCreator extends LyricsCreator{
	
	private int charsPerRow = 40;
	private int rowsPerParagraph = 4;
	
	@Override
	public void printSong(String filename) {
		// TODO Auto-generated method stub
		
	}
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
		int charsInRow = 0;
		int numRows = 0;
		while(song.length() < songLength)
		{
			numRows = 0;
			while(numRows < rowsPerParagraph)
			{
				charsInRow = 0;
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
