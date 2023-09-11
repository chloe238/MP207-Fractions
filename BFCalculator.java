public class BFCalculator {

        BigFraction[] memoryStore = new BigFraction[26];
        BigFraction lastEval;
    
    public void store(char register){   
        int index = (int) register - 97;
        
        this.memoryStore[index] = this.lastEval;
    } //store(char)

    public BigFraction evaluate(String exp){
        String[] exparr = exp.split(" ");

        for(int i = 0; i < exparr.length; i++){
            if(Character.isLowerCase(exparr[i].toCharArray()[0])) {
                exparr[i] = this.memoryStore[((int) (exparr[i].toCharArray()[0]) - 97)].toString();
            }
        }//convert any stored variables to fractions

        BigFraction result = new BigFraction(exparr[0]);

        for(int i = 1; i < (exparr.length - 1); i++){
            switch(exparr[i]){
                case "+": 
                    result = result.addOrSubtract(new BigFraction(exparr[i+1]), true);
                    break;
                case "-": 
                    result = result.addOrSubtract(new BigFraction(exparr[i+1]), false);
                    break;
                case "*": 
                    result = result.multiplyOrDivide(new BigFraction(exparr[i+1]), true);
                    break;
                case "/": 
                    result = result.multiplyOrDivide(new BigFraction(exparr[i+1]), false);
                    break;
                default: break;
            }
        }
        
        this.lastEval = result.simplify();
        return result.simplify();
    } //evaluate(String)
}
