package EulerProblems;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.*;

import javafx.beans.property.ReadOnlyBooleanProperty;

import java.math.*;

/**
 * Problem description:
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * General case: given a max value n, find the sum of all the multiples
 * of x, y below n.
 * @author junel
 * @version 1.0
 * @since 2017/02/06
 */
public class ProblemOne implements EulerProblem {
	private int _limit;
	private ArrayList<Integer> _factorsList;
	private int _lastExecutionSteps;
	private String _lastExecutionRuntime;
	
	public String getName() {
		return "Problem One - factor sums";
	}
	
	public int getLastExecutionSteps() {
		return _lastExecutionSteps;
	}
	
	public String getLastExecutionRuntime() {
		return _lastExecutionRuntime;
	}
	
	private void setLastExecutionRuntime(long millis) {
		long min = TimeUnit.MILLISECONDS.toMinutes(millis);
		long sec = TimeUnit.MILLISECONDS.toSeconds(millis) - 
			    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis));
		
		long ms = millis - TimeUnit.MINUTES.toMillis(min) - TimeUnit.SECONDS.toMillis(sec);
		
		_lastExecutionRuntime = String.format("%02d min, %02d sec, %02d ms", 
			    min, sec, ms);
	}
	
	/**
	 * Empty constructor
	 */
	public ProblemOne() {
		_lastExecutionRuntime = "";
		_lastExecutionSteps = -1;
		_factorsList = new ArrayList<Integer>();
	}
	
	/**
	 * Constructor which initializes the max limit
	 * and the single-digit factors to be used
	 * @param limit
	 * @param factors
	 */
	public ProblemOne(int limit, int[] factors) {
		this();
		_limit = limit;
		for (int f : factors) {
			if(0 < f && f < 10)
				_factorsList.add(f);
		}
	}
	
	/**
	 * Solution implementation:
	 * Returns the integer sum of all the factors below
	 * the limit value.
	 */
	public int solve() {
		_lastExecutionSteps = 0;

		 long startTime = System.currentTimeMillis();
		
		int result = 0;
		_lastExecutionSteps++;
		for(int factor : _factorsList) {
			// get the max number of times the factor goes in to the max
			int maxCount = (_limit - 1) / factor;
			_lastExecutionSteps++;

			int multiplier = rangeSumInclusive(1, maxCount);
			result += (multiplier * factor);
			_lastExecutionSteps++;
		}
		
		 long endTime = System.currentTimeMillis();
		 setLastExecutionRuntime(endTime - startTime);
		return result;
	}
	
	/**
	 * Performs the sequential range sum from a min int to a max
	 * and returns the sum.
	 * @param min The min value to start from
	 * @param max The max value to end at
	 * @return The total sum of all integers from min to max.
	 */
	private int rangeSumInclusive(int min, int max) {
		int result = 0;
		_lastExecutionSteps++;

		int increment = min + max;
		_lastExecutionSteps++;

		// because the method is an inclusive sum,
		// we should add 1 to account for that last value.
		int numberOfElements = max - min + 1;
		_lastExecutionSteps++;

		result += increment * (numberOfElements / 2);
		_lastExecutionSteps++;

		if(numberOfElements % 2 == 1) {
			// case: even # of ints to add
			result += min + (numberOfElements / 2);
			_lastExecutionSteps++;
		}
		_lastExecutionSteps++;
		
		return result;
	}
}
