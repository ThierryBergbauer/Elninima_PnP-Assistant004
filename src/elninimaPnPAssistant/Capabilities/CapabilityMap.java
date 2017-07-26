package elninimaPnPAssistant.Capabilities;

import java.util.HashMap;
import java.util.Map;

public class CapabilityMap
{
	private final Map<Class<? extends Capability>, Capability> caps = new HashMap<>();
	
	@SuppressWarnings("unchecked")
	public <T extends Capability> T putCapability(final Class<T> capID, final T cap)
	{
		return (T) this.caps.put(capID, cap);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Capability> T getCapability(final Class<T> capID)
	{
		return (T) this.caps.get(capID);
	}
	
}
