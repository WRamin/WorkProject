
import java.net.Socket;
import java.io.*;

public class ClientSide {
    public static void main(String[] arg) {
        try
        {
            // print a statement saying client started
            System.out.println("Client started");
            // create a socket... could give them variables but not rn
            Socket soc = new Socket("localhost", 8080);
            //  buffer reader reads entire string from keyboard
            BufferedReader userInput = new BufferedReader(new InputStreamReader(soc.getInputStream()));

            // referenced in str variable
            String str = "Name";

            // to send to server immediately (autoflush)
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            //send the request
            out.println(str);
            // read the data from the server and preint it on the screen
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));

            //read the text from the server... one line
            String res = in.readLine();
            System.out.println(res);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
