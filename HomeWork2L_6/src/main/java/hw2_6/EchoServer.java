package hw2_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {


    private DataInputStream in;
    private DataOutputStream out;


    public static void main(String[] args) {
        Socket socket = null;

        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Thread t = new Thread(() -> {

                try {
                    Scanner scanner = new Scanner(System.in);
                    while (true) {
                        out.writeUTF(scanner.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            t.setDaemon(true);
            t.start();

            while (true) {

                String message = in.readUTF();
                if (message.equals("/end")) {

                    break;
                }
                System.out.println("Сообщение от клиента: " + message);
                out.writeUTF("Эхо: " + message);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
