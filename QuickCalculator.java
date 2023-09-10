public class QuickCalculator {
    public static void main(String[] args){
        Fraction test = new Fraction(3, 4);
        System.out.println(test);
        System.out.println(test.simplify());
        System.out.println(test.multiplyOrDivide(new Fraction(3,4), true));
    }
}
