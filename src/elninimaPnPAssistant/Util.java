package elninimaPnPAssistant;

import java.util.concurrent.ThreadLocalRandom;

public class Util
{
	public static int rand(final int min, final int max)
	{
		return ThreadLocalRandom.current().nextInt(min, max);
	}
	
	public static boolean isInteger(final String s)
	{
		try
		{
			Integer.parseInt(s);
		} catch (final NumberFormatException e)
		{
			return false;
		}
		return true;
	}
}
