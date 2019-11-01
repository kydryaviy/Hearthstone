package ua.balash.hearthstone.card;

import ua.balash.hearthstone.card.misc.TargetType;


public abstract class AbstractCard implements Card
{
	private int manaCost;
	private TargetType targetType;

	public AbstractCard(final int manaCost)
	{
		this.manaCost = manaCost;
		this.targetType = TargetType.NONE;
	}

	@Override
	public int getManaCost()
	{
		return manaCost;
	}

	@Override
	public TargetType getTargetType()
	{
		return targetType;
	}
}
