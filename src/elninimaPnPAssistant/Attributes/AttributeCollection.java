package elninimaPnPAssistant.Attributes;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import elninimaPnPAssistant.Capabilities.Capability;
import elninimaPnPAssistant.Capabilities.CapabilityMap.CapID;

public class AttributeCollection
{
	private final Set<Attribute> attributeList = new HashSet<>();
	
	public Set<Attribute> getAttributeList()
	{
		return this.attributeList;
	}
	
	public void addAttribute(final Attribute att)
	{
		this.attributeList.add(att);
	}
	
	public <T extends Capability> LinkedHashMap<Attribute, T> getCapabilities(final CapID<T> id)
	{
		return this.attributeList
			.stream()
			.collect(Collectors.toMap((a) -> a, (a) -> a.get(id)))
			.entrySet()
			.stream()
			.filter((e) -> e.getValue() != null)
			.sorted(Entry.comparingByValue())
			.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (o1, o2) -> o1, LinkedHashMap::new));
	}
}
