package markov.util.io;

import java.io.*;

/**
 * Reads a file and puts the content in a String
 * @author Steen
 *
 */
public class FileReader
{
	
	private String fileContent="";
	private final static int bufferSize = 10;
	
	public void readFile(String fileName)
	{
		FileInputStream fstream = null;
		try {
			fstream = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			System.err.println("Error: " + e.getMessage());
		}
		readFile(fstream);
	}

	public void readFile(InputStream stream) {

		try (BufferedReader br = getBufferedReader(stream)) {

			StringBuilder theBuffer = new StringBuilder(bufferSize);

            String theLine = br.readLine();

            if(theLine != null) {
                theBuffer.append(theLine);
            }
			while((theLine = br.readLine()) != null)
			{
				theBuffer.append('\n' + theLine);
			}

			fileContent = theBuffer.toString();
		}
		catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
		}
	}

    private BufferedReader getBufferedReader(InputStream stream) {
        return new BufferedReader(new InputStreamReader(new DataInputStream(stream)));
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