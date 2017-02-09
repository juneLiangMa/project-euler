package EulerProblems;

import org.junit.experimental.max.MaxCore;

public class ProblemTwo extends ProblemBase {
	private long _max;
	
	public ProblemTwo(long max) {
		_max = max;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Problem 2 - Even Fibb Numbers";
	}

	/**
	 * Naive solution - we know every 3rd fibb after
	 * 2 is even, so just go up the list from 2 to max,
	 * and sum up the evens
	 */
	@Override
	public int solve() {
		if(_max < 2)
			return 0;
		
		_lastExecutionSteps = 0;
		long startTime = System.currentTimeMillis();

		
		int total = 2; // start with 2 as the first even #
		_lastExecutionSteps++;
		
		int prevFibb = 1;
		_lastExecutionSteps++;
		
		int curFibb = 2;
		_lastExecutionSteps++;
		
		int moduloIndex = 1;
		_lastExecutionSteps++;
		
		while(curFibb < _max) {
			_lastExecutionSteps++;
			
			int temp = curFibb + prevFibb;
			_lastExecutionSteps++;
			
			prevFibb = curFibb;
			_lastExecutionSteps++;
			
			curFibb = temp;
			_lastExecutionSteps++;
			
			_lastExecutionSteps++;
			if(moduloIndex % 3 == 0) {
				moduloIndex = 1;
				_lastExecutionSteps++;
				total += curFibb;
				_lastExecutionSteps++;
			} else {
				moduloIndex++;
				_lastExecutionSteps++;
			}
		}
		
		long endTime = System.currentTimeMillis();
		
		setLastExecutionRuntime(endTime - startTime);
		return total;
	}

}
