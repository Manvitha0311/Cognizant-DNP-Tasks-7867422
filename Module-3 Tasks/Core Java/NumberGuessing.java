import java.util.Scanner;
import java.util.Random;

public class NumberGuessing{
    public static void main(String[] args) {
        Random rand = new Random();
        int secret = rand.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        int guess = 0;

        System.out.println("Guess a number between 1 and 100:");

        while (guess != secret) {
            guess = sc.nextInt();
            if (guess < secret) {
                System.out.println("Too low! Try again.");
            } else if (guess > secret) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Correct! The number was " + secret);
            }
        }
        sc.close();
    }
}