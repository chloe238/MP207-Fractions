import java.io.PrintWriter;
import java.util.Scanner;

public class InteractiveCalculator {
    public static void main(String[] args) {
        BFCalculator calc = new BFCalculator();
        Scanner scan = new Scanner(System.in);
        PrintWriter pen = new PrintWriter(System.out, true);
        pen.println("Interactive Calculator! Enter your expressions, or \"QUIT\" to exit the program.\nStore your last evaluation with \"STORE [variable (a single letter)]\"");
        String input = "";
        while(input.compareTo("QUIT") != 0){
            input = scan.nextLine();

            if(input.compareTo("QUIT") == 0){
                pen.println("Program ended. Thank you for using!");
            } else if(input.split(" ", 2)[0].compareTo("STORE") == 0){ //srun store
                pen.println("Store success");  
            } else { //run evaluate
                pen.println(calc.evaluate(input).toString());
            }
        }

        if(scan != null) {
            scan.close();
        }
    }
}