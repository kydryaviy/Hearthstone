package ua.balash.hearthstone.game;

import ua.balash.hearthstone.card.misc.TargetType;


public interface Action
{
	TargetType getTargetType();

	void act(Object target);
}
