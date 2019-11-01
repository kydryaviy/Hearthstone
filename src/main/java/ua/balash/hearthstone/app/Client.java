package ua.balash.hearthstone.app;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.stream.IntStream;


// Suppress infinite loop warning
@SuppressWarnings("squid:S2189")
public class Client
{

	private Client(final String address, final int port)
	{
		try (final Socket socket = new Socket(address, port))
		{
			System.out.println("Connected");

			try (final DataInputStream input = new DataInputStream(System.in))
			{

				try (final DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream())))
				{
					try (final DataOutputStream out = new DataOutputStream(socket.getOutputStream()))
					{
						System.out.println("Enter your name: ");
						final String name = input.readLine();
						out.writeUTF(name);
						refreshScreen(in);
						while (true)
						{
							final String line = input.readLine();
							out.writeUTF(line);
							refreshScreen(in);

						}
					}
				}
			}
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		new Client("127.0.0.1", 5000);
	}

	private void refreshScreen(final DataInputStream in) throws IOException
	{
		IntStream.range(1, 20).forEach(n -> System.out.println(System.lineSeparator()));
		System.out.println(in.readUTF());
	}
}
