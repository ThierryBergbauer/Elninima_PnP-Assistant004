package elninimaPnPAssistant.ConsoleCommands;

import elninimaPnPAssistant.Console;

public class ClearConsole implements IConsoleCommand
{
	
	private final Console console;
	
	public ClearConsole(final Console console)
	{
		this.console = console;
	}
	
	@Override
	public void run(final String fullCommandString)
	{
		this.console.clearConsole();
	}
	
}