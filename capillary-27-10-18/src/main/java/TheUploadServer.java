import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class TheUploadServer {

	private static List<Character> out;

	private static boolean isNameValid(String a) {
		for (int i = 0; i < a.length(); i++) {
			if ((a.charAt(i) > 96 && a.charAt(i) < 123) || (a.charAt(i) > 64 && a.charAt(i) < 91)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isBitrateFpsValid(String a) {
		if (a.charAt(0) == 48) {
			return false;
		}
		try {
			new BigInteger(a);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	public static void process_data(String a, String b) {
		boolean check1 = isNameValid(a) && isBitrateFpsValid(b);
		boolean check2 = isNameValid(b) && isBitrateFpsValid(a);
		if (check1 || check2) {
			out.add('M');
		} else {
			out.add('N');
		}
	}

	public static void process_data(String a, String b, String c) {
		boolean check1 = isNameValid(a) && isBitrateFpsValid(b) && isBitrateFpsValid(c);
		boolean check2 = isNameValid(b) && isBitrateFpsValid(a) && isBitrateFpsValid(c);
		boolean check3 = isNameValid(c) && isBitrateFpsValid(b) && isBitrateFpsValid(a);
		if (check1 || check2 || check3) {
			out.add('V');
		} else {
			out.add('N');
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		Integer n = Integer.parseInt(line);
		out = new LinkedList<>();
		while (n > 0) {
			n--;
			line = br.readLine();
			String[] data = line.split(" ");
			if (data.length == 2) {
				process_data(data[0], data[1]);
			} else {
				process_data(data[0], data[1], data[2]);
			}
		}

		for (char c : out) {
			System.out.println(c);
		}
	}
}
