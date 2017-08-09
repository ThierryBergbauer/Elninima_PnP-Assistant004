package elninimaPnPAssistant.Creatures;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import elninimaPnPAssistant.Attributes.Attribute;
import elninimaPnPAssistant.Attributes.AttributeCollection;
import elninimaPnPAssistant.Capabilities.CapAfterDefense;
import elninimaPnPAssistant.Capabilities.CapAttack;
import elninimaPnPAssistant.Capabilities.CapDefense;
import elninimaPnPAssistant.Capabilities.CapEndTurn;
import elninimaPnPAssistant.Capabilities.CapStartTurn;
import elninimaPnPAssistant.Capabilities.Capability;

public class Creatures
{
	private final Map<Integer, AttributeCollection> allCreatures = new HashMap<>();
	
	/*
	 * 
	 * 
	 * 
	 * Construction and administration of creatures
	 */
	public void addCreature(final int creatureID, final AttributeCollection attributeCollection)
	{
		this.allCreatures.put(creatureID, attributeCollection);
	}
	
	public Map<Integer, AttributeCollection> getAllCreatures()
	{
		return this.allCreatures;
	}
	
	public void deleteCreature(final int creatureID)
	{
		this.allCreatures.remove(creatureID);
	}
	
	public AttributeCollection get1Creature(final int creatureID)
	{
		return this.allCreatures.get(creatureID);
	}
	
	/*
	 * 
	 * 
	 * 
	 * Execution of creatures
	 */
	public <T extends Capability> void exe1CreatureAttackCaps(final int creatureID)
	{
		double attack = 0;
		final LinkedHashMap<Attribute, CapAttack> creatureAttackCaps = this.get1Creature(creatureID).getCapabilities(CapAttack.class);
		for (final Entry<Attribute, CapAttack> e : creatureAttackCaps.entrySet())
			attack = e.getValue().attack(attack);
	}
	
	public <T extends Capability> void exe1CreatureDefenseCap(final int creatureID)
	{
		double defense = 0;
		final LinkedHashMap<Attribute, CapDefense> creatureDefenseCaps = this.get1Creature(creatureID).getCapabilities(CapDefense.class);
		for (final Entry<Attribute, CapDefense> e : creatureDefenseCaps.entrySet())
			defense = e.getValue().defense(defense);
	}
	
	public <T extends Capability> void exe1CreatureAfterDefenseCap(final int creatureID)
	{
		double afterDefense = 0;
		final LinkedHashMap<Attribute, CapAfterDefense> creatureAfterDefenseCaps = this.get1Creature(creatureID).getCapabilities(CapAfterDefense.class);
		for (final Entry<Attribute, CapAfterDefense> e : creatureAfterDefenseCaps.entrySet())
			afterDefense = e.getValue().afterDefense(afterDefense);
	}
	
	public <T extends Capability> void exe1CreatureEndTurnCap(final int creatureID)
	{
		double endTurn = 0;
		final LinkedHashMap<Attribute, CapEndTurn> creatureEndTurnCaps = this.get1Creature(creatureID).getCapabilities(CapEndTurn.class);
		for (final Entry<Attribute, CapEndTurn> e : creatureEndTurnCaps.entrySet())
			endTurn = e.getValue().endTurn(endTurn);
	}
	
	public <T extends Capability> void exe1CreatureStartTurnCap(final int creatureID)
	{
		double startTurn = 0;
		final LinkedHashMap<Attribute, CapStartTurn> creatureStartTurnCaps = this.get1Creature(creatureID).getCapabilities(CapStartTurn.class);
		for (final Entry<Attribute, CapStartTurn> e : creatureStartTurnCaps.entrySet())
			startTurn = e.getValue().startTurn(startTurn);
	}
	
}
