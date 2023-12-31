
/**
 * An interactive BigFraction caluator that can compute strings of operations and store the last evaluation given.
 *
 * @author Chloe Kelly
 */


import java.io.PrintWriter;
import java.util.Scanner;

public class InteractiveCalculator {
  public static void main(String[] args) {
    BFCalculator calc = new BFCalculator();
    Scanner scan = new Scanner(System.in);
    PrintWriter pen = new PrintWriter(System.out, true);
    // welcome message
    pen.println(
        "Interactive Calculator! Enter your expressions, or \"QUIT\" to exit the program.\nStore your last evaluation with \"STORE [variable (a single lowercase letter)]\"");

    String input = "";
    while (input.compareTo("QUIT") != 0) {
      input = scan.nextLine();

      if (input.compareTo("QUIT") == 0) {
        pen.println("Program ended. Thank you for using!");
        // quit
      } else if (input.split(" ", 2)[0].compareTo("STORE") == 0) {
        calc.store(input.split(" ", 2)[1].toCharArray()[0]);
        // run store command
      } else {
        try{
          pen.println(calc.evaluate(input).toString());
        } catch (Exception e) {
          pen.println("Form incorrect. Please alternate between a fraction/register and an operation.");
        }
        // evaluate
      }
    }

    if (scan != null) {
      scan.close();
    }
  }
}
