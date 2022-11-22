import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server extends Thread {


    Socket socket;
    ObjectInputStream in;
    ObjectOutputStream out;
    String message;

    public void run () {

        try {
            ServerSocket serverSocket = new ServerSocket(8081);

            while (true){
                socket = serverSocket.accept();

                in = new ObjectInputStream(socket.getInputStream());
                System.out.println("Servershi shemovida -> " + in.readObject());


                System.out.println("Server agzavnis : ");
                Scanner scanner = new Scanner(System.in);
                message = scanner.nextLine();

                out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(message);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

}
