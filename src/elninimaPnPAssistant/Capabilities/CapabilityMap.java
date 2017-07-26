package elninimaPnPAssistant.Capabilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import elninimaPnPAssistant.Main;

public class CapabilityMap
{
	public static final CapID<CapEndTurn> endTurn = new CapID<>("end turn");
	
	private final Map<CapID<?>, Object> caps = new HashMap<>();
	
	public CapabilityMap()
	{
		this.caps.put(endTurn, new CapEndTurn()
		{
			@Override
			public void endTurn(final List<?> players)
			{
				for (final Object player : players)
					Main.instance.console.printLine(player.toString(), true, false);
			}
		});
	}
	
	public static class CapID<T>
	{
		String name;
		
		public CapID(final String name)
		{
			this.name = name;
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> T put(final CapID<T> capID, final T cap)
	{
		return (T) this.caps.put(capID, cap);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(final CapID<T> capID)
	{
		return (T) this.caps.get(capID);
	}
	
}
