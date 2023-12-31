import java.util.Scanner;
public class Main {
    private static int number;
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Press 1 for Encrypt");
        System.out.println("Press 2 for Decrypt");
        int choice = obj.nextInt();

        if (choice == 1){
            System.out.println(encDec(number, false));
        }
        else if (choice == 2){
            System.out.println(encDec(number, true));
        }

    } // end of Main
    public static int encDec(int number, boolean isdecrypt) {
        int swapnum = 7;
        int res = 0;
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter 4 digit number");
        number = obj.nextInt();
        if (isdecrypt){
            swapnum = 3;
        }

        for (int i = 0; i <= 3; i++) {
            int num = number % 10; // Gives the last number of the row of digits
            num = num + swapnum; // adds 7 to the number
            num = num % 10; // gets the remainder
            number = number / 10; // Removes the last digit from the main row of digits
            res += num * Math.pow(10, i);

        } // end of encryption

        for (int i = 0; i < 2 ; i++){
            int restnum = res % 10 ; //removes the last digit and stores the rest in restnum

            res /= 10; // gets the last digit and stores it in res
            res = res + restnum * 1000; // takes res (last digit) and restnum(the 3 other) and shifts it once pr loop
        } // end of number swap
        return res;
    } // end of Enc()
} // end of Class