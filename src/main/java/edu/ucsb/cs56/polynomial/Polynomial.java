package edu.ucsb.cs56.polynomial;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.text.DecimalFormat;


/** Polynomial represents a polynomial from algebra.
    e.g. 4x<sup>3</sup> + 3x<sup>2</sup> - 5x + 2

   @author Fill In Your Name
*/

public class Polynomial extends ArrayList<Integer> {

  /** Assign {@code Polynomial.debug} to @{code true} or {@code false} to
   *  turn debugging output on or off.
   */

  public static boolean debug = false;

  /**
     no-arg constructor returns a polynomial of degree 1, with value 0
   */

  public Polynomial() {
    // DONE FOR YOU
    // invoke superclass constructor, i.e. the
    // constructor of ArrayList<Integer> with
    super(1); // we want capacity at least 1
    // parameter 1 (capacity, not size)
    this.add(0,0); // uses autoboxing (index, value)
  }

  /**
     Get the degree of the polynomial.
     Should be always {@literal >=0}
     @return degree of the polynomial
   */

  public int getDegree() {
    return 0; // STUB
  }

  /**
     <p>
     Construct polynomial from int array of coefficients.
     The coefficients are listed in order from highest to lowest degree.
     The degree is the size of the array - 1.
     </p>


     <p>
     Examples:
     </p>

     <ul>
       <li>7x<sup>3</sup> - 2x<sup>2</sup> + 3 would be represented as {7,-2,0,3}</li>
       <li>x<sup>4</sup> - 4 would be represented as {1,0,0,0,-4}</li>
     </ul>

     <p>
     NOTE that the order of coefficients passed in the argument to the constructor
     is NOT the way they should be stored in the ArrayList.   
     The argument to the constructor is in high-to-low order by exponent of x, 
     while the ArrayList you construct should be in low-to-high order by exponent of x.
     </p>

     <p>For example, for a cubic, if <code>coeffs</code> is the parameter to the constructor</p>
     <ul>
         <li> <code>coeffs[0]</code> is the x<sup>3</sup> coefficient </li>
         <li> <code>coeffs[1]</code> is the x<sup>2</sup> coefficient </li>
         <li> <code>coeffs[2]</code> is the x coefficient </li>
         <li> <code>coeffs[3]</code> is the constant term </li>
     </ul>

  <p>
  It is done this way so that when initializing a polynomial
  from an array literal, the order of coefficients mirrors the
  way polynomials are typically written, from highest order
  term to lowest order term.  BUT the ArrayList uses a representation
  where term i is the coefficient of the x<sup>i</sup> term, which is the OPPOSITE order.
  </p>

  <p>
  Example: to represent 4x<sup>3</sup> - 7x<sup>2</sup> + 5,<br>
  use: {@code Polynomial p = new Polynomial (new int [] {4,-7,0,5});}<br>
  NOT: {@code Polynomial p = new Polynomial (new int [] {5,0,-7,4});}
  </p>


     @param coeffsHighToLow array of coefficients in order from largest degree down to smallest.  If array has length zero, return a polynomial of degree zero with constant value zero.

   */

  public Polynomial(int [] coeffsHighToLow) {

      // @@ STUB.  Add needed code here
  }


  /**
     <p>
     Return string representation of Polynomial according to the following rules:
     </p>

     <ul>
       <li>
          Leading coefficient if negative, has negative sign in front, with no space.
       </li>
       <li>
          Other {@code +} and {@code -} signs have a space on either side.
       </li>
       <li>
          Coefficients that are ones should be omitted (except in the constant term, i.e. x<sup>0</sup> term).
       </li>
       <li>
          Terms with zero coefficients should be omitted, except in the special
          case where the polynomial is of degree zero, and the constant term
          is zero.  In that case, {@code "0"} should be returned.
       </li>
     </ul>


     <table>
     <caption>Examples of String Representation of Polynomials</caption>
     <tr><th>Math notation</th><th>String Representation</th></tr>
     <tr><td>0</td><td>{@code 0}</td></tr>
     <tr><td>1</td><td>{@code 1}</td></tr>
     <tr><td>-4</td><td>{@code -4}</td></tr>
     <tr><td>2x - 3</td><td>{@code 2x - 3}</td></tr>
     <tr><td>x<sup>2</sup> - 5x + 6</td><td>{@code x^2 - 5x + 6}</td></tr>
     <tr><td>x<sup>2</sup> - x - 1</td><td>{@code x^2 - x - 1}</td></tr>
     <tr><td>x<sup>2</sup> - x </td><td>{@code x^2 - x }</td></tr>
     <tr><td>-x<sup>7</sup> - 2x<sup>5</sup> + 3x<sup>3</sup> - 4x</td><td>{@code -x^7 - 2x^5 + 3x^3 - 4x}</td></tr>
     </table>

     @return string representation of Polynomial
   */

  public String toString() {
    String result = "stub";

    // @@ TODO : write code here
    
    return result;

  }


  /**
     Construct polynomial from string representation
     that matches the output format of the Polynomial toString method.

     That is, you should be able to do:

     <pre>{@literal
     Polynomial p = new Polynomial("0");
     Polynomial p = new Polynomial("1");
     Polynomial p = new Polynomial("-4");
     Polynomial p = new Polynomial("2x - 3");
     Polynomial p = new Polynomial("x^2 - 5x + 6");
     Polynomial p = new Polynomial("x^2 - x - 1");
     Polynomial p = new Polynomial("x^2 - x");
     Polynomial p = new Polynomial("-x^7 - 2x^5 + 3x^3 - 4x");
     }</pre>

     And for any Polymomial object p, the following test should pass:<br>

     <pre>{@literal
     assertEquals(new Polynomial(p.toString()), p);
     }</pre>

     @param s string representation of Polynomial
   */

  public Polynomial(String s) {
    // THIS ONE IS DONE FOR YOU.

    // invoke superclass constructor, i.e. the
    // constructor of ArrayList<Integer> with

    super(1); // we want capacity at least 1

    if (debug) {
      System.out.println("In Polynomial(String s), s=" + s);
    }

    // For information on regular expressions in Java,
    // see http://docs.oracle.com/javase/tutorial/essential/regex

    // First check for special case of only digits,
    // with possibly a - in front
    // i.e. a degree 0 polynomial that is just an integer constant

    Pattern integerConstantPattern =
      Pattern.compile("^-?\\d+$");
    Matcher integerConstantMatcher = integerConstantPattern.matcher(s);

    // if that pattern matches, then the whole string is just
    // an integer constant.  So we can safely call Integer.parseInt(s)
    // to convert to int, and add in this parameter.

    if (integerConstantMatcher.matches()) {
      this.add(0,Integer.parseInt(s));
      return; // we are done!
    }

    // now, try for polynomials of degree 1

    Pattern degreeOnePattern =
      Pattern.compile("^(-?)(\\d*)x( ([+-]) (\\d+))?$");
    // Explanation:
    // start/end         ^                            $
    // sign for x term    (-?)                            group(1)
    // coeff for x term       (\\d*)                      group(2)
    // x in x term                  x
    // optional constant part        (               )?   group(3)
    // sign for constant                ([+-])            group(4)
    // coeff for constant                      (\\d+)     group(5)

    Matcher degreeOneMatcher = degreeOnePattern.matcher(s);

    if (degreeOneMatcher.matches()) {

      int xCoeff = 1;
      int constantTerm = 0;

      String xCoeffSign = degreeOneMatcher.group(1);
      String xCoeffString = degreeOneMatcher.group(2);
      String constantTermSign = degreeOneMatcher.group(4);
      String constantTermString = degreeOneMatcher.group(5);

      if (xCoeffString != null && !xCoeffString.equals("")) {
        xCoeff = Integer.parseInt(xCoeffString);
      }

      if (xCoeffSign != null && xCoeffSign.equals("-")) {
        xCoeff *= -1;
      }

      if (constantTermString != null && !constantTermString.equals("")) {
        constantTerm = Integer.parseInt(constantTermString);
      }

      if (constantTermSign != null && constantTermSign.equals("-")) {
        constantTerm *= -1;
      }

      this.add(0,constantTerm);
      this.add(1,xCoeff);
      return;
    }

    // then try for higher degree

    String twoOrMoreRe =
      "^" // start of the string
      + "([-]?)(\\d*)x\\^(\\d+)" // first x^d term, groups 1,2,3
      + "(( [+-] \\d*x\\^\\d+)*)" // zero or more x^k terms group 4 (and 5)
      + "( [+-] \\d*x)?" // optional x term (group 6)
      + "( [+-] \\d+)?" // optional constant term (group 7)
      + "$"; // the end of the string

    Pattern degreeTwoOrMorePattern  = Pattern.compile(twoOrMoreRe);
    Matcher degreeTwoOrMoreMatcher = degreeTwoOrMorePattern.matcher(s);

    // if we have a match...
    if (degreeTwoOrMoreMatcher.matches()) {

      int firstCoeff = 1;
      String startSign      = degreeTwoOrMoreMatcher.group(1);
      String coeffString    = degreeTwoOrMoreMatcher.group(2);
      String degreeString   = degreeTwoOrMoreMatcher.group(3);
      String middleXtoTheTerms = degreeTwoOrMoreMatcher.group(4);
      String optionalXTermPart = degreeTwoOrMoreMatcher.group(6);
      String optionalConstantTermPart = degreeTwoOrMoreMatcher.group(7);

      if (coeffString != null && !coeffString.equals("")) {
        firstCoeff = Integer.parseInt(coeffString);
      }

      if (startSign != null && startSign.equals("-")) {
        firstCoeff *= -1;
      }

      int degree = Integer.parseInt(degreeString);

      this.ensureCapacity(degree+1); // method of ArrayList<Integer>
      for(int i=0; i<=degree; i++) // initialize all to zero
        this.add(0,0);

      this.set(degree,firstCoeff);

      if (middleXtoTheTerms!=null && !middleXtoTheTerms.equals("")) {

        Pattern addlXtoThePowerTermPattern  =
          Pattern.compile(" ([+-]) (\\d+)(x\\^)(\\d+)");
        Matcher addlXtoThePowerTermMatcher
          = addlXtoThePowerTermPattern.matcher(middleXtoTheTerms);

        while (addlXtoThePowerTermMatcher.find()) {

          int coeff = 1;
          String sign           = addlXtoThePowerTermMatcher.group(1);
          String nextCoeffString    = addlXtoThePowerTermMatcher.group(2);
          String nextDegreeString   = addlXtoThePowerTermMatcher.group(4);

          if (nextCoeffString != null && !nextCoeffString.equals("")) {
            coeff = Integer.parseInt(nextCoeffString);
          }

          if (sign != null && sign.equals("-")) {
            coeff *= -1;
          }

          this.set(Integer.parseInt(nextDegreeString),coeff);

        }
      } // if middleXToTheTerms has something

      // Now all that is left is, possibly, an x term and a constant
      // term.    We need to select them out if they are there.

      if (optionalXTermPart != null && !optionalXTermPart.equals("")) {

        if (debug) {
          System.out.println("optionalXTermPart=" +
                             optionalXTermPart);
        }

        Pattern optXTermPattern =
          Pattern.compile("^ ([+-]) (\\d*)x$");
        Matcher optXTermMatcher = optXTermPattern.matcher(optionalXTermPart);
        optXTermMatcher.find();

        int xCoeff = 1;
        int constantTerm = 0;
        String xCoeffSign = optXTermMatcher.group(1);
        String xCoeffString = optXTermMatcher.group(2);

        if (xCoeffString != null && !xCoeffString.equals("")) {
          xCoeff = Integer.parseInt(xCoeffString);
        }

        if (xCoeffSign != null && xCoeffSign.equals("-")) {
          xCoeff *= -1;
        }

        this.set(1,xCoeff);
      } // optionalXTerm part

      if (optionalConstantTermPart != null
          && !optionalConstantTermPart.equals("")) {

        Pattern constantTermPattern =
          Pattern.compile("^ ([+-]) (\\d+)$");
        Matcher constantTermMatcher
          = constantTermPattern.matcher(optionalConstantTermPart);

        constantTermMatcher.find();

        int constant = 0;
        String sign = constantTermMatcher.group(1);
        String constantString = constantTermMatcher.group(2);

        if (constantString != null && !constantString.equals("")) {
          constant = Integer.parseInt(constantString);
        }

        if (sign!=null && sign.equals("-")) {
          constant *= -1;
        }

        this.set(0,constant);
      } // a constant term is present

      return;
    } // degreeTwoOrMore

    if (debug) {
      System.out.println("at bottom");
    }

    // in the end, if we don't find what we need,
    // through an exception

    throw new IllegalArgumentException("Bad Polynomial String: [" + s + "]");

  }


  /**
  determine whether two polynomials are equal
  (same degree, same coefficients)

  @param o arbitrary object to test for equality
  @return true if objects are equal, otherwise false
  */

  public boolean equals(Object o) {

    // This is boiler plate code for a equals method in Java
    // Always do this first

    if (o == null)
      return false;
    if (!(o instanceof Polynomial))
      return false;

    Polynomial p = (Polynomial) o;

    // @@@ TODO: Check the size of each ArrayList.
    // If they don't match, return false

    // @@@ MAKE THIS ONE WORK FIRST!
    return false;
  }

  /**

  <p>
  Given an {@code int []} of coefficients from lowest to highest
  degree (where the index in the array matches the power of the
  x term), find the degree of the polynomial represented
  by the coefficients shown.
  </p>

  <p>
  This is a utility method that may be useful in converting
  between the low to high and high to low representations of
  coefficients, both in user programs that use the Polynomial
  class, as well as in internal routines used to implement
  Polynomial methods.
  </p>

  @param coeffsLowToHigh coefficients of a polynomial in order from lowest degree to highest degree.  May have trailing zeros.
  @return index of the highest degree non-zero term (if any, otherwise {@code 0})

  */

  public static int degreeOfPolynomialCoeffsLowToHigh(int [] coeffsLowToHigh) {
    
    // e.g. {0, 20, 0, 20, 30, 0, 0, 0, 0}     => 4     (30x^4 + 20x^3 + 20x)
    // e.g. {1, -7, 4, 0, 0, 0}                => 2     (4x^2 -7x + 1)
    // e.g. {0, -11, -12, 0, 0, 0}             => 2     (-12x^2 - 11x) 
    // e.g. {0, -11, 0, 0, 0, 0}               => 1     (-11x)
    // e.g. {-10, 0, 0, 0, 0, 0}               => 0     (0)
      return 0; /* @@@ STUB! */
  }


  /**
  <p>
  Given an {@code int []} of coefficients from highest to lowest
  power (where the x^0 term has the highest index in the array)
  find the degree of the polynomial represented
  by the coefficients shown.
  </p>

  <p>
  This is a utility method that may be useful in converting
  between the low to high and high to low representations of
  coefficients, both in user programs that use the Polynomial
  class, as well as in internal routines used to implement
  Polynomial methods.
  </p>

  @param coeffsHighToLow coefficients of a polynomial in order from highest power of x first to lowest power of x last.  May have leading zeros.
  @return index of the highest degree non-zero term (if any, otherwise {@code 0})
  */

  public static int degreeOfPolynomialCoeffsHighToLow(int [] coeffsHighToLow) {

    // e.g. {0, 0, 0, 0, 30, 20, 0, 20, 0}  => 4     (30x^4 + 20x^3 + 20x)
    // e.g. {0, 0, 4, -7, 1}                => 2     (4x^2 -7x + 1)
    // e.g. {0, 0, 0, -10, -11, 0}          => 2     (-10x^2 - 11)
    // e.g. {0, 0, 0, -10, 0}               => 1     (-10x)
    // e.g. {0, 0, 0, 10}                   => 0     (10)
    // See test cases in PolynomialTest.java for more examples

      return 0; /* @@@ STUB! */

  }


  /**
  <p>
  Convert a list of coefficients in order from
  highest degree to lowest degree (the order used
  for input to the Polynomial constructor) to one where
  the order is lowest degree to highest degree (where index matches
  power of the {@code x} term).
  </p>
  @param coeffsHighToLow coefficients of a polynomial in order from highest degree to lowest degree.   May have leading zeros.
  @return An {@code int []} with
  coefficients in order from lowest degree to highest degree.   No trailing zeros.
  */

  public static int [] lowToHigh(int [] coeffsHighToLow) {

      return null; /* @@@ STUB ! */
  }


  /** Convert a list of coefficients in order from
  lowest degree to highest degree (where index matches
  power of the x term) to one in order from
  highest degree to lowest degree (the order used
  for input to the Polynomial constructor).

  @param coeffsLowToHigh coefficients of a polynomial in order from lowest
    degree to highest degree.  May have trailing zeros.
  @return An {@code int []} with coefficients in order from highest degree to
    lowest degree.   No leading zeros.
  */

  public static int [] highToLow(int [] coeffsLowToHigh) {
     return null; /* @@@ STUB ! */
  }

  /** return a new Polynomial which has as its value the
  this polynomial plus the one passed in as a parameter.

  @param p the Polynomial to add to this one
  @return sum of this Polynomial and p

  */

  public Polynomial plus (Polynomial p) {
     return null; /* @@@ STUB ! */
  }

  /** return a new Polynomial which has as its value the
  this polynomial times the one passed in as a parameter.

  @param p the Polynomial to multiply this one by
  @return product of this Polynomial and p

  */

  public Polynomial times (Polynomial p) {
     return null; /* @@@ STUB ! */
  }

  /** return a new Polynomial which has as its value the
  this polynomial minus the one passed in as a parameter.

  @param p the Polynomial to subtract from this one
  @return the result of this Polynomial minus p

  */


  public Polynomial minus (Polynomial p) {
      // HINT: Can you reuse code you already wrote for
      //   for plus and times?
     return null; /* @@@ STUB ! */
  }

  /** Print Usage message for Polynomial main
   */

  public static void usage() {
      System.err.println("Usage: ");
      System.err.println("   java -jar target/polynomial-1.0.jar  'string' ");
      System.err.println("   java -jar target/polynomial-1.0.jar  'string' + 'string' ");
      System.err.println("   java -jar target/polynomial-1.0.jar  'string' - 'string' ");
      System.err.println("   java -jar target/polynomial-1.0.jar  'string' * 'string' ");
  }

  /**
  <p>
  Main for testing constructing Polynomials from strings,
  and for testing plus, minus and times.
  </p>

  <p>
  At Unix command line:
  </p>
  <ul>
    <li>Use single quotes to make the entire Polynomial be a single argument</li>
    <li>Use {@code \*} when operator is {@code *} (to avoid
  having * expanded as a wildcard.)</li>
  </ul>
  <p>Example:</p>

  <pre>{@literal
   java -jar target/polynomial-1.0.jar 'x^2 + 2x + 3' \* 'x - 4'
  }</pre>

   @param args Command Line Arguments
   */

  public static void main (String [] args) {

    if (args.length < 1) {
      Polynomial.usage();
      System.exit(1); // error code 1
    }

    Polynomial p = new Polynomial(args[0]);

    if (args.length == 1) {
      System.out.println("p=" + p);
      System.exit(0); // successful completion
    }

    if (args.length != 3) {
      System.out.println("There should be either 1 argument or 3 arguments, but there were:" + args.length);
      Polynomial.usage();
      System.exit(1);
    }

    Polynomial p2 = new Polynomial(args[2]);
    if (args[1].equals("+")) {
      Polynomial result = p.plus(p2);
      System.out.println("(" + p.toString() + ") + (" +
                         p2.toString() + ") = " + result.toString());
    }  else if (args[1].equals("-")) {
      Polynomial result = p.minus(p2);
      System.out.println("(" + p.toString() + ") - (" +
                         p2.toString() + ") = " + result.toString());
    } else if (args[1].equals("*")) {
      Polynomial result = p.times(p2);
      System.out.println("(" + p.toString() + ") * (" +
                         p2.toString() + ") = " + result.toString());
    } else {
      System.out.println("Error: illegal operand:" + args[1]);
      Polynomial.usage();
      System.exit(2); // error code 2
    }
  } // end main


} // end class Polynomial
