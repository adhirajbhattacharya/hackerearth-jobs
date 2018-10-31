
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RUN {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int t = Integer.parseInt(line);
		while (t != 0) {
			t--;
			line = br.readLine();
			String[] splits = line.split(" ");
			int n = Integer.parseInt(splits[0]);
			long p = Long.parseLong(splits[1]);
			line = br.readLine();
			splits = line.split(" ");
			int[] h = new int[n];
			for (int i = 0; i < n; i++)
				h[i] = Integer.parseInt(splits[i]);
			int evens = 0;
			int odds = 0;
			int i = 0;
			boolean flag = true;
			while (p > 0 && i < n) {
				int tmp = h[i];
				if (tmp % 2 == 0)
					tmp = tmp - evens - odds;
				else if (evens == 0)
					tmp = tmp - odds;
				else
					tmp = tmp - odds - evens + 1;
				if (tmp > 0)
					p = p - tmp;
				i++;
				if (flag)
					evens++;
				else
					odds++;
				flag = !flag;
			}
			if (i == n && p >= 0)
				System.out.println("Yes " + p);
			else
				System.out.println("No");
		}
	}
}
