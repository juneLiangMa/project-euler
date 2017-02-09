package EulerProblems;
import com.sun.java_cup.internal.runtime.Scanner;
import com.sun.org.apache.xml.internal.serializer.utils.SystemIDResolver;

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

	public enum CommandTypes {
		HELP,
		LOAD,
		LIST,
		INFO,
		UNKNOWN
	}
	
	public static void main(String[] args) {
		EulerProblem problem = new ProblemTwo(4000000);
			int result = problem.solve();
		
		System.out.println(String.format("Problem %s returned a result value of %s.",
				problem.getName(), result));
		System.out.println(String.format("Problem executed %s steps and ran for %s time.",
				problem.getLastExecutionSteps(), problem.getLastExecutionRuntime()));
	}

	private static void checkAndRunSolutionIfExists(String inputLine) {
		// TODO Auto-generated method stub
	}

	private static CommandTypes getCommandType(String inputLine) {
		CommandTypes result = CommandTypes.UNKNOWN;
		
		return result;
	}

	private static boolean isNotExitCommand(String inputLine) {
		return inputLine.toLowerCase().contains("exit") ||
				inputLine.toLowerCase().contains("quit");
	}

	private static void printPreamble() {
		System.out.println("Welcome to June's Euler problem solver.");
		System.out.println("Type 'help' to see a list of commands,");
		System.out.println("or type a number to run the solution for problem n from");
		System.out.println("the Euler Problems list, if the solution exists.");
	}

}
