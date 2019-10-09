package edu.ucsb.cs56.polynomial;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * The test class PolynomialTest, to test the Polynomial class
 *
 * @author Phill Conrad
 * @version CS56, 14W, lab03
 * @see Polynomial
 */

public class PolynomialTest
{
  // Instead of using an @Before to set up the polynomials, I've hard coded
  // the polynomials directly in each test.  I started settting it up
  // with an @Before routine, but I found that it was tedious to have
  // to keep referring back to the top of the file to see what the
  // values of each polynomial were.  This way, you can see the entire
  // test all on the screen at the same time.

  /**
     test no arg constructor from Polynomial
     @see Polynomial#Polynomial()

   */

  @Test public void testNoArgConstructor()
  {
    // default polynomial has degree 0, and value 0
    Polynomial p = new Polynomial();
    assertEquals(0,p.getDegree());
    assertEquals(0,(int) p.get(0));
  }

  /**
     test constructor that initializes from int array
     @see Polynomial#Polynomial(int [] coeffs)
   */

  @Test public void testConstructorIntArray()
  {
    Polynomial p = new Polynomial(new int[] {2,1,5});
    assertEquals(2, p.getDegree());
    assertEquals(2, (int) p.get(2));
    assertEquals(1, (int) p.get(1));
    assertEquals(5, (int) p.get(0));
  }

  /**
     test toString on {@code "0"}
     @see Polynomial#toString

   */

  @Test public void testToString1()
  {
    Polynomial p1 = new Polynomial(new int[] {0});
    assertEquals("0",p1.toString());
  }
  /**
     test toString on {@code "1"}
     @see Polynomial#toString
   */

  @Test public void testToString2()
  {
    Polynomial p2 = new Polynomial(new int[] {1});
    assertEquals("1",p2.toString());
  }

  /**
     test toString on {@code "2x - 3"}
     @see Polynomial#toString
   */

  @Test public void testToString3()
  {
    Polynomial p3 = new Polynomial(new int[] {2,-3});
    assertEquals("2x - 3",p3.toString());
  }

  /**
     test toString on {@code "x^2 - 5x + 6"}
     @see Polynomial#toString
   */

  @Test public void testToString4()
  {
    Polynomial p4 = new Polynomial(new int[] {1, -5, 6});
    assertEquals("x^2 - 5x + 6",p4.toString());
  }

  /**
     test toString on {@code "7x^4 - 8x^3 - 9x^2 - 10x - 11"}
     @see Polynomial#toString
   */

  @Test public void testToString5()
  {
    Polynomial p5 = new Polynomial(new int[] {7, -8, -9, -10, -11});
    assertEquals("7x^4 - 8x^3 - 9x^2 - 10x - 11",p5.toString());
  }

  /**
     test toString on {@code "-x^7 - 2x^5 + 3x^3 - 4x"}
     @see Polynomial#toString
   */

  @Test public void testToString6()
  {
    Polynomial p6 = new Polynomial(new int[] {-1, 0, -2, 0, 3, 0, -4, 0});
    assertEquals("-x^7 - 2x^5 + 3x^3 - 4x",p6.toString());
  }

  /**
     test toString on {@code "-2x^11 + x"}
     @see Polynomial#toString
   */

  @Test public void testToString7()
  {
    Polynomial p7 =
      new Polynomial
    (new int[] {-2,0,0,0,0,0,0,0,0,0,1,0 });
    assertEquals("-2x^11 + x",p7.toString());
  }

  /**
     test equals method on {@code "x^2 - 5x + 6"}
     @see Polynomial#equals
   */

  @Test public void testEquals4()
  {
    Polynomial p4a = new Polynomial(new int[] {1, -5, 6});
    Polynomial p4b = new Polynomial(new int[] {1, -5, 6});
    assertEquals(true,p4a.equals(p4b));

  }

  /**
     test equals method on {@code new Polynomial(new int[] {-2,0,0,0,0,0,0,0,0,0,1,0 });}
     @see Polynomial#equals
   */

  @Test public void testEquals7()
  {
    Polynomial p7a = new Polynomial(new int[] {-2,0,0,0,0,0,0,0,0,0,1,0 });
    Polynomial p7b = new Polynomial(new int[] {-2,0,0,0,0,0,0,0,0,0,1,0 });
    assertEquals(true,p7a.equals(p7b));
  }

  /**
     test equals method (should return false when null passed)
     @see Polynomial#equals
   */

  @Test public void testEqualsNull()
  {
    Polynomial p7a = new Polynomial (new int[] {-2,0,0,0,0,0,0,0,0,0,1,0 });
    assertEquals(false,p7a.equals(null));
  }

  /**
     test equals method (should return false when wrong type passed)
     @see Polynomial#equals
   */

  @Test public void testEqualsWrongType()
  {
    Polynomial p7a = new Polynomial (new int[] {-2,0,0,0,0,0,0,0,0,0,1,0 });
    assertEquals(false,p7a.equals("A string"));
  }

  /**
     test equals method (should return false when degrees don't match)
     @see Polynomial#equals
   */

  @Test public void testEqualsWrongDegree()
  {
    Polynomial p1 = new Polynomial(new int[] {1,1,1});
    Polynomial p2 = new Polynomial(new int[] {1,1});
    assertEquals(false,p1.equals(p2));
  }

  /**
     test plus on 0 + 1
     @see Polynomial#plus
   */

  @Test public void testp1plusp2()
  {
    Polynomial p1 = new Polynomial(new int[] {0});
    Polynomial p2 = new Polynomial(new int[] {1});
    assertEquals(new Polynomial( new int [] {1}),p1.plus(p2));
  }

  /**
     test plus on {@code (1) + (2x - 3) = 2x - 2} 
     @see Polynomial#plus
   */

  @Test public void testp2plusp3()
  {

    Polynomial p2 = new Polynomial(new int[] {1});
    Polynomial p3 = new Polynomial(new int[] {2,-3});
    assertEquals(new Polynomial( new int [] {2,-2}),p2.plus(p3));
  }

  /**
     test plus on {@code (2x - 3) + (x^2 - 5x + 6) = x^2 - 3x + 3 }
     @see Polynomial#plus
   */

  @Test public void testp3plusp4()
  {
    Polynomial p3 = new Polynomial(new int[]     {2,-3});
    Polynomial p4 = new Polynomial(new int[] {1, -5, 6});
    assertEquals(new Polynomial( new int [] {1,-3,3}),p3.plus(p4));
  }

  /**
     test plus on {@code (x^2 - 5x + 6) + (7x^4 - 8x^3 - 9x^2 - 10x - 11) = 7x^4 - 8x^3 - 8x^2 - 15x - 5 }
     @see Polynomial#plus
   */

  @Test public void testp4plusp5()
  {
    Polynomial p4 = new Polynomial(new int[]         {1, -5,    6});
    Polynomial p5 = new Polynomial(new int[] {7, -8, -9, -10, -11});
    assertEquals(new Polynomial( new int [] {7, -8, -8, -15, -5}),
                 p4.plus(p5));
  }

  /**
     test plus on {@code (7x^4 - 8x^3 - 9x^2 - 10x - 11) + (-x^7 - 2x^5 + 3x^3 - 4x) = -x^7 - 2x^5 + 7x^4 - 5x^3 - 9x^2 - 14x - 11 }
     @see Polynomial#plus
   */

  @Test public void testp5plusp6()
  {
    Polynomial p5 = new Polynomial(new int[] { 7, -8, -9, -10, -11});
    Polynomial p6 = new Polynomial(new int[]
                                   {-1, 0, -2,  0,  3,  0,  -4,   0});
    assertEquals(
      new Polynomial( new int []
                      {-1, 0, -2, 7, -5, -9, -14, -11}),
      p5.plus(p6));
  }

  /**
     test times on 
     @see Polynomial#times
   */

  @Test public void testp1timesp2()
  {
    Polynomial p1 = new Polynomial(new int[] {0});
    Polynomial p2 = new Polynomial(new int[] {1});
    assertEquals(new Polynomial( new int [] {0}),p1.times(p2));
  }

  /**
     test times
     @see Polynomial#times
   */

  @Test public void testp2timesp3()
  {
    Polynomial p2 = new Polynomial(new int[] {1});
    Polynomial p3 = new Polynomial(new int[] {2,-3});
    assertEquals(new Polynomial( new int [] {2,-3}),p2.times(p3));
  }

  /**
     test times
     @see Polynomial#times
   */

  @Test public void testp3timesp4()
  {
    Polynomial p3 = new Polynomial(new int[]     {2,-3});
    Polynomial p4 = new Polynomial(new int[] {1, -5, 6});
    assertEquals(new Polynomial( new int [] {2,-13,27,-18}),
                 p3.times(p4));
  }

  /**
     test times
     @see Polynomial#times
   */

  @Test public void testp4timesp5()
  {
    Polynomial p4 = new Polynomial(new int[]         {1, -5,    6});
    Polynomial p5 = new Polynomial(new int[] {7, -8, -9, -10, -11});
    assertEquals(new Polynomial(new int []
                                {7, -43, 73, -13, -15, -5, -66}),
                 p4.times(p5));
  }

  /**
     test times on {@code (7x^4 - 8x^3 - 9x^2 - 10x - 11) * (-x^7 - 2x^5 + 3x^3 - 4x) = -7x^11 + 8x^10 - 5x^9 + 26x^8 + 50x^7 - 4x^6 - 33x^5 + 2x^4 + 3x^3 + 40x^2 + 44x}
     @see Polynomial#times
   */

  @Test public void testp5timesp6()
  {
    Polynomial p5 = new Polynomial(new int[] { 7, -8, -9, -10, -11});
    Polynomial p6 = new Polynomial(new int[] {-1, 0, -2, 0, 3, 0, -4,0});
    assertEquals(new Polynomial(
                   new int []
                   {-7, 8,-5,26,50,-4,-33,2,3,40,44,0}),
                 p5.times(p6));
  }

  /**
     test minus
     @see Polynomial#minus
   */

  @Test public void testp1minusp2()
  {
    Polynomial p1 = new Polynomial(new int[] {0});
    Polynomial p2 = new Polynomial(new int[] {1});
    assertEquals(new Polynomial( new int [] {-1}),p1.minus(p2));
  }

  /**
     test minus
     @see Polynomial#minus
   */

  @Test public void testp2minusp3()
  {
    Polynomial p2 = new Polynomial(new int[]    {1});
    Polynomial p3 = new Polynomial(new int[] {2,-3});
    assertEquals(new Polynomial( new int [] {-2,4}),p2.minus(p3));
  }

  /**
     test minus
     @see Polynomial#minus
   */

  @Test public void testp3minusp4()
  {
    Polynomial p3 = new Polynomial(new int[]     {2,-3});
    Polynomial p4 = new Polynomial(new int[] {1, -5, 6});
    assertEquals(new Polynomial( new int [] {-1,7,-9}),p3.minus(p4));
  }

  /**
     test minus
     @see Polynomial#minus
   */

  @Test public void testp4minusp5()
  {
    Polynomial p4 = new Polynomial(new int[] {1, -5,    6});
    Polynomial p5 = new Polynomial(new int[] {7, -8, -9, -10, -11});
    assertEquals(new Polynomial( new int [] {-7, 8, 10, 5, 17}),
                 p4.minus(p5));
  }

  /**
     test minus
     @see Polynomial#minus
   */

  @Test public void testp5minusp6()
  {
    Polynomial p5 = new Polynomial(new int[] { 7, -8, -9, -10, -11});
    Polynomial p6 = new Polynomial(new int[] {-1, 0, -2, 0, 3, 0, -4, 0});
    assertEquals(new Polynomial( new int [] {1,0,2,7,-11,-9,-6,-11}),
                 p5.minus(p6));
  }

  /**
     test String constructor from Polynomial ("")
     @see Polynomial#Polynomial(String)
   */

  @Test(expected = IllegalArgumentException.class)
  public void test_ConstructorFromString_exception1()
  {
    // should throw IllegalArgumentException
    Polynomial p = new Polynomial("");
  }

  /**
     test String constructor from Polynomial ("9-")
     @see Polynomial#Polynomial(String)
   */
  @Test(expected = IllegalArgumentException.class)
  public void test_ConstructorFromString_exception2()
  {
    // should throw IllegalArgumentException
    Polynomial p = new Polynomial("9-");
  }

  /**
     test String constructor from Polynomial ("x9")
     @see Polynomial#Polynomial(String)
   */

  @Test(expected = IllegalArgumentException.class)
  public void test_ConstructorFromString_exception3()
  {
    // should throw IllegalArgumentException
    Polynomial p = new Polynomial("x9");
  }

  /**
     test String constructor from Polynomial ("0")
     @see Polynomial#Polynomial(String)
   */

  @Test
  public void test_ConstructorFromString_zero()
  {
    // should throw IllegalArgumentException
    Polynomial p = new Polynomial("0");
    assertEquals(0,p.getDegree());
    assertEquals(0,(int) p.get(0));
    assertEquals("0",p.toString());
  }

  /**
      test String constructor from Polynomial ("2")
      @see Polynomial#Polynomial(String)

    */
  @Test
  public void test_ConstructorFromString_two()
  {
    Polynomial p = new Polynomial("2");
    assertEquals(0,p.getDegree());
    assertEquals(2,(int) p.get(0));
    assertEquals("2",p.toString());
  }

  /**
     test String constructor from Polynomial("3x^3 + 4x^2 + 5x + 6")
     @see Polynomial#Polynomial(String)
   */

  @Test
  public void test_ConstructorFromString_3x3_p4x2_p5x_p6()
  {
    Polynomial expected = new Polynomial(new int [] {3,4,5,6});
    Polynomial actual = new Polynomial("3x^3 + 4x^2 + 5x + 6");
    assertEquals(expected,actual);
  }

  /**
      test String constructor from Polynomial("-3")
      @see Polynomial#Polynomial(String)
    */

  @Test
  public void test_ConstructorFromString_negThree()
  {
    Polynomial p = new Polynomial("-3");
    assertEquals(0,p.getDegree());
    assertEquals(-3,(int) p.get(0));
    assertEquals("-3",p.toString());
  }

  /**
      test String constructor from Polynomial ("x")
      @see Polynomial#Polynomial(String)
    */

  @Test
  public void test_ConstructorFromString_x()
  {
    Polynomial p = new Polynomial("x");
    assertEquals(1,p.getDegree());
    assertEquals(0,(int) p.get(0));
    assertEquals(1,(int) p.get(1));
    assertEquals("x",p.toString());
  }

  /**
      test String constructor from Polynomial ("-x")
      @see Polynomial#Polynomial(String)
    */
  @Test
  public void test_ConstructorFromString_negX()
  {
    Polynomial p = new Polynomial("-x");
    assertEquals(1,p.getDegree());
    assertEquals(0,(int) p.get(0));
    assertEquals(-1,(int) p.get(1));
    assertEquals("-x",p.toString());
  }

  /**
     test constructor {@code Polynomial(new int[] {2,-3});}
      @see Polynomial#Polynomial(String)
    */
  @Test
  public void test_ConstructorFromString_p3()
  {

    Polynomial p3 = new Polynomial(new int[] {2,-3});
    String p3s = p3.toString();
    Polynomial p3n = new Polynomial(p3s);
    assertEquals(p3n,p3);
  }

  /**
      test constructor {@code Polynomial(new int[] {1, -5, 6});}
      @see Polynomial#Polynomial(String)
    */

  @Test
  public void test_ConstructorFromString_p4()
  {
    Polynomial p4 = new Polynomial(new int[] {1, -5, 6});
    String p4s = p4.toString();
    Polynomial p4n = new Polynomial(p4s);
    assertEquals(p4n,p4);
  }

  /**
     test constructor {@code Polynomial(new int[] {7, -8, -9, -10, -11});}
     @see Polynomial#Polynomial(String)
   */
  @Test
  public void test_ConstructorFromString_p5()
  {
    Polynomial p5 = new Polynomial(new int[] {7, -8, -9, -10, -11});
    String p5s = p5.toString();
    Polynomial p5n = new Polynomial(p5s);
    assertEquals(p5n,p5);
  }

  /**
     test constructor {@code Polynomial(new int[] {-1, 0, -2, 0, 3, 0, -4, 0});}
     @see Polynomial#Polynomial(String)
  */
  @Test
  public void test_ConstructorFromString_p6()
  {
    Polynomial p6 = new Polynomial(new int[] {-1, 0, -2, 0, 3, 0, -4, 0});
    String p6s = p6.toString();
    Polynomial p6n = new Polynomial(p6s);
    assertEquals(p6n,p6);
  }

  /**
       test the degreeOfPolynomialCoeffsLowToHigh function on {@code new int [] {0, -11, -12, 0, 0, 0};}
       @see Polynomial#degreeOfPolynomialCoeffsLowToHigh
     */
  @Test
  public void test_degreeOfPolynomialCoeffsLowToHigh_2() {

    int [] coeffsLowToHigh = new int [] {0, -11, -12, 0, 0, 0};
    assertEquals(2,Polynomial.degreeOfPolynomialCoeffsLowToHigh(coeffsLowToHigh));
  }

  /**
     test the degreeOfPolynomialCoeffsLowToHigh function on {@code  new int [] {0, -11, 0, 0, 0, 0};}
     @see Polynomial#degreeOfPolynomialCoeffsLowToHigh
   */
  @Test
  public void test_degreeOfPolynomialCoeffsLowToHigh_1() {

    int [] coeffsLowToHigh = new int [] {0, -11, 0, 0, 0, 0};
    assertEquals(1,Polynomial.degreeOfPolynomialCoeffsLowToHigh(coeffsLowToHigh));
  }

  /**
     test the degreeOfPolynomialCoeffsLowToHigh function on {@code new int [] {-10, 0, 0, 0, 0, 0};}
     @see Polynomial#degreeOfPolynomialCoeffsLowToHigh
   */
  @Test
  public void test_degreeOfPolynomialCoeffsLowToHigh_0a() {

    int [] coeffsLowToHigh = new int [] {-10, 0, 0, 0, 0, 0};
    assertEquals(0,Polynomial.degreeOfPolynomialCoeffsLowToHigh(coeffsLowToHigh));
  }

  /**
     test the degreeOfPolynomialCoeffsLowToHigh function on {@code new int [] {0};}
     @see Polynomial#degreeOfPolynomialCoeffsLowToHigh
   */
  @Test
  public void test_degreeOfPolynomialCoeffsLowToHigh_0c() {

    int [] coeffsLowToHigh = new int [] {0};
    assertEquals(0,Polynomial.degreeOfPolynomialCoeffsLowToHigh(coeffsLowToHigh));
  }

  /**
     test the degreeOfPolynomialCoeffsHighToLow function on {@code new int [] {0, 0, 0, -10, -11, 0};}
     @see Polynomial#degreeOfPolynomialCoeffsHighToLow
   */
  @Test
  public void test_degreeOfPolynomialCoeffsHighToLow_2() {

    int [] coeffsHighToLow = new int [] {0, 0, 0, -10, -11, 0};
    assertEquals(2,Polynomial.degreeOfPolynomialCoeffsHighToLow(coeffsHighToLow));
  }

  /**
     test the degreeOfPolynomialCoeffsHighToLow function on {@code new int [] {0, 0, 0, -10, 0};}
     @see Polynomial#degreeOfPolynomialCoeffsHighToLow
   */
  @Test
  public void test_degreeOfPolynomialCoeffsHighToLow_1() {

    int [] coeffsHighToLow = new int [] {0, 0, 0, -10, 0};
    assertEquals(1,Polynomial.degreeOfPolynomialCoeffsHighToLow(coeffsHighToLow));
  }

  /**
     test the degreeOfPolynomialCoeffsHighToLow function on {@code new int [] {0, 0, 0, 10};}
     @see Polynomial#degreeOfPolynomialCoeffsHighToLow
   */
  @Test
  public void test_degreeOfPolynomialCoeffsHighToLow_0a() {

    int [] coeffsHighToLow = new int [] {0, 0, 0, 10};
    assertEquals(0,Polynomial.degreeOfPolynomialCoeffsHighToLow(coeffsHighToLow));
  }

  /**
     test the degreeOfPolynomialCoeffsHighToLow function on all zeros
     @see Polynomial#degreeOfPolynomialCoeffsHighToLow
   */
  @Test
  public void test_degreeOfPolynomialCoeffsHighToLow_0b() {

    int [] coeffsHighToLow = new int [] {0, 0, 0};
    assertEquals(0,Polynomial.degreeOfPolynomialCoeffsHighToLow(coeffsHighToLow));
  }

  /**
     test the degreeOfPolynomialCoeffsHighToLow function on single zero
     @see Polynomial#degreeOfPolynomialCoeffsHighToLow
   */
  @Test
  public void test_degreeOfPolynomialCoeffsHighToLow_0c() {

    int [] coeffsHighToLow = new int [] {0};
    assertEquals(0,Polynomial.degreeOfPolynomialCoeffsHighToLow(coeffsHighToLow));
  }

  /**
     test the lowToHigh function that converts a highToLow int array of
     coefficients into a lowToHigh int array of coefficients on a single zero
     @see Polynomial#lowToHigh
   */
  @Test
  public void test_lowToHigh_single_zero() {

    int [] coeffsHighToLow = new int [] {0};
    int [] actual = Polynomial.lowToHigh(coeffsHighToLow);
    int [] expected = new int [] {0};
    assertArrayEquals(expected, actual);
  }

  /**
     test the lowToHigh function that converts a highToLow int array of
     coefficients into a lowToHigh int array of coefficients.
     Polynomial is <code>0</code> (constant), with extra zeros in
     input.
     @see Polynomial#lowToHigh
   */
  @Test
  public void test_lowToHigh_multiple_zeros() {

    int [] coeffsHighToLow = new int [] {0, 0, 0};
    int [] actual = Polynomial.lowToHigh(coeffsHighToLow);
    int [] expected = new int [] {0};
    assertArrayEquals(expected, actual);
  }

  /**
     test the lowToHigh function that converts a highToLow int array of
     coefficients into a lowToHigh int array of coefficients.
     Polynomial is <code>1</code> (constant) with leading zeros
     @see Polynomial#lowToHigh
   */
  @Test
  public void test_lowToHigh_one_with_leading_zeros() {

    int [] coeffsHighToLow = new int [] {0, 0, 1};
    int [] actual = Polynomial.lowToHigh(coeffsHighToLow);
    int [] expected = new int [] {1};
    assertArrayEquals(expected, actual);
  }

  /**
     test the lowToHigh function that converts a highToLow int array of
     coefficients into a lowToHigh int array of coefficients,
     using polynomial <code>-10x</code>
     @see Polynomial#lowToHigh
   */
  @Test
  public void test_lowToHigh_neg10x() {
    // Polynomial is -10x
    int [] coeffsHighToLow = new int [] {0, 0, -10, 0};
    int [] actual = Polynomial.lowToHigh(coeffsHighToLow);
    int [] expected = new int [] {0, -10};
    assertArrayEquals(expected, actual);
  }

  /**
     test the lowToHigh function that converts a highToLow int array of
     coefficients into a lowToHigh int array of coefficients,
     using the polynomial <code>-10x - 20</code>.
     @see Polynomial#lowToHigh
   */
  @Test
  public void test_lowToHigh_neg10x_minus_20() {
    // polynomial: -10x - 20
    int [] coeffsHighToLow = new int [] {0, 0, -10, -20};
    int [] actual = Polynomial.lowToHigh(coeffsHighToLow);
    int [] expected = new int [] {-20, -10};
    assertArrayEquals(expected, actual);
  }

  /**
     test the lowToHigh function that converts a highToLow int array of
     coefficients into a lowToHigh int array of coefficients,
     using the polynomial <code> -10x^4 - 20x^3 -40</code>
     @see Polynomial#lowToHigh
   */
  @Test
  public void test_lowToHigh_neg10x4_minus20x3_minus40() {
    // polynomial: -10x^4 - 20x^3 -40x
    int [] coeffsHighToLow = new int [] {0, -10, -20, 0, -40, 0};
    int [] actual = Polynomial.lowToHigh(coeffsHighToLow);
    int [] expected = new int [] {0, -40, 0, -20, -10};
    assertArrayEquals(expected, actual);
  }

  /**
     test the highToLow function that converts a lowToHigh int array of
     coefficients into a highToLow int array of coefficients, on 0
     @see Polynomial#highToLow
   */
  @Test
  public void test_highToLow_0() {

    int [] coeffsLowToHigh = new int [] {0};
    int [] actual = Polynomial.highToLow(coeffsLowToHigh);
    int [] expected = new int [] {0};
    assertArrayEquals(expected, actual);
  }

  /**
     test the highToLow function that converts a lowtoHigh int array of
     coefficients into a highToLow int array of coefficients.
     Polynomial is <code>0</code> (constant), with extra zeros in
     input.
     @see Polynomial#highToLow
   */
  @Test
  public void test_highToLow_0_with_extra_zeros() {

    int [] coeffsLowToHigh = new int [] {0, 0, 0};
    int [] actual = Polynomial.highToLow(coeffsLowToHigh);
    int [] expected = new int [] {0};
    assertArrayEquals(expected, actual);
  }

  /**
     test the highToLow function that converts a lowToHigh int array of
     coefficients into a highToLow int array of coefficients.
     Polynomial is <code>1</code> (constant) with extra zeros
     @see Polynomial#highToLow
   */
  @Test
  public void test_highToLow_1_with_extra_zeros() {

    int [] coeffsLowToHigh = new int [] {1, 0, 0};
    int [] actual = Polynomial.highToLow(coeffsLowToHigh);
    int [] expected = new int [] {1};
    assertArrayEquals(expected, actual);
  }

  /**
     test the highToLow function that converts a lowToHigh int array of
     coefficients into a highToLow int array of coefficients,
     using coefficients for the Polynomial <code>-10x</code>.

     @see Polynomial#highToLow
   */
  @Test
  public void test_highToLow_neg10x() {
    // Polynomial is -10x
    int [] coeffsLowToHigh = new int [] {0, -10, 0, 0};
    int [] actual = Polynomial.highToLow(coeffsLowToHigh);
    int [] expected = new int [] {-10, 0};
    assertArrayEquals(expected, actual);
  }

  /**
     test the highToLow function that converts a lowToHigh int array of
     coefficients into a highToLow int array of coefficients,
     using the polynomial <code>-10x - 20</code>.
     @see Polynomial#highToLow
   */
  @Test
  public void test_highToLow_neg10x_minus20() {
    // polynomial is -10x - 20
    int [] coeffsLowToHigh = new int [] {-20, -10, 0, 0};
    int [] actual = Polynomial.highToLow(coeffsLowToHigh);
    int [] expected = new int [] {-10, -20};
    assertArrayEquals(expected, actual);
  }

  /**
     test the highToLow function that converts a highToLow int array of
     coefficients into a highToLow int array of coefficients,
     using the polynomial <code> -10x^4 - 20x^3 -40</code>
     @see Polynomial#highToLow
   */
  @Test
  public void test_highToLow_neg10x4_minus20x3_minus40() {
    // polynomial: -10x^4 - 20x^3 -40
    int [] coeffsLowToHigh = new int [] {0, -40, 0, -20, -10, 0};
    int [] actual = Polynomial.highToLow(coeffsLowToHigh);
    int [] expected = new int [] {-10, -20, 0, -40, 0};
    assertArrayEquals(expected, actual);
  }

} // class PolynomialTest


