package elninimaPnPAssistant;

import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import elninimaPnPAssistant.ConsoleCommands.IConsoleCommand;
import elninimaPnPAssistant.ConsoleCommands.SayHello;

public class Console extends JScrollPane
{
	public final TextArea textAreaDisplay = new TextArea();
	public final JTextArea textAreaEntry = new JTextArea();
	
	public String username = "";
	
	private final String commandChar = "/";
	
	private final Map<String, IConsoleCommand> allCommands = new HashMap<>();
	
	private String commandToLog;
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
		this.allCommands.put("SayHello", new SayHello(this));
		
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
				// TODO Auto-generated method stub
				
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
		this.printLine(Entry);
		if (this.commandChar.equals(Entry.substring(0, this.commandChar.length())))
		{
			this.allCommands.get(Entry.substring(this.commandChar.length())).run(null);
			// TODO Execute command
			JOptionPane.showMessageDialog(null, "Executes code... (Window for Debuging)"); // TODO
		}
	}
	
	/*
	 * The following part contains all the getters and setters for the Console
	 * class
	 * 
	 * These should only be used if there is no way to use addCommand().
	 */
	public void printLine(final String str)
	{
		try
		{
			FileReaderLog.writeToFile(str, this.username + "log");
		} catch (final IOException e)
		{
			e.printStackTrace();
		}
		this.textAreaDisplay.append(str + "\n");
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
