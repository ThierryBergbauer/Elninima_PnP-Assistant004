/*
 * 	!!!	SayHello is only a DEBUG class	!!!
 * 
 * This class needs to be deleted or hidden for final use.
 * The only purpose for this class is to give a console command to experiment with.
 * He should write "Hello World" in 3 places:
 * 	-Programming Console (System.out)
 * 	-Game console
 * 	-Game Log
 */
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
		this.console.printLine("Hello World", true, false);
	}
	
}
