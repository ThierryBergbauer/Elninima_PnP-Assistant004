package elninimaPnPAssistant.Capabilities;

public abstract class CapDefense extends Capability
{
	public CapDefense(final int priority)
	{
		super(priority);
	}
	
	public abstract double defense(double damageValue);
}
