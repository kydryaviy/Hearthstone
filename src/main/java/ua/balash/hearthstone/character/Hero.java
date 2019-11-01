package ua.balash.hearthstone.character;

import ua.balash.hearthstone.game.Game;


public class Hero extends AbstractCharacter
{
	private CharacterClass characterClass;

	public Hero(int initialHealth)
	{
		super(initialHealth, 0);
	}

	public void destroy()
	{
		Game.lose(this);
	}
}
