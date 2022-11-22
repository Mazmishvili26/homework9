import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {


    Socket socket;
    ObjectInputStream in;
    ObjectOutputStream out;
    String message;

    public void run () {

        try {

            while (true){

                socket = new Socket(InetAddress.getByName("localhost"), 8081);


                System.out.println("Client agzavnis : ");
                Scanner scanner = new Scanner(System.in);
                message = scanner.nextLine();

                out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(message);


                in = new ObjectInputStream(socket.getInputStream());
                System.out.println("Clientshi shemovida -> " + in.readObject());

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
