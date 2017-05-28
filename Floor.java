package ATP;

import java.util.Comparator;

public class Floor implements Comparator<Floor> {
	
	public int info;
	public int input;
	public int[] section = new int[8];
	
	public Floor (int in) {
		
		input = 0;
		/* Only Odd Index Section can have door */ 
		for (int i = 0; i < 8; ++ i)
			section[i] = 0;
	}

	@Override
	public int compare(Floor e1, Floor e2) {
		// TODO Auto-generated method stub
		
		if (e1.input > e2.input)
			return 1;
		else
			return -1;
	}
}
