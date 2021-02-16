import java.util.ArrayList;
import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		LISBrute test2 = new LISBrute();
		
		int n = 100; 

		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			list.add(new Random().nextInt(1000));
		}
		
		System.out.println(list.toString());
		test2.findLIS(list);
	}

}
