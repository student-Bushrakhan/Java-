import java.util.*;

public class Game {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        char opt;
        int password = 1020;
        int user_input_pin;
        int attempts = 0; 

        final int MAX_ATTEMPTS = 5; 

        do {
            System.out.println("WELCOME TO MEEZAN BANK");
            System.out.println("Enter your PIN");
            user_input_pin = scn.nextInt();

            if (user_input_pin == password) {
                System.out.println("01: Check Balance");
                System.out.println("02: Withdraw Balance");
                System.out.println("03: Transfer Balance");
                
                break; 
            } else {
                attempts++;
                if (attempts >= MAX_ATTEMPTS) {
                    System.out.println("Your account has been blocked.");
                    break; 
                }
                System.out.println("INVALID PASSWORD");
                System.out.println("CARD JIS KA HAY USE WAPIS DE AO");
            }

        } while (true); 
    }
}
