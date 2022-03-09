import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

public class GeneralMethods {

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
     * @param b1
     * @param b2
     * @return
     */

    public static byte[] getTwoFixedBytesXOR(byte[] b1, byte[] b2) {

        byte[] outputByte = new byte[b1.length];
        for (int i = 0; i < b1.length; i++){
            outputByte[i] = (byte) (b1[i] ^ b2[i]);
        }
        return outputByte;
    }


    /**
     * 
     * @param str1
     * @param str2
     * @return
     */
    public static String getTwoFixedStringXOR(String str1, String str2) { // str1, str2 from Hex
        try {
            byte[] byteStr1 = Hex.decodeHex(str1);
            byte[] byteStr2 = Hex.decodeHex(str2);
            byte[] outputByte = getTwoFixedBytesXOR(byteStr1, byteStr2);
            String outputString = Hex.encodeHexString(outputByte);
            return outputString;
        } catch (Exception e) {
            return "Exception occurs!";
        }
        
    }

    /**
     * 
     * @param hexStr
     * @return
     * @throws DecoderException
     * @throws UnsupportedEncodingException
     */
    public static String getHexToString(String hexStr) throws DecoderException, UnsupportedEncodingException {
        byte[] bytes = Hex.decodeHex(hexStr);
        String result = new String(bytes);
        return result;
    }

    /**
     * 
     * @param ch
     * @param str
     * @return
     */
    public static String getCharXORString(char key, String str) { // key XOR ct
        String keyString = Character.toString(key).repeat(str.length());
        byte[] strBytes = str.getBytes();
        byte[] keyBytes = keyString.getBytes();
        byte[] outputBytes = getTwoFixedBytesXOR(strBytes, keyBytes);
        String result = new String(outputBytes);
        return result;
    }

    /**
     * 
     * @return
     */
    public static ArrayList<Character> getSingleCharList() {
        ArrayList<Character> chars = new ArrayList<>();
        for (int i = 0; i < 256; i++){
            chars.add((char)i);
        }
        return chars;
    }

    /**
     * 
     * @return
     */
    public static HashMap<Character, Double> getLetterFreqTable() {
        HashMap<Character, Double> map = new HashMap<Character, Double>();
        map.put('a', 0.082);
        map.put('b', 0.015);
        map.put('c', 0.027);
        map.put('d', 0.043);
        map.put('e', 0.13);
        map.put('f', 0.022);
        map.put('g', 0.020);
        map.put('h', 0.062);
        map.put('i', 0.069);
        map.put('j', 0.0015);
        map.put('k', 0.0078);
        map.put('l', 0.041);
        map.put('m', 0.025);
        map.put('n', 0.067);
        map.put('o', 0.078);
        map.put('p', 0.019);
        map.put('q', 0.00096);
        map.put('r', 0.059);
        map.put('s', 0.062);
        map.put('t', 0.096);
        map.put('u', 0.027);
        map.put('v', 0.0097);
        map.put('w', 0.024);
        map.put('x', 0.0015);
        map.put('y', 0.020);
        map.put('z', 0.00078);
        map.put(' ', 0.13);
        return map;
    }

    /**
     * 
     * @param pt
     * @return
     */
    public static double getPlaintextScore(String pt) {
        double score = 0;
        String ptLower = pt.toLowerCase();
        for (int i = 0; i < pt.length(); i++){
            if (getLetterFreqTable().containsKey(ptLower.charAt(i))){
                score += getLetterFreqTable().get(ptLower.charAt(i));
            }
        }
        return score;
    }

}
