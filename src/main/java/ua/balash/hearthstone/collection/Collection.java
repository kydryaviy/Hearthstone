package ua.balash.hearthstone.collection;

import ua.balash.hearthstone.card.Card;
import ua.balash.hearthstone.collection.base.Neutral;

import java.util.ArrayList;
import java.util.List;


// TODO make use of Supplier to make different objects for same cards
public class Collection
{
	private static List<Card> collection = new ArrayList<>();

	private Collection()
	{
		addCardSet(new Neutral());
	}

	private static void addCardSet(CardSet card)
	{
		collection.addAll(card.getCards());
	}

	public List<Card> getCollection()
	{
		return collection;
	}
}
