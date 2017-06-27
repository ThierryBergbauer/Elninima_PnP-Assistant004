package elninimaPnPAssistant.ConsoleCommands;

import java.util.Iterator;
import java.util.Set;

import elninimaPnPAssistant.Console;

public class HelpCommand implements IConsoleCommand
{
	
	private final Console console;
	
	public HelpCommand(final Console console)
	{
		this.console = console;
	}
	
	@Override
	public void run(final String fullCommandString)
	{
		final Set<String> allCommandKeys = this.console.getCommandKeys();
		final Iterator<String> iterator = allCommandKeys.iterator();
		while (iterator.hasNext())
			this.console.printLine("/" + iterator.next(), false, false);
	}
	
}