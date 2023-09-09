import java.io.PrintWriter;
import java.util.Scanner;

public class InteractiveCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PrintWriter pen = new PrintWriter(System.out, true);
        pen.println("Interactive Calculator! Enter your equations, or \"QUIT\" to exit the program.");
        String input = "";
        while(input.compareTo("QUIT") != 0){
            input = scan.nextLine();

            if(input.compareTo("QUIT") == 0){
                pen.println("Program ended. Thank you for using!");
            } else {
                
                pen.println(input);
            }
        }

        if(scan != null) {
            scan.close();
        }
    }
}