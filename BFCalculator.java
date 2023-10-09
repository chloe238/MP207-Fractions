/**
 * A calculator that can do basic calculations between BigFractions and store up
 * to 26 previous evaluations.
 *
 * @author Chloe Kelly
 */

public class BFCalculator {

  BigFraction[] memoryStore = new BigFraction[26];
  BigFraction lastEval;

  /**
   * Stores the last evaluated fraction as register
   */
  public void store(char register) {
    int index = (int) register - 'a';

    this.memoryStore[index] = this.lastEval;
  } // store(char)

  /**
   * Evaulates the given expression. 
   * @throws Exception if the expression is formatted incorrectly.
   */
  public BigFraction evaluate(String exp) throws Exception{
    String[] exparr = exp.split(" ");

    for (int i = 0; i < exparr.length; i++) {
      if (Character.isLowerCase(exparr[i].toCharArray()[0])) {
        exparr[i] = this.memoryStore[((int) (exparr[i].toCharArray()[0]) - 97)].toString();
      } //if
    } // convert any stored variables to fractions

    for (int i = 0; i < exparr.length; i += 2) {
      if (exparr[i].compareTo("+") == 0 || exparr[i].compareTo("-") == 0 || exparr[i].compareTo("*") == 0
          || exparr[i].compareTo("/") == 0) {
        throw new Exception();
      } //check for proper formatting
    } //for

    BigFraction result = new BigFraction(exparr[0]);

    for (int i = 1; i < (exparr.length - 1); i += 2) {
      switch (exparr[i]) {
        case "+": //add
          result = result.addOrSubtract(new BigFraction(exparr[i + 1]), true);
          break;
        case "-": //subtract
          result = result.addOrSubtract(new BigFraction(exparr[i + 1]), false);
          break;
        case "*": //multiply
          result = result.multiplyOrDivide(new BigFraction(exparr[i + 1]), true);
          break;
        case "/": //divide
          result = result.multiplyOrDivide(new BigFraction(exparr[i + 1]), false);
          break;
        default:
          throw new Exception();
      }//switch
    }//for

    this.lastEval = result.simplify(); //return in simplest form
    return result.simplify();
  } // evaluate(String)
}//BFCalculator()
