package elninimaPnPAssistant.ConsoleCommands;

import java.util.concurrent.ThreadLocalRandom;

import elninimaPnPAssistant.Console;

public class DiceRolling implements IConsoleCommand
{
	private final Console console;
	
	public DiceRolling(final Console console)
	{
		this.console = console;
	}
	
	@Override
	public void run(final String fullCommandString)
	{
		final int first_ = fullCommandString.indexOf(" ");
		int second_ = 0;
		if (first_ > 3)
		{
			second_ = fullCommandString.indexOf(" ", first_ + 1);
			if (second_ > first_)
			{
				if (isInteger(fullCommandString.substring(first_ + 1, second_)) && isInteger(fullCommandString.substring(second_ + 1, fullCommandString.length())))
					for (int i = 1; i <= Integer.parseInt(fullCommandString.substring(second_ + 1, fullCommandString.length())); i++)
						this.console.printLine(String.valueOf(ThreadLocalRandom.current().nextInt(1, Integer.parseInt(fullCommandString.substring(first_ + 1, second_)) + 1)), false, false);
				else
					this.console.printLine("Entry has no valid Integer 1 ", false, false);
			}
			else if (isInteger(fullCommandString.substring(first_ + 1, fullCommandString.length())))
				this.console.printLine(String.valueOf(ThreadLocalRandom.current().nextInt(1, Integer.parseInt(fullCommandString.substring(first_ + 1, fullCommandString.length())) + 1)), false, false);
			else
				this.console.printLine("Entry has no valid Integer 2 ", false, false);
		}
		else
			this.console.printLine(String.valueOf(ThreadLocalRandom.current().nextInt(1, 6 + 1)), false, false);
		
	}
	
	public static boolean isInteger(final String s)
	{
		try
		{
			Integer.parseInt(s);
		} catch (final NumberFormatException e)
		{
			return false;
		} catch (final NullPointerException e)
		{
			return false;
		}
		return true;
	}
	
}
