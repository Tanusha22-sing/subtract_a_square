/* A program to implement the Subtract-A-Square game
 */
import java.util.Scanner;

public class SubtractASquare {
    // Defining constants for coins, heap and player number
    public static final int STARTING_COINS = 13;
    public static final int COUNT_OF_PLAYER = 2;
    public static final int NUMBER_HEAPS = 3;

    // Defining variables for square numbers
    public static final int SQUARE_ONE = 1;
    public static final int SQUARE_FOUR = 4;
    public static final int SQUARE_NINE = 9;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Defining array for heap
        int[] heap = {STARTING_COINS, STARTING_COINS, STARTING_COINS};
        int player = 1;

        System.out.printf(
                "Remaining coins: %d, %d, %d%n",
                heap[0], heap[1], heap[2]);

        boolean gameOver = false;

        // Main loop
        while (!gameOver) {
            int heapChoice = 0;
            int coins = 0;
            boolean validHeap = false;

            // This loop checks for whether integers are being entered for heaps so legal or not
            while (!validHeap) {
                System.out.print(
                        "Player " + player
                        + ": choose a heap: ");
                if (in.hasNextInt()) {
                    heapChoice = in.nextInt();
                    in.nextLine();
                    if (heapChoice >= 1 && heapChoice <= NUMBER_HEAPS && heap[heapChoice - 1] > 0) {
                        validHeap = true;
                    } else {
                        System.out.println("Sorry, that's not a legal heap choice.");
                    }
                } else {
                    System.out.println("Sorry you must enter an integer or skip.");
                    in.next();
                    in.nextLine();
                }
            }
            boolean validCoins = false;
            
            // Player selecting coins and validating for square number coins
            while (!validCoins) {
                System.out.print("Now choose a square number of coins: ");
                if (in.hasNextInt()) {
                    coins = in.nextInt();
                    if ((coins == SQUARE_ONE || coins == SQUARE_FOUR
                            || coins == SQUARE_NINE) && coins <= heap[heapChoice -1]) {
                        validCoins = true;
                    } else {
                        System.out.println(
                                "Sorry that's not a legal number of coins for that heap.");
                    }
                } else {
                    System.out.println("Sorry you must enter an integer.");
                    in.next();
                    in.nextLine();
                }
            }

            validHeap = true;

            // Subtracts a coin from the heap
            heap[heapChoice - 1] -= coins;

            // Checks for which player has won
            if (heap[0] == 0 && heap[1] == 0 && heap[2] == 0) {
                System.out.printf("Player %d wins!%n", player);
                gameOver = true;
            } else {
                System.out.printf(
                        "Remaining coins: %d, %d, %d%n",
                        heap[0], heap[1], heap[2]);
            }



            // Player switches (between 1 and 2)
            player = COUNT_OF_PLAYER + 1 - player;
        }

    }
}
