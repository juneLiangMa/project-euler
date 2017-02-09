package EulerProblems;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.*;

import javafx.beans.property.ReadOnlyBooleanProperty;
import sun.management.counter.Variability;

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
	private int _lastExecutionSteps;
	private int _preambleSteps;
	private String _lastExecutionRuntime;
	private int _factorSmaller;
	private int _factorLarger;
	
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
	 * Constructor which initializes the max limit, exclusive
	 * and the single-digit factors to be used
	 * @param limitExclusive
	 * @param factors
	 */
	public ProblemOne(int limitExclusive, int factor1, int factor2) {
		_preambleSteps = 0;
		
		_limit = limitExclusive - 1;
		_preambleSteps++;

		_factorSmaller = factor1;
		_preambleSteps++;
		
		_factorLarger = factor2;
		_preambleSteps++;

		_preambleSteps += 2;
		if((_limit / factor2) < (_limit / factor1)) {
			_factorLarger = factor1;
			_preambleSteps++;
			_factorSmaller = factor2;
			_preambleSteps++;
		}
	}
	
	/**
	 * Solution implementation:
	 * Returns the integer sum of all the factors below
	 * the limit value.
	 */
	public int solve() {
		_lastExecutionSteps = _preambleSteps;

		 long startTime = System.currentTimeMillis();
		
		int result = 0;
		_lastExecutionSteps++;
			
		// get the max number of times the factor goes in to the max
		int maxCount = _limit / _factorLarger;
		_lastExecutionSteps++;

		int multiplier = rangeSumInclusive(1, maxCount);
		_lastExecutionSteps++;

		result += (multiplier * _factorLarger);
		_lastExecutionSteps += 2;
		
		maxCount = _limit / _factorSmaller;
		_lastExecutionSteps++;

		for(int i = 1; i <= maxCount; i++) {
			_lastExecutionSteps++;

			int tempValue = i * _factorSmaller;
			_lastExecutionSteps++;

			_lastExecutionSteps++;
			if(tempValue % _factorLarger != 0) {
				result += tempValue;
				_lastExecutionSteps++;
			}
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
