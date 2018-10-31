
import java.util.Arrays;

public class TestClass {

	private static boolean[] paired;

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 5, 3 ,6};
		int[] j = solve(arr);
		System.err.println(j);
	}

	private static int[] solve(int[] arr) {
		Arrays.sort(arr);
		paired = new boolean[arr.length];
		int pairs = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			paired[i] = true;
			int j = -1;
			for (j = i - 1; j >= 0; j--) {
				if (paired[j]) {
					continue;
				}
				if (arr[j] <= arr[i] / 2) {
					break;
				}
			}
			if (j != -1) {
				pairs++;
				paired[j] = true;
			}
		}
		int unpaired = arr.length - 2 * pairs;
		return new int[] { -1, pairs, unpaired > 0 ? unpaired : 0 };
	}

	// private static int binarySearch(int[] arr, int index) {
	// int element = arr[index] / 2;
	// if (index == 0) {
	// return -1;
	// }
	// int lo = -1;
	// int hi = -1;
	// for (int i = 0; i < index; i++) {
	// if (paired[i]) {
	// continue;
	// }
	// lo = i;
	// }
	// for (int j = index - 1; j >= 0; j--) {
	// if (paired[j]) {
	// continue;
	// }
	// hi = j;
	// }
	// if (lo == -1 || hi == -1)
	// return -1;
	// while (lo <= hi) {
	// int mid = (lo + hi) / 2;
	// if(element == arr[mid])
	// }
	//
	// }
}
