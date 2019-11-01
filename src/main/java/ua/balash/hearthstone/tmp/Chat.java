package ua.balash.hearthstone.tmp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


// TODO remove once game is done
public class Chat
{
	private Chat() {}

	private static List<String> history = new ArrayList<>();

	public static void add(final String line)
	{
		history.add(line);
	}

	public static String getHistory()
	{
		return history.stream().collect(Collectors.joining(System.lineSeparator()));
	}
}
