package wumpus.networking;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

import com.sun.corba.se.impl.legacy.connection.SocketFactoryConnectionImpl;

public class SocketClient {
	 public static void main(String[] args) {
		    /** Define a host server */
		    String host = "localhost";
		    /** Define a port */
		    int port = 19999;

		    StringBuffer instr = new StringBuffer(); // reading input stream from server
		    String TimeStamp; // used to communicate with server
		    System.out.println("SocketClient initialized");
		    
		    try {
		        /** Obtain an address object of the server */
		    	
		        InetAddress address = InetAddress.getByName(host);
		        System.out.println(address);
		        /** Establish a socket connetion */
		        
		       Socket connection = new Socket(address, port);  // throw exception connected
		       
		       BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
		       OutputStreamWriter osw = new OutputStreamWriter(bos, "US-ASCII");
		       
		       BufferedInputStream bis = new BufferedInputStream(connection.
		    	          getInputStream());
		       
		       
		       TimeStamp = new java.util.Date().toString();
		       String process = "Calling the Socket Server on "+ host + " port " + port +
		           " at " + TimeStamp +  (char) 13;

		       /** Write across the socket connection and flush the buffer */
		       osw.write(process);
		       osw.flush();
		       
		       
		       
		    	      /**Instantiate an InputStreamReader with the optional
		    	       * character encoding.
		    	       */
		    BufferedInputStream input = new BufferedInputStream(connection.getInputStream());
		    
		    InputStreamReader str = new InputStreamReader(input, "US-ASCII");
		    
		    int reads; // reads the information sent by the socket;
		    
		    while((reads = str.read()) != 13){   	
		    	instr.append((char)reads);
		    }
		    
		    connection.close();
		    
		      System.out.println(instr); // what has the server responded
		     
		    }
		    	catch (IOException f) {
		        System.out.println("IOException: " + f.getStackTrace());
		      }
		      catch (Exception g) {
		        System.out.println("Exception: " + g.getMessage());
		      }
	 }
}
