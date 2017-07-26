package elninimaPnPAssistant.Attributes;

import java.util.HashMap;
import java.util.Map;

import elninimaPnPAssistant.Capabilities.CapabilityMap;

public class Attribute extends CapabilityMap
{
	public final String name;
	private final Map<String, Double> parameters = new HashMap<>();
	
	public Attribute(final String name)
	{
		this.name = name;
	}
	
	protected void putParameter(final String name, final double value)
	{
		this.parameters.put(name, value);
	}
	
	public void setValue(final String name, final double value)
	{
		if (this.parameters.containsKey(name))
			this.parameters.put(name, value);
	}
	
	public double getValue(final String name)
	{
		final Double ret = this.parameters.get(name);
		if (ret == null)
			throw new IllegalArgumentException("Paramter '" + name + "' does not exist in attribute '" + this.name + "'");
		return ret;
	}
}
