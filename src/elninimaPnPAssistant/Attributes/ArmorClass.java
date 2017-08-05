package elninimaPnPAssistant.Attributes;

import elninimaPnPAssistant.Capabilities.CapDefense;

public class ArmorClass extends Attribute
{
	private static final String paramName = "ArmorClass";
	
	public ArmorClass(double ac)
	{
		super("ArmorClass");
		this.putParameter(paramName, ac);
		this.putCapability(CapDefense.class, new CapDefense(0)
		{
			@Override
			public double defense(final double defenseValue)
			{
				return defenseValue + ArmorClass.this.getValue(paramName);
			}
		});
	}

}
