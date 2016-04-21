
/*  The java.net package contains the basics needed for network operations. */
import java.net.*;
/* The java.io package contains the basics needed for IO operations. */
import java.io.*;
/** The SocketClient class is a simple example of a TCP/IP Socket Client.
 *
 */

public class SocketClient {
	public Socket s;
	
	
	public SocketClient() throws UnknownHostException, IOException{
			s = new Socket("localhost", 8000);	

	}
	
	public void sendString(String d) throws UnknownHostException, IOException 
    {
		

		OutputStreamWriter outs = new OutputStreamWriter(s.getOutputStream());
        outs.write(d);
        outs.flush();
        
    } 
	
	public void close() throws IOException{
		s.close();
	}
}