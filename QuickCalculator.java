import java.io.PrintWriter;

public class QuickCalculator {
    public static void main(String[] args) {
        PrintWriter pen = new PrintWriter(System.out, true); // new output instance
        BFCalculator quickCalc = new BFCalculator(); //new calculator
        String expression = "";
        if (args.length < 1) {
            pen.println("Please input an expression");
            System.exit(1);
        } // check for correct number of command line args

        for (int i = 0; i < args.length; i++) {
            expression = expression.concat(args[i] + " "); //combines args into single string
        }
        pen.println(quickCalc.evaluate(expression).toString());
    }
}
