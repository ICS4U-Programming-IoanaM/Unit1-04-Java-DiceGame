import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This program is a game in which the user has to guess
 * what the number on a dice is.
 *
 * @author Ioana Marinescu
 * @version 1.0
 * @since 2024-03-04
 */
public final class DiceGame {
  /** Private constructor to prevent instantiation of this utility class. */
  private DiceGame() {
    // this comment makes the linter happy
  }

  /**
   * The main method prints a stylish greeting message.
   *
   * @param args Command-line arguments (not used in this program)
   */
  public static void main(final String[] args) {
    // imports scanner
    Scanner scanner = new Scanner(System.in);
    // variable declaration
    int min = 1;
    int max = 6;
    int counter = 0;
    int userNum, diceNum; 

    // display introduction message
    System.out.print("Welcome to the Dice Game! You will have to guess");
    System.out.println("the number on the dice in order to win!");

    try {
      // generates random number
      diceNum = (int) Math.random() * (min - max) + min;

      // do while that loops until user guesses correctly
      do {
        // getting user input for user's guess
        System.out.println("Enter a number (1-6):");
        userNum = scanner.nextInt();

        // checks if user is higher than dice number
        if (userNum > diceNum) {
          System.out.println("The dice rolled higher. Guess again!");

        // checks if user is lower than dice number
        } else if (userNum < diceNum) {
          System.out.println("The dice rolled lower. Guess again!");
        }

        //counter increment
        counter++;
      } while (userNum != diceNum);

      // displays result to console
      System.out.print("Congrats! You guessed correctly! It took you ");
      System.out.println(counter + " guesses.");

    } catch (InputMismatchException error) {
      // output error message to console
      System.out.println("Please enter a valid integer from 1 to 6.");
    }

    // closes scanner
    scanner.close();
  }
}
