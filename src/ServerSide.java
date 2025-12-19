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
            ServerSocket serverSoc = new ServerSocket(8080);
            // create a new socket object and capture it in a socket reference

            // could do a conditional like while to loop and run multiple times ... but not rn
            Socket clientSoc = serverSoc.accept();
            // print a statement stating that a connection is established
            System.out.println("Connection has been established");
            // need to read the string thats  coming in from sockets input stream
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSoc.getInputStream()));
            String str = in.readLine();


            //check to make sure its askign for name
            if (str != null && str.equals("Name")) {
                String res = "Your name is: Ramin W";
                //now send the information to the client
                PrintWriter out = new PrintWriter(clientSoc.getOutputStream(), true);
                out.println(res);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
