import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderLog
{
	public static void writeToFile(final String data, final String file) throws IOException
	{
		FileWriter fstream = null;
		
		try
		{
			fstream = new FileWriter(file, true);
			final BufferedWriter out = new BufferedWriter(fstream);
			out.write(data);
			//Close the output stream
			out.close();
		} catch (final IOException ex)
		{
			ex.printStackTrace();
		} finally
		{
			try
			{
				fstream.close();
			} catch (final IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	public static String readFile1(final String filename) throws FileNotFoundException, IOException
	{
		String everything = "";
		try (BufferedReader br = new BufferedReader(new FileReader(filename)))
		{
			final StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			
			while (line != null)
			{
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			everything = sb.toString();
		}
		return everything;
	}
}
