package elninimaPnPAssistant;

import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import elninimaPnPAssistant.ConsoleCommands.ClearConsole;
import elninimaPnPAssistant.ConsoleCommands.DiceRolling;
import elninimaPnPAssistant.ConsoleCommands.HelpCommand;
import elninimaPnPAssistant.ConsoleCommands.IConsoleCommand;
import elninimaPnPAssistant.ConsoleCommands.SayHello;

public class Console extends JScrollPane
{
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final TextArea textAreaDisplay = new TextArea();
	public final JTextArea textAreaEntry = new JTextArea();
	
	public String username = "";
	
	private final String commandChar = "/";
	
	private final Map<String, IConsoleCommand> allCommands = new HashMap<>();
	
	private final List<String> oldCommands = new ArrayList<>();
	
	final Properties prop = new Properties();
	OutputStream outLOG = null;
	
	/*
	 * Initialization
	 */
	Console(final String usernameMain)
	{
		this.username = usernameMain;
		
		/*
		 * all Commands
		 */
		this.allCommands.put("sayHello", new SayHello(this));
		this.allCommands.put("dice", new DiceRolling(this));
		this.allCommands.put("clear", new ClearConsole(this));
		this.allCommands.put("help", new HelpCommand(this));
		
		/*
		 * TextAreas
		 */
		this.setColumnHeaderView(this.textAreaDisplay);
		this.setViewportView(this.textAreaEntry);
		this.textAreaDisplay.append("Welcom to Elninima's Pen and Paper Assistant \nThis is your Console. For further informations enter '/help'.\n");
		this.textAreaEntry.addKeyListener(new KeyListener()
		{
			@Override
			public void keyPressed(final KeyEvent e)
			{
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					Console.this.addCommand(Console.this.textAreaEntry.getText());
			}
			
			@Override
			public void keyTyped(final KeyEvent e)
			{
			
			}
			
			@Override
			public void keyReleased(final KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					Console.this.textAreaEntry.setText(null);
				
			}
		});
	}
	
	/*
	 * This addCommand function should be mainly used to enter commands, also
	 * from outside the Console window. It will handle Chats from Player to
	 * Player, all Commands entered and writing a Log file.
	 */
	void addCommand(final String Entry)
	{
		this.setOldCommand(Entry);
		this.printLine(Entry, true, true);
		if (this.commandChar.equals(Entry.substring(0, this.commandChar.length())))
		{
			/*
			 *Extracting the command from the parameters
			 */
			int commandEnd = 0;
			if (Entry.indexOf(" ") == -1)
				commandEnd = Entry.length();
			else
				commandEnd = Entry.indexOf(" ");
			/*
			 * The next Line executes the command if he can be found in allCommands and gives Entry as String
			 * to the specific command class
			 */
			if (this.allCommands.containsKey(Entry.substring(this.commandChar.length(), commandEnd)))
				this.allCommands.get(Entry.substring(this.commandChar.length(), commandEnd)).run(Entry);
			else
				this.printLine("Unknown Command", false, false);
		}
	}
	
	/*
	 * The following part contains all the getters and setters for the Console
	 * class
	 * 
	 * These should only be used if there is no way to use addCommand().
	 */
	public void printLine(final String str, final boolean needsLog, final boolean needsUserStamp)
	{
		if (needsUserStamp)
		{
			if (needsLog)
				try
				{
					final Calendar cal = Calendar.getInstance();
					final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					FileReaderLog.writeToFile(sdf.format(cal.getTime()) + "\t" + this.username + " > " + str + "\n", this.username + "log");
				} catch (final IOException e)
				{
					e.printStackTrace();
				}
			this.textAreaDisplay.append(this.username + " > " + str + "\n");
		}
		else
		{
			if (needsLog)
				try
				{
					final Calendar cal = Calendar.getInstance();
					final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					FileReaderLog.writeToFile(sdf.format(cal.getTime()) + "\t" + str + "\n", this.username + "log");
				} catch (final IOException e)
				{
					e.printStackTrace();
				}
			this.textAreaDisplay.append(str + "\n");
		}
		
	}
	
	public Set<String> getCommandKeys()
	{
		return this.allCommands.keySet();
	}
	
	public void clearConsole()
	{
		this.textAreaDisplay.setText("");
	}
	
	public String getOldCommand(final int a)
	{
		return this.oldCommands.get(this.oldCommands.size() - 1 - a);
	}
	
	public void setOldCommand(final String newCommand)
	{
		this.oldCommands.add(newCommand);
	}
}
