import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

public class Console
{
	public String username = "";
	public String commandChar = "/";
	final Properties prop = new Properties();
	OutputStream outLOG = null;
	
	Console(final String usernameMain)
	{
		this.username = usernameMain;
	}
	
	void addCommand(final String Entry)
	{
		if (this.commandChar.equals(String.valueOf(Entry.charAt(0))))
		{
			; //TODO Execute command
			JOptionPane.showMessageDialog(null, "Executes code.... (Window for Debuging)"); //TODO Delete when execute command is finished
			try
			{
				FileReaderLog.writeToFile(Entry, this.username + "log");
			} catch (final IOException e)
			{
				e.printStackTrace();
			}
		}
		else
			try
			{
				FileReaderLog.writeToFile(Entry, this.username + "log");
			} catch (final IOException e)
			{
				e.printStackTrace();
			}
	}
}
