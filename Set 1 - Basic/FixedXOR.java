import java.util.ArrayList;
import java.util.Scanner;

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
        String result = GeneralMethods.getTwoFixedStringXOR(scanArrayList.get(0), scanArrayList.get(1));
        System.out.printf("Result: %s", result);
        
    }
}
