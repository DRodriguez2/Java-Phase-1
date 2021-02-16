import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LISBrute {
	
	//private  final static Logger Logger = LogManager.getLogger(LISBrute.class);
	
	
	/**
	 * Simple brute force algorithm for finding the longest increasing sequence in an array list.
	 * @param _numbers
	 */
	public void findLIS(ArrayList<Integer> _numbers) {
		int max;
		ArrayList<Integer> list;
		ArrayList<Integer> list2 = new ArrayList<>();

		for(int i = 0; i < _numbers.size(); i++) {
			list  = new ArrayList<>();
			list.add(_numbers.get(i));
			max = _numbers.get(i);

			for(int j = i+1; j < _numbers.size(); j++) {
				if(max < _numbers.get(j)) {
					max = _numbers.get(j);
					list.add(_numbers.get(j));
				}	
			}
			if(list.size() > list2.size()) {
				list2 = list;
			}
		}
		System.out.println("Longest Increasing Subsequence: " + list2.toString());
	}
}
