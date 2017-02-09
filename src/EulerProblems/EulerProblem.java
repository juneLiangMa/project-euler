package EulerProblems;

import java.util.concurrent.TimeUnit;

/**
 * The IEulerProblem interface defines the basic
 * skeleton for all euler problem solutions.
 * 
 * @author junel
 * @version 1.0
 * @since 2017/02/06
 */
public interface EulerProblem {
	String getName();
	int getLastExecutionSteps();
	String getLastExecutionRuntime();
	int solve();	
}

