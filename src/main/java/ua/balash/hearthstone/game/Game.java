package ua.balash.hearthstone.game;

import ua.balash.hearthstone.character.Hero;
import ua.balash.hearthstone.character.Minion;

import java.util.Objects;
import java.util.Random;
import java.util.stream.Stream;


public class Game
{
	private static Player player1;
	private static Player player2;
	private static Player currentPlayer;

	public static void start(final Player player1, final Player player2)
	{
		// TODO validate players (deck = 30 cards, no 3 of the same cards, no 2 of legendaries, no cards from other classes)
		Game.player1 = player1;
		Game.player2 = player2;
		currentPlayer = new Random().nextInt(2) == 0 ? player1 : player2;
		// TODO starting hand
	}

	// TODO next turn

	public static void lose(final Hero lostHero)
	{
		final Player lostPlayer = getPlayerByHero(lostHero);
		System.out.println(lostPlayer.getName() + " has lost!");
	}

	private static Player getPlayerByHero(final Hero hero)
	{
		return Stream.of(player1, player2)
				.filter(player -> Objects.equals(hero, player.getHero()))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

	public static void removeMinion(final Minion minion)
	{
		player1.getBoard().remove(minion);
		player2.getBoard().remove(minion);
	}

	public static void summonMinion(final Minion minion, final Player player)
	{
		player.getBoard().add(minion);
	}

	public static Player getCurrentPlayer()
	{
		return currentPlayer;
	}
}
