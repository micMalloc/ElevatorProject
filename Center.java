package ATP;

import java.math.BigInteger;
import java.util.*;

public class Center {

	public static Floor[] floor = new Floor[11];
	public static Elevator[] elevator = new Elevator[6];
	HashMap<Integer, ArrayList<Integer>> path = new HashMap<Integer, ArrayList<Integer>>();
	public int target;

	public Center(int target, int dest) {
		path = Routing(target, dest);
	}

	public HashMap<Integer, ArrayList<Integer>> getPath() {
		return path;
	}

	public static HashMap Routing(int target, int dest) {

		int min = 0, src, startSec;
		HashMap<Integer, ArrayList<Integer>> path = new HashMap<Integer, ArrayList<Integer>>();

		/* Second Step : Routing! */
		System.out.println("Ÿ�� ��");
		System.out.println("Ÿ�� �� " + target);
		src = elevator[target].currentFloor;
		System.out.println(src + " " + dest + "üũ");

		return (makePath(target, dest));
	}

	public static int targeting(client NEW) {
		int d, target = 0, min = 99999;
		/* Select a Elevator to be used */
		for (int i = 1; i <= 5; ++i) {
			if (elevator[i].getInclient(NEW)) {
				// floor[NEW.want].input ++; �α� ��ǥ ���⼭ �ϴ°� �ƴϴ�
				d = Math.abs(NEW.current - elevator[i].currentFloor);
				if (min > d) {
					min = d;
					target = i;
				}
			}
		}
		System.out.println(target + "Ÿ����");
		return target;
	}

	public static int findLongSeq(int source, int dest, int sec) {
		int max = 0, count, current, startSec = 0;

		int i = sec;
		System.out.println("find " + source + " " + dest);
		if (source != dest) {
			do {
				count = 0;
				current = source;
				if (current < dest) {
					while (floor[current + 1].section[i] != 1 && current < dest) {
						count++;
						current++;System.out.println(current + "����");
					}System.out.println("�� ����");
				} else {
					while (floor[current - 1].section[i] != 1 && current > dest && current >= 2) {
						count++;
						current--;
					}
				}
				if (max < count) {
					max = count;
					startSec = i;
				}
				i = (i + 1) % 8;
				System.out.println(i + " �ʹ��ݳʹ���");
			} while (i != sec);
		} else {
			startSec = sec;
		}
		return startSec;
	}

	public static ArrayList<Integer> moveSection(int current, int sec, int startSec, ArrayList<Integer> tmp) {

		if (Math.abs(sec - startSec) > 4) {
			if (sec > startSec) {
				while (sec != startSec) {
					tmp.add(sec);
					floor[current].section[sec] = 1;
					sec = (sec + 1) % 8;
				}
			} else {
				while (sec != startSec) {
					tmp.add(sec);
					floor[current].section[sec] = 1;
					sec--;
					if (sec < 0)
						sec = 7;
				}
			}
		} else {
			if (sec > startSec) {
				while (sec != startSec) {
					tmp.add(sec);
					floor[current].section[sec] = 1;
					sec--;
					if (sec < 0)
						sec = 7;
				}
			} else {
				while (sec != startSec) {
					tmp.add(sec);
					floor[current].section[sec] = 1;
					sec = (sec + 1) % 8;
				}
			}
		}
		tmp.add(sec);
		floor[current].section[sec] = 1;

		return tmp;
	}

	public static ArrayList<Integer> setEntrance(int current, int sec, ArrayList<Integer> tmp) {
		int min = 999, entrance = 0;

		for (int i = 1; i <= 7; i += 2) {
			if (floor[current].section[i] == 0) {
				if (Math.abs(i - sec) < min) {
					entrance = i;
				}
			}
		}
		tmp = moveSection(current, sec, entrance, tmp);
		return tmp;
	}

	public static HashMap makePath(int target, int dest) {
		HashMap<Integer, ArrayList<Integer>> path = new HashMap<Integer, ArrayList<Integer>>();
		int current = elevator[target].currentFloor;
		int sec = elevator[target].currentSec;
		int startSec = findLongSeq(current, dest, sec);
		System.out.println(current + " " + sec + " " + startSec);

		while (current != dest) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			if (floor[current + 1].section[startSec] != 1) {
				if (startSec != sec) {
					tmp = moveSection(current, sec, startSec, tmp);
					sec = startSec;
				} else {
					tmp.add(startSec);
					floor[current].section[startSec] = 1;
				}
				path.put(current, tmp);
				if (current < dest)
					current++;
				else
					current--;
			} else {
				startSec = findLongSeq(current + 1, dest, startSec);
			}
		}
		if (sec % 2 != 1) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			tmp = setEntrance(current, sec, tmp);
			path.put(current, tmp);
		} else {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			tmp.add(sec);
			floor[current].section[sec] = 1;
			path.put(current, tmp);
		}
		return path;
	}
}