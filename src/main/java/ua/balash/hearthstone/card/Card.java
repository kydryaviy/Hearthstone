package ua.balash.hearthstone.card;

import ua.balash.hearthstone.card.misc.TargetType;


public interface Card
{
	int getManaCost();

	TargetType getTargetType();

	void play(Object target);
}
