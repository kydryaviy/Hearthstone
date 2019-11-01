package ua.balash.hearthstone.app;

import ua.balash.hearthstone.thread.PlayerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static ua.balash.hearthstone.app.Constants.NUM_OF_PLAYERS;


// Suppress infinite loop warning
@SuppressWarnings("squid:S2189")
public class Server
{
    private Server(int port) {
        try (final ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            final Executor executor = Executors.newFixedThreadPool(NUM_OF_PLAYERS);

            int clients = 0;
            while (clients < NUM_OF_PLAYERS)
            {
                try {
                    final Socket socket = server.accept();
                    System.out.println("Client accepted");
                    ++clients;

                    executor.execute(new PlayerThread(socket));
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        new Server(5000);
    }
}
