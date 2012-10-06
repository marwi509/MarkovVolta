package lyricsGenerator;

import java.io.*;
/**
 * Reads a file and puts the content in a String
 * @author Steen
 *
 */
class FileReader
{
	
	private String fileContent="";
	public void readFile(String fileName)
	{
		try
		{
			// Open the file that is the first 
			// command line parameter
			FileInputStream fstream = new FileInputStream(fileName);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			//Read File Line By Line
			while ((strLine = br.readLine()) != null)
			{
				fileContent+=strLine+"\n";
			}
			
			//Close the input stream
			in.close();
		}
		catch (Exception e)//Catch exception if any
		{
			System.err.println("Error: " + e.getMessage());
		}
	}
	public String getContent()
	{
		return fileContent;
	}
	public String toString()
	{
		return getContent();
	}
}