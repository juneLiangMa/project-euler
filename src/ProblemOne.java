import java.util.ArrayList;

public class ProblemOne implements IEulerProblem {
	private int _limit;
	private ArrayList<Integer> _factorsList;
	
	/// Problem description:
	///Find the sum of all the multiples of 3 or 5 below 1000.
	public ProblemOne() {
		_factorsList = new ArrayList<Integer>();
	}
	
	public ProblemOne(int limit, int[] factors) {
		this();
		_limit = limit;
		for (int f : factors) {
			_factorsList.add(f);
		}
	}
	
	public int Solve() {
		if(_factorsList.isEmpty()) {
			throw new IllegalStateException("No factors provided to solve the problem with.");
		}
		
		int result = -1;
		
		
		return result;
	}
	
	
}
