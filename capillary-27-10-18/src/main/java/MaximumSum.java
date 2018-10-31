import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class MaximumSum {

	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();

		int n = Integer.parseInt(line);
		arr = new int[n];

		line = br.readLine();
		String[] ints = line.split(" ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(ints[i]);
		}

		Set<Long> sums = new HashSet<>();

		int i = 0;
		int j = 0;
		while (i < n) {
			if (j >= n) {
				i++;
				j = i;
				continue;
			}
			sums.add(maxSubArraySum(arr, i, j));
			j++;
		}
		long total = 0;
		for (Long k : sums) {
			total += k;
		}

		System.out.println(total);
	}

	private static long maxSubArraySum(int[] a, int i, int j) {
		long max = a[i];
		long counter = a[i] > 0 ? a[i] : 0;

		for (int k = i + 1; k <= j; k++) {
			counter = counter + a[k];
			if (max < counter)
				max = counter;
			if (counter < 0)
				counter = 0;
		}
		return max;
	}
}
