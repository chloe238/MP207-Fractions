import java.util.*;

public class BFCalculator {
    public void store(char register){
        Map<Character, Fraction> storedFraction = new HashMap(register, new Fraction(3));
        storedFraction.put(register, new Fraction(4));
    }
    
    public Fraction evaluate(String exp){
        String[] exparr = exp.split(" ");
        Fraction result = new Fraction(exparr[0]);

        for(int i = 1; i < (exparr.length - 1); i++){

            switch(exparr[i]){
                case "+": 
                    result = result.addOrSubtract(new Fraction(exparr[i+1]), true);
                    break;
                case "-": 
                    result = result.addOrSubtract(new Fraction(exparr[i+1]), false);
                    break;
                case "*": 
                    result = result.multiplyOrDivide(new Fraction(exparr[i+1]), true);
                    break;
                case "/": 
                    result = result.multiplyOrDivide(new Fraction(exparr[i+1]), false);
                    break;
                default: break;
            }
        }
        
        return result.simplify();
    } //evaluate(String)
}
