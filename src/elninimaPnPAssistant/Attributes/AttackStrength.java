package elninimaPnPAssistant.Attributes;

import elninimaPnPAssistant.Capabilities.CapAttack;

public class AttackStrength extends Attribute
{
	private static final String paramName = "strValue";
	
	public AttackStrength(final double str)
	{
		super("Strength");
		this.putParameter(paramName, str);
		this.putCapability(CapAttack.class, new CapAttack(0)
		{
			@Override
			public double attack(final double damageValue)
			{
				return damageValue + AttackStrength.this.getValue(paramName);
			}
		});
	}
	
}
