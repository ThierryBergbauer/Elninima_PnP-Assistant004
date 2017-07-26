package elninimaPnPAssistant.Capabilities;

import java.util.List;

public abstract class CapEndTurn extends Capability
{
	public CapEndTurn(final int priority)
	{
		super(priority);
	}
	
	public abstract void endTurn(List<?> players);
}
