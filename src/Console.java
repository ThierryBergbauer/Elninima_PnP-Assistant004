import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;

public class Console
{
	public String username = "";
	
	private final String commandChar = "/";
	
	private String commandToLog;
	private final List<String> oldCommands = new ArrayList<>();
	
	final Properties prop = new Properties();
	OutputStream outLOG = null;
	
	/*
	 * initialization
	 */
	Console(final String usernameMain)
	{
		this.username = usernameMain;
	}
	
	/*
	 * This addCommand function should be mainly used to enter commands, also from outside the Console window.
	 * It will handle Chats from Player to Player, all Commands entered and writing a Log file.
	 */
	void addCommand(final String Entry)
	{
		if (this.commandChar.equals(String.valueOf(Entry.charAt(0))))
		{
			; //TODO Execute command
			this.setOldCommand(Entry);
			JOptionPane.showMessageDialog(null, "Executes code... (Window for Debuging)"); //TODO Delete when execute command is finished
			this.setCommandToLog(Entry);
			try
			{
				FileReaderLog.writeToFile(this.getCommandToLog(), this.username + "log");
			} catch (final IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			this.setOldCommand(Entry);
			this.setCommandToLog(Entry);
			try
			{
				FileReaderLog.writeToFile(this.getCommandToLog(), this.username + "log");
			} catch (final IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * The following part contains all the getters and setters for the Console class
	 * 
	 * These should only be used if there is no way to use addCommand().
	 */
	public String getCommandToLog()
	{
		return this.commandToLog;
	}
	
	public void setCommandToLog(final String commandToLog)
	{
		this.commandToLog = commandToLog + "\n";
	}
	
	public String getOldCommand()
	{
		return this.oldCommands.get(this.oldCommands.size() - 1);
	}
	
	public void setOldCommand(final String newCommand)
	{
		this.oldCommands.add(newCommand);
	}
}
