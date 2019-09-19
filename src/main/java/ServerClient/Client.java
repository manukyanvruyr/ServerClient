package ServerClient;

import java.net.*;
import java.io.*;

public class Client
{
    private Socket socket;

    public Client(final String address, int port) throws IOException {
        socket = new Socket(address, port);
        System.out.println("Connected");
    }

    public void sendToServer() throws IOException {
        DataInputStream in = new DataInputStream(System.in);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String line = "";
        while (!line.equals("end")) {
            line = in.readLine();
            out.writeUTF(line);
        }

        in.close();
        out.close();
        socket.close();
    }

    public static void main(String args[]) {
        try {
            Client client = new Client("127.0.0.1", 5000);
            client.sendToServer();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
