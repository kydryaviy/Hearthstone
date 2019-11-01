package ua.balash.hearthstone.character;


import ua.balash.hearthstone.game.Game;
import ua.balash.hearthstone.game.Player;


public class Minion extends AbstractCharacter
{
	public Minion(final int initialHealth, final int initialAttack)
	{
		super(initialHealth, initialAttack);
	}

	@Override
	public void destroy()
	{
		System.out.println("Minion is dead");
		Game.removeMinion(this);
	}

	public void summon(final Player player)
	{
		System.out.println("Minion is summoned");
		Game.summonMinion(this, player);
	}
}
