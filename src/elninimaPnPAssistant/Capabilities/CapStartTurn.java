package elninimaPnPAssistant.Capabilities;

import java.util.List;

public abstract class CapStartTurn extends Capability
{
	public CapStartTurn(final int priority)
	{
		super(priority);
	}
	
	public abstract void startTurn(List<?> players);
}
