package ua.balash.hearthstone.thread;

import ua.balash.hearthstone.tmp.Chat;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


// Suppress infinite loop warning
@SuppressWarnings("squid:S2189")
public class PlayerThread implements Runnable
{
	private final Socket socket;
	private String name;

	public PlayerThread(final Socket socket)
	{
		this.socket = socket;
	}

	@Override
	public void run()
	{
		try (final DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream())))
		{
			try (final DataOutputStream out = new DataOutputStream(socket.getOutputStream()))
			{
				final String name = in.readUTF();
				this.name = name;
				out.writeUTF(Chat.getHistory());
				while (true)
				{
					final String line = in.readUTF();
					Chat.add(name + ": " + line);
					out.writeUTF(Chat.getHistory());
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				socket.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
