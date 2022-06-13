package hw2_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;


    public static void main(String[] args) {
        EchoClient ec = new EchoClient();
        ec.start();

    }

    private void start() {
        try {
            openConnection();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                sendMessage(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void sendMessage(String message) {
        try {
            out.writeUTF(message);
            if (message.equals("/end")) {
                closeConnection();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openConnection() throws IOException {
        socket = new Socket("127.0.0.1", 8189);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        Thread t1 = new Thread(() -> {
            try {
                while (true) {
                    String message = in.readUTF();

                    if (message.equalsIgnoreCase("/end")) {
                        out.writeUTF("/end");
                        break;
                    }
                    System.out.println("Сообщение от сервера : " + message);

                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                closeConnection();

            }

        });
        t1.setDaemon(true);
        t1.start();
    }

    private void closeConnection() {

        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.exit(0);


    }
}
