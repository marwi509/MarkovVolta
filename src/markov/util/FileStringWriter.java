package markov.util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileStringWriter {
	private FileStringWriter(){}
	public static void toFile(String theString, String filename)
	{
		try
		{
			BufferedWriter theWriter = new BufferedWriter(new FileWriter(filename));
			theWriter.write(theString);
			theWriter.close();
		}
		catch(FileNotFoundException E)
		{
			System.out.println("Error in FileStringWriter: File not found.");
		}
		catch(IOException E)
		{
			System.out.println("Error in FileStringWriter: IO Exception.");
		}
		
	}
}
