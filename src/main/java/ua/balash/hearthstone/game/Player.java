package ua.balash.hearthstone.game;

import ua.balash.hearthstone.card.Card;
import ua.balash.hearthstone.character.Hero;
import ua.balash.hearthstone.character.Minion;

import java.util.ArrayList;
import java.util.List;


// TODO add mana management
public class Player
{
	private String name;
	private Hero hero;
	private List<Card> deck;
	private List<Card> hand = new ArrayList<>();
	private List<Minion> board = new ArrayList<>();

	public Player(final String name, final Hero hero, final List<Card> deck)
	{
		this.name = name;
		this.hero = hero;
		this.deck = deck;
	}

	public Hero getHero()
	{
		return hero;
	}

	public String getName() {
		return name;
	}

	public List<Minion> getBoard()
	{
		return board;
	}
}
