package elninimaPnPAssistant.Capabilities;

public abstract class CapEndTurn extends Capability
{
	public CapEndTurn(final int priority)
	{
		super(priority);
	}
	
	public abstract double endTurn(double health);
}
