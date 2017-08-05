package elninimaPnPAssistant.Attributes;

import elninimaPnPAssistant.Capabilities.CapEndTurn;

public class Health extends Attribute
{
	private static final String paramName = "Health";
	
	public Health(final double hp)
	{
		super("Health");
		this.putParameter(paramName, hp);
		this.putCapability(CapEndTurn.class, new CapEndTurn(0)
		{
			@Override
			public double endTurn(final double healthChange)
			{
				putParameter(paramName,(healthChange + Health.this.getValue(paramName)));
				return Health.this.getValue(paramName);
			}
		});
	}
}
