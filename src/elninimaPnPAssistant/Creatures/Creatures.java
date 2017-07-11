package elninimaPnPAssistant.Creatures;

import java.util.HashMap;
import java.util.Map;

import elninimaPnPAssistant.Creatures.allCreatures.ICreature;

public class Creatures
{
	private final Map<String, ICreature> allCreatures = new HashMap<>();
	
	public void addCreature(final String creaturName, final int health, final int armourClass, final int attackDamage)
	{
		
	}
	
	public Map<String, ICreature> getAllCreatures()
	{
		return this.allCreatures;
	}
}
