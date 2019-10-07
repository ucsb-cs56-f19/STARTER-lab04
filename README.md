# STARTER-lab04 for UCSB CS56 F19

Starter code for https://ucsb-cs56.github.io/f19/lab/lab04

Commands:

| To do this           | type this     |
|----------------------|---------------|
| compile regular code | `mvn compile` |
| compile the test classes | `mvn test-compile` |
| run tests            | `mvn test`    |
| build executable jar | `mvn package`  |
| run the jar          | `java -jar target/polynomial-1.0.jar` |
| generate javadoc     | `mvn javadoc:javadoc` |
| generate javadoc for test code   | `mvn javadoc:test-javadoc` |
| check test coverage  | `mvn test jacoco:report` |

* Javadoc will be here: https://GITHUB-ORG-NAME.github.io/REPO-NAME/apidocs/
* For example: https://ucsb-cs56-f19.github.io/lab04-pconrad/apidocs/
* Test Coverage will be in `target/site/jacoco/index.html`
  * Note that test coverage will not run if there are any test failures

# Hints

* Start by commenting out the toString method temporarily.
   * That will cause the class to use the ArrayList<Integer> `toString` method
     instead.  That way, while you work on other methods, you'll be able to
     see the ground truth of what's inside the Arrays.
   * Come back and uncomment it when you are ready to work on it.
* You might want to do this so that you can focus on one method at a time:
   * `cd src/test/java/edu/ucsb/cs56/polynomial`
   * `cp PolynomialTest.java PolynomialTest.java.keep`
   * Then, delete the code inside `PolynomialTest.java` for all tests except the method you are working on.
   * Copy/paste the tests back into the file one at a time, and try to get one test at a time to pass.
   * Run the entire test suite each time, to make sure that when you get one test to pass, you don't break something else.
* I suggest you focus on these methods first, since they don't depend on anything else, and they are useful when
  getting other things to work:

  * `public static int [] lowToHigh(int [] coeffsHighToLow)`
  * `public static int [] highToLow(int [] coeffsLowToHigh)` 
  * `public static int indexFirstNonZeroCoeffsLowToHigh(int [] coeffsLowToHigh)`
  * `public static int indexFirstNonZeroCoeffsHighToLow(int [] coeffsHighToLow)`

* Then, tackle these as a group.  There is a bit of a chicken and egg problem here, because
  the `equals` method is used by JUnit, and until it is correct, the JUnit test results
  may be misleading!  But you can't test `equals` unless you have a way to construct
  `Polynomial` objects.  You'll have to think about how to handle that.
  
  * `public boolean equals(Object o)`
  * `public Polynomial(int [] coeffsHighToLow)`
  * `public int getDegree()`

* Next, before tackling the plus, times, and minus, get `toString` working.
  Bugs in `toString` can be maddening because the JUnit output uses toString.
  You'll be looking at test case output, and it won't represent what's really
  going on.  So get this working and solid before moving on.

* Finally, I suggest doing `plus`, `times` and `minus`, in that order.
  There is a reason for doing it that way; it will save you work if you are
  clever.

* When you are all done, you can submit on Gradescope.  Note that there may be
  extra tests on Gradescope for cases that you didn't consider.




