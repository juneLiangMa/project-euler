package tests;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Euler problem unit tests for validating and debugging
 * correctness of the problem solutions.
 * 
 * The goal should be to verify the correctness of a problem
 * solution entirely in unit tests, so that I only submit 
 * an answer to the project euler site *once*.
 * @author junel
 * @version 1.0
 * @since 2017/02/06
 */
public class EulerProblemTests {
	
	@Test
	public void ProblemOneShouldInitialize() {
		IEulerProblem p1 = new ProblemOne();
	}
}
