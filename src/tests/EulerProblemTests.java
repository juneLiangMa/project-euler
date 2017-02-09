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
	/**
	 * SECTION - problem 1
	 */
	@Test
	public void problemOneShouldSolveSmallProblemCorrectly() {
		EulerProblem p1 = new ProblemOne(10, 3, 5);
		assertEquals(23, p1.solve());
		assertTrue(p1.getLastExecutionSteps() > 0);
		assertTrue(p1.getLastExecutionRuntime().length() > 0);
	}
	
	@Test
	public void problemOneShouldSolveProblemWithCommonFactors() {
		EulerProblem p1 = new ProblemOne(16, 3, 5);
		assertEquals(60, p1.solve());
	}
	
	@Test
	public void ProblemOneShouldSolveProblemWithSameValues() {
		EulerProblem p1 = new ProblemOne(10, 2, 2);
		
		assertEquals(20, p1.solve());
	}

	/**
	 * SECTION - problem 2 tests
	 */
	@Test
	public void ProblemTwoShouldSolveSmallProblem() {
		EulerProblem p2 = new ProblemTwo(10);
		assertEquals(10, p2.solve());
	}
	
	@Test
	public void ProblemTwoShouldSolveInvalidProblem() {
		EulerProblem p2 = new ProblemTwo(0);
		assertEquals(0, p2.solve());
		
		p2 = new ProblemTwo(-3);
		assertEquals(0, p2.solve());
	}
	
	@Test
	public void ProblemTwoShouldSolveIntermediateProblem() {
		EulerProblem p2 = new ProblemTwo(150);
		assertEquals(188, p2.solve());
	}
}
