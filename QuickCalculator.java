
/**
 * A quick calculator that can read a single expression from the command-line.
 *
 * @author Chloe Kelly
 */

import java.io.PrintWriter;

public class QuickCalculator {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true); // new output instance
    BFCalculator quickCalc = new BFCalculator(); // new calculator
    if (args.length < 1) {
      pen.println("Please input an expression");
      System.exit(1);
    } // check for correct number of command line args

    for (int i = 0; i < args.length; i++) {
      if (args[i].split(" ", 2)[0].compareTo("STORE") == 0) {
        quickCalc.store(args[i].split(" ", 2)[1].toCharArray()[0]);
        // run store command
      } else {
        try {
          pen.println(quickCalc.evaluate(args[i]).toString());
        } catch (Exception e) {
          pen.println("Form incorrect. Please alternate between a fraction/register and an operation.");
        }
        // evaluate
      }
    }
  }
}
