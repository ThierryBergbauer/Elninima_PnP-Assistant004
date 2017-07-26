package elninimaPnPAssistant.Capabilities;

import java.util.List;

public abstract class CapAfterDefense extends Capability
{
	public CapAfterDefense(final int priority)
	{
		super(priority);
	}
	
	public abstract void afterDefense(List<?> players);
}
