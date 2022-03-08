import java.util.Scanner;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

public class HexToBase64 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); // create a Scanner object
        System.out.println("Enter the hex string: ");

        String hexString = sc.nextLine();
        sc.close();

        try {
          byte[] decodeHex = Hex.decodeHex(hexString); 
          // Converts an array of characters representing hexadecimal values into an array of bytes of those same values.
          String encodeHexB64 = Base64.encodeBase64String(decodeHex); 
          // Encodes binary data using the base64 algorithm but does not chunk the output. 
          System.out.println(hexString + " is converted to " + encodeHexB64); 
        } catch (Exception e) {
          System.out.println("Exception.");
        }

    }//End of main
  }//End of HexToBase64 Class