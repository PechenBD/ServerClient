import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) {
        String localhost = "127.0.0.1";
        int port = 1853;

        try (Socket clientSocket = new Socket(localhost, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("Kirill");

            String response = in.readLine();
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
