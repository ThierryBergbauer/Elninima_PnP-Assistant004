package elninimaPnPAssistant.Capabilities;

public abstract class CapAttack extends Capability
{
	public CapAttack(final int priority)
	{
		super(priority);
	}
	
	public abstract double attack(double damageValue);
}
