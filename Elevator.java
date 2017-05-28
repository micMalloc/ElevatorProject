package ATP;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Elevator {
	/* Maximum capacity of client to accept */
	public static final int maximum = 1000;
	/* Current Location */
	public int currentFloor;
	public int currentSec;
	/* 1 : moving 0 : Stop and Wait for Input */
	public boolean isBusy;
	/* If this can accept new client or not */
	public double currentW;
	/* Direction if UP or DOWN : Up 1 Stop 0 Down -1 */
	public int direction;
	public ArrayList<client> clientList = new ArrayList<client>();
	//public ArrayList<Integer> destList = new ArrayList<Integer>();
	public PriorityQueue<Integer> destList = new PriorityQueue<Integer>();
	
	public Elevator(int i) {
		currentFloor = 1;
		isBusy = false;
		currentW = 0;
		direction = 0;
		if (i > 0) {
			currentSec = i + (i - 1);
		} else {
			currentSec = i;
		}
		System.out.println("¿¤º£»ý¼º " + currentFloor + " " + currentSec);
	}
	
	public boolean getInclient (client newclient) {
		
		if (currentW + newclient.weight >= maximum)
			return false;
		if (newclient.direction != this.direction && this.direction != 0)
			return false;
		
		currentW += newclient.weight;
		if (clientList.isEmpty()) {
			this.direction = newclient.direction;
		}
		clientList.add(newclient);
		destList.add(newclient.want);
		
		return true;
	}
	
	public void getOutclient (int current) {
		
		for (client p : clientList) {
			if (p.want == current) {
				currentW -= p.weight;
				clientList.remove(clientList.indexOf(p));
			}
		}
	}
	
}
