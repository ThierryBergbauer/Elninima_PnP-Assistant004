package elninimaPnPAssistant.Attributes;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.stream.Collectors;

import elninimaPnPAssistant.Capabilities.Capability;

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
	
	public <T extends Capability> LinkedHashMap<Attribute, T> getCapabilities(final Class<T> id)
	{
		class AttToCap
		{
			Attribute att;
			T cap;
			
			public AttToCap(final Attribute att)
			{
				this.att = att;
				this.cap = att.getCapability(id);
			}
		}
		
		/*
		 * Creates a Linked Hash set with all attributes and sorted in order of their capability priority
		 */
		return this.attributeList
			.stream()
			.map(AttToCap::new)
			.filter(e -> e.cap != null)
			.sorted(Comparator.comparing(a -> a.cap))
			.collect(Collectors.toMap(a -> a.att, a -> a.cap, (o1, o2) -> o1, LinkedHashMap::new));
	}
}
