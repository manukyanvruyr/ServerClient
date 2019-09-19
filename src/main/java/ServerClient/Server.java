package ServerClient;

import java.net.*;
import java.io.*;

public class Server
{
    private ServerSocket serverSocket;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started");
        System.out.println("Waiting for a client...");
    }

    public void readFromClient() throws IOException {
        Socket socket = serverSocket.accept();
        System.out.println("Client accepted");
        DataInputStream in = new DataInputStream(socket.getInputStream());

        String line = "";
        while (!line.equals("end")) {
            line = in.readUTF();
            System.out.println(line);
        }
        System.out.println("Closing connection");

        socket.close();
        in.close();
    }

    public static void main(String args[]) {
        try {
            Server server = new Server(5000);
            server.readFromClient();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
