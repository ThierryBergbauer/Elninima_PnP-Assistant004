package elninimaPnPAssistant.ConsoleCommands;

import elninimaPnPAssistant.Console;

public class SayHello implements IConsoleCommand
{
	
	private final Console console;
	
	public SayHello(final Console console)
	{
		this.console = console;
	}
	
	@Override
	public void run(final String fullCommandString)
	{
		System.out.println("Hello World");
		this.console.printLine("Hello World");
		
	}
	
}
