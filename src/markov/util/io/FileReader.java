package markov.util.io;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/**
 * Reads a file and puts the content in a String
 * @author Steen
 *
 */
public class FileReader
{
	
	private String fileContent="";
	private int bufferSize = 10;
	
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
			
			String theLine;
			
			// Allocate a stringbuilder, this is much faster than appending a string
			StringBuilder theBuffer = new StringBuilder(bufferSize);
			while((theLine = br.readLine()) != null)
			{
				theBuffer.append(theLine + '\n');
			}
			
			fileContent = theBuffer.toString();
			
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