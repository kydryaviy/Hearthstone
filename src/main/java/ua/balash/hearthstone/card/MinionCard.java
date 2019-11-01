package ua.balash.hearthstone.card;

import ua.balash.hearthstone.character.Minion;
import ua.balash.hearthstone.game.Action;
import ua.balash.hearthstone.game.Game;


public class MinionCard extends AbstractCard
{
	private Minion minion;

	public MinionCard(int manaCost, final Minion minion, final Action battlecryAction)
	{
		super(manaCost);
		this.minion = minion;
	}

	@Override
	public void play(final Object target)
	{
		minion.summon(Game.getCurrentPlayer());
	}
}
