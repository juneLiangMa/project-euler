package tests;
import static org.junit.Assert.*;
import org.junit.Test;
import EulerProblems.*;

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
	public void problemOneShouldInitialize() {
		EulerProblem p1 = new ProblemOne();
		
		assertEquals(0, p1.solve());
	}
	
	@Test
	public void problemOneShouldSolveSmallProblemCorrectly() {
		EulerProblem p1 = new ProblemOne(10, new int[] {3, 5});
		assertEquals(23, p1.solve());
		assertTrue(p1.getLastExecutionSteps() > 0);
		assertTrue(p1.getLastExecutionRuntime().length() > 0);
	}
	
	@Test
	public void problemOneShouldSolveProblemWithCommonFactors() {
		EulerProblem p1 = new ProblemOne(16, new int[] {3,5});
		assertEquals(60, p1.solve());
	}
}
