package programming;

import java.util.List;

public class FP01Structured {

	public static void main(String[] args) {
		printAllNumInListStructured(List.of(1, 3, 5, 2, 4, 3, 0, 9, 8, 4));
	}

	private static void printAllNumInListStructured(List<Integer> of) {

		for(Integer i: of) {
			System.out.println(i);
		}
	}
}
