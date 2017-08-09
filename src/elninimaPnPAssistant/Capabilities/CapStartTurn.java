package elninimaPnPAssistant.Capabilities;

public abstract class CapStartTurn extends Capability
{
	public CapStartTurn(final int priority)
	{
		super(priority);
	}
	
	public abstract double startTurn(double startTurn);
}
