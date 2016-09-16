

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NsLookup
{

  public void resolve(String host)
  {
    try
    {
      InetAddress inetAddress = InetAddress.getByName(host);
      
      
      System.out.println("Host: " +
          inetAddress.getAllByName(host)[1].toString());
      System.out.println("IP Address: " +
          inetAddress.getHostAddress());
    }
    catch (UnknownHostException e)
    {
      e.printStackTrace();
    }
  }

  public static void main(String[] args)
  {
    new NsLookup().resolve("auto-300.corp.airwave.com");
//    new NsLookup().resolve("auto-jedi.corp.airwave.com");
//    byte[] b = {10,2,35,43};
//    
//    
//    new NsLookup().resolve(b);
   
  }

}
