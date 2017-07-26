package elninimaPnPAssistant.ConsoleCommands;

import elninimaPnPAssistant.Console;
import elninimaPnPAssistant.Util;

public class DiceRolling implements IConsoleCommand
{
	private final Console console;
	
	public DiceRolling(final Console console)
	{
		this.console = console;
	}
	
	@Override
	public void run(final String fullCommandString) throws IllegalArgumentException
	{
		final String[] args = fullCommandString.split(" ");
		
		final int max = args.length > 1 ? Integer.parseInt(args[1]) : 6;
		final int cnt = args.length > 2 ? Integer.parseInt(args[2]) : 1;
		
		for (int i = 0; i < cnt; ++i)
			this.console.printLine(String.valueOf(Util.rand(1, max)), false, false);
	}
	
}
