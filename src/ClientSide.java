
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
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a string");
            // take the string and is referenced in str variable
            String str = userInput.readLine();

            // to send to server
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            out.println(str);
            // read the data from the server and preint it on the screen
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            out.println("The server returned: " + str);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
