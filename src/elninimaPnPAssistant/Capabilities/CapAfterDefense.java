package elninimaPnPAssistant.Capabilities;

public abstract class CapAfterDefense extends Capability
{
	public CapAfterDefense(final int priority)
	{
		super(priority);
	}
	
	public abstract double afterDefense(double afterDefense);
}
