import java.math.BigInteger;

/**
 * A simple implementation of Fractions.
 * 
 * @author Samuel A. Rebelsky
 * @author Chloe Kelly and Jayson Kunkel
 * @version 1.2 of August 2023
 */
public class Fraction {
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+
  /*
   * (1) Denominators are always positive. Therefore, negative fractions are
   * represented
   * with a negative numerator. Similarly, if a fraction has a negative numerator,
   * it
   * is negative.
   * 
   * (2) Fractions are not necessarily stored in simplified form. To obtain a
   * fraction
   * in simplified form, one must call the `simplify` method.
   */

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with numerator num and denominator denom.
   */
  public Fraction(BigInteger num, BigInteger denom) {
    if (denom.compareTo(BigInteger.ZERO) == -1) {
      this.num = num.negate();
      this.denom = denom.negate();
    } else {
      this.num = num;
      this.denom = denom;
    }
  } // Fraction(BigInteger, BigInteger)

  public Fraction(BigInteger num) {
    this.num = num;
    this.denom = BigInteger.ONE;
  } //Fraction(BigInteger)

  /**
   * Build a new fraction with numerator num and denominator denom.
   */
  public Fraction(int num, int denom) {
    if (denom < 0) {
      this.num = BigInteger.valueOf(-num);
      this.denom = BigInteger.valueOf(-denom);
    } else {
      this.num = BigInteger.valueOf(num);
      this.denom = BigInteger.valueOf(denom);
    }
  } // Fraction(int, int)

  public Fraction(int num) {
    this.num = BigInteger.valueOf(num);
    this.denom = BigInteger.ONE;
  } //Fraction(int)

  /**
   * Build a new fraction by parsing a string.
   */
  public Fraction(String str) {
    int indexOfSlash = str.indexOf("/");
    String numStr = str.substring(0, indexOfSlash);
    String denomStr = str.substring(indexOfSlash + 1, str.length());

    BigInteger tempNum = BigInteger.valueOf(Integer.parseInt(numStr));
    BigInteger tempDenom = BigInteger.valueOf(Integer.parseInt(denomStr));

    if (tempDenom.compareTo(BigInteger.ZERO) == -1) {
      this.num = tempNum.negate();
      this.denom = tempDenom.negate();
    } else {
      this.num = tempNum;
      this.denom = tempDenom;
    }
  } // Fraction

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  public Fraction simplify() {
    BigInteger tempVal1 = this.num.abs();
    BigInteger tempVal2 = this.denom;
    BigInteger remainder;
    while (tempVal1.compareTo(BigInteger.ZERO) == 1) {
      remainder = tempVal2.mod(tempVal1);
      tempVal2 = tempVal1;
      tempVal1 = remainder;
    } // get GCD

    return new Fraction(this.num.divide(tempVal2), this.denom.divide(tempVal2));
  } // simplify()

  /**
   * Express this fraction as a double.
   */
  public double doubleValue() {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()

  /**
   * Add or subtract the fraction `addMe` to this fraction.
   */
  public Fraction addOrSubtract(Fraction addMe, boolean willAdd) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(addMe.denom);
    // The numerator is more complicated
    if (willAdd) {
      resultNumerator = (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));
    } else {
      resultNumerator = (this.num.multiply(addMe.denom)).subtract(addMe.num.multiply(this.denom));
    }
    // Return the computed value
    return new Fraction(resultNumerator, resultDenominator);
  }// addOrSubtract(Fraction)

  /**
   * Multiply or divide the fraction `multiplyMe` to this fraction.
   */
  public Fraction multiplyOrDivide(Fraction multiplyMe, boolean willMultiply) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    if (willMultiply) {
      resultNumerator = this.num.multiply(multiplyMe.num);
      resultDenominator = this.denom.multiply(multiplyMe.denom);
    } else {
      resultNumerator = this.num.divide(multiplyMe.num);
      resultDenominator = this.denom.divide(multiplyMe.denom);
    }

    return new Fraction(resultNumerator, resultDenominator);

  } // multiplyOrDivide (Fraction, Fraction)

  public Fraction fractional() {
    return new Fraction(this.num.mod(this.denom), this.denom);
  }

  /**
   * Get the denominator of this fraction.
   */
  public BigInteger denominator() {
    return this.denom;
  } // denominator()

  /**
   * Get the numerator of this fraction.
   */
  public BigInteger numerator() {
    return this.num;
  } // numerator()

  /**
   * Convert this fraction to a string for ease of printing.
   */
  public String toString() {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    } // if it's zero

    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()
} // class Fraction
