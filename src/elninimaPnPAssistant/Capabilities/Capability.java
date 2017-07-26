package elninimaPnPAssistant.Capabilities;

public class Capability implements Comparable<Capability>
{
	public int priority;
	
	public Capability(final int priority)
	{
		this.priority = priority;
	}
	
	@Override
	public int compareTo(final Capability o)
	{
		return Integer.compare(this.priority, o.priority);
	}
	
}
