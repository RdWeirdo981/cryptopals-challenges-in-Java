/**
 * SingleByteXOR
 */

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import org.apache.commons.codec.DecoderException;

public class SingleByteXOR {

    public static void main(String[] args) throws UnsupportedEncodingException, DecoderException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String inputString = sc.nextLine();
        sc.close();

        Map<HashMap<Character, String>, Double> map = new HashMap<>();
        String decodeString = GeneralMethods.getHexToString(inputString); // convert hexString to utf-8
        for (char ch: GeneralMethods.getSingleCharList()){
            String singleResult = GeneralMethods.getCharXORString(ch, decodeString);
            double singleScore = GeneralMethods.getPlaintextScore(singleResult);
            HashMap<Character, String> singleMap = new HashMap<>();
            singleMap.put(ch, singleResult);
            map.put(singleMap, singleScore);
        }
        List<Entry<HashMap<Character, String>, Double>> sortList = new ArrayList<>(map.entrySet());
        sortList.sort(Entry.comparingByValue());
        Collections.reverse(sortList);

        for (int i = 0; i < 3; i++){
            System.out.println("Key & plaintext: " + sortList.get(i).getKey() + "\n");
            System.out.println("Score: " + sortList.get(i).getValue() + "\n");
        }
        
    }
}