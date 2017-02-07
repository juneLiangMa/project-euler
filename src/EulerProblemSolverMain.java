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
		IEulerProblem problem = new ProblemOne(1000, new int[] {3, 5});
		int result = problem.Solve();
		
		System.out.println(String.format("Problem %s returned a result value of %s.",
				problem.GetName(), result));
		System.out.println(String.format("Problem executed %s steps and ran for %s time.",
				problem.GetLastExecutionSteps(), problem.GetLastExecutionRuntime()));
	}

}
