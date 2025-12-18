import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide {
    public static void main(String[] arg) {
        try {
            System.out.println("Waiting for client...");
            // create a server socket object on port 8080
            ServerSocket ss = new ServerSocket(8080);
            // create a new socket object and capture it in a socket reference
            Socket soc = ss.accept();
            // print a statement stating that a connection is established
            System.out.println("Connection has been established");
            // need to read the string thats  coming in from sockets input stream
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            String str = in.readLine();

            //now send the information to the client
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            out.println(str);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
