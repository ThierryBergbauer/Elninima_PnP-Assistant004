package elninimaPnPAssistant.Capabilities;

import java.util.List;

public abstract class CapDefense extends Capability
{
	public CapDefense(final int priority)
	{
		super(priority);
	}
	
	public abstract void defense(List<?> players);
}
