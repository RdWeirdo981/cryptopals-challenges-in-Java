import java.util.Scanner;

public class HexToBase64 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); // create a Scanner object
        System.out.println("Enter the hex string: \n");
        String hexString = sc.nextLine();
        sc.close();

        String result = GeneralMethods.getHexToBase64(hexString);
        System.out.printf("Result: %s\n", result);

    }//End of main
  }//End of HexToBase64 Class