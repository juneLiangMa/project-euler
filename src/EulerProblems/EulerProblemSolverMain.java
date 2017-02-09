package EulerProblems;
import sun.management.counter.Variability;

/**
 * Main method class that initializes a problem,
 * executes it, reports its runtime and operations step
 * counter, and prints the result.
 * @author junel
 * @version 1.0
 * @since 2017/02/06
 */

public class EulerProblemSolverMain {

	public static void main(String[] args) {
		EulerProblem problem = new ProblemOne(1000, 3, 5);
		int result = problem.solve();
		
		System.out.println(String.format("Problem %s returned a result value of %s.",
				problem.getName(), result));
		System.out.println(String.format("Problem executed %s steps and ran for %s time.",
				problem.getLastExecutionSteps(), problem.getLastExecutionRuntime()));
	}

}
