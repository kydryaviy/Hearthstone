package ua.balash.hearthstone.collection.base;

import ua.balash.hearthstone.card.Card;
import ua.balash.hearthstone.collection.CardSet;
import ua.balash.hearthstone.collection.base.neutral.Minions;

import java.util.ArrayList;
import java.util.List;


public class Neutral implements CardSet
{
	private List<Card> cards = new ArrayList<>();

	public Neutral()
	{
		cards.addAll(new Minions().getCards());
	}

	@Override
	public List<Card> getCards()
	{
		return cards;
	}
}
