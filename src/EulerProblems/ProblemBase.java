package EulerProblems;

import java.util.concurrent.TimeUnit;

/**
 * ProblemBase defines some common methods that report information
 * about all problem solutions for project euler
 * @author junel
 * @version 1.0
 * @since 2017/02/08
 */
public abstract class ProblemBase implements EulerProblem {
	protected int _lastExecutionSteps;
	protected String _lastExecutionRuntime;

	/**
	 * Gets the estimated number of execution steps from the problem
	 * @return integer number of steps
	 */
	public int getLastExecutionSteps() {
		return _lastExecutionSteps;
	}
	
	/**
	 * Gets the estimated runtime of the last solve of the problem
	 * @return execution runtime as a formatted string
	 */
	public String getLastExecutionRuntime() {
		return _lastExecutionRuntime;
	}
	
	/**
	 * Protected method that sets the runtime string
	 * @param millis long value of milliseconds of execution
	 */
	protected void setLastExecutionRuntime(long millis) {
		long min = TimeUnit.MILLISECONDS.toMinutes(millis);
		long sec = TimeUnit.MILLISECONDS.toSeconds(millis) - 
			    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis));
		
		long ms = millis - TimeUnit.MINUTES.toMillis(min) - TimeUnit.SECONDS.toMillis(sec);
		
		_lastExecutionRuntime = String.format("%02d min, %02d sec, %02d ms", 
			    min, sec, ms);
	}

	@Override
	public abstract String getName();

	@Override
	public abstract int solve();
		
}
