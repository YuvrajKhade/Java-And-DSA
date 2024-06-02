import java.net.*;
import java.io.*;
import java.util.*;
public class Server {
 public static void main(String args[]) throws IOException {
	
	Scanner sc=new Scanner(System.in);
	 ServerSocket s = new ServerSocket(1254);
	 Socket s1=s.accept(); 
	 OutputStream s1out = s1.getOutputStream();
	 DataOutputStream dos = new DataOutputStream (s1out);
	 InputStream ins=s1.getInputStream();
	 DataInputStream dis=new DataInputStream(ins);
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
	String str="",str2="";  
	while(!str.equals("stop")){  
	str=dis.readUTF();  
	System.out.println("client says: "+str);  
	str2=br.readLine();  
	dos.writeUTF(str2);  
	dos.flush();  
	}  
	dis.close();  
	s.close();  
	s1.close();  
	sc.close();
 }
}
	