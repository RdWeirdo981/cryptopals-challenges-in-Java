import java.util.ArrayList;
import java.util.Scanner;
import org.apache.commons.codec.binary.Hex;

public class FixedXOR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> scanArrayList = new ArrayList<String>();
        for (int i = 0; i < 2; i++){
            System.out.printf("Enter string %s: \n", i+1);
            scanArrayList.add(sc.nextLine());
        } // read str1 & str2
        sc.close();
        
        // convert to byte
        try {
            byte[] byteStr1 = Hex.decodeHex(scanArrayList.get(0));
            byte[] byteStr2 = Hex.decodeHex(scanArrayList.get(1));
            byte[] outputByte = new byte[byteStr1.length];
            for (int i = 0; i < byteStr1.length; i++){
                outputByte[i] = (byte) (byteStr1[i] ^ byteStr2[i]);
            }
            String outputString = Hex.encodeHexString(outputByte);
            System.out.printf("The output string is: %s", outputString);
        } catch (Exception e) {
            System.out.println("Exception occurs!");
        }
        
    }
}
