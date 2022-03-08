import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

public class ConvertClass {

    /**
     * @param hexString
     * @return 
     */
    public static String getHexToBase64(String hexString) {
        try {
            byte[] decodeHex = Hex.decodeHex(hexString); 
            // Converts an array of characters representing hexadecimal values into an array of bytes of those same values.
            String encodeHexB64 = Base64.encodeBase64String(decodeHex); 
            // Encodes binary data using the base64 algorithm but does not chunk the output. 
            return encodeHexB64;
        } catch (Exception e) {
            return "Exception occurs!";
        }
    }

    /**
     * 
     * @param str1
     * @param str2
     * @return
     */
    public static String getTwoFixedStringXOR(String str1, String str2) {
        try {
            byte[] byteStr1 = Hex.decodeHex(str1);
            byte[] byteStr2 = Hex.decodeHex(str2);
            byte[] outputByte = new byte[byteStr1.length];
            for (int i = 0; i < byteStr1.length; i++){
                outputByte[i] = (byte) (byteStr1[i] ^ byteStr2[i]);
            }
            String outputString = Hex.encodeHexString(outputByte);
            return outputString;
        } catch (Exception e) {
            return "Exception occurs!";
        }
        
    }

}
