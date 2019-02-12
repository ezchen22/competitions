//bronze
import java.io.*;

public class shell {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("shell.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));

		int n = Integer.parseInt(in.readLine());
		int[] shells = { 1, 2, 3 };
		int[] scores = new int[3];
		//System.out.print("original: ");for (int x : shells) System.out.print(x + " ");System.out.println();
		for (int i = 0; i < n; i++) {
			String[] s = in.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int g = Integer.parseInt(s[2]);
			swap(shells, a - 1, b - 1);
			if (g == 1) {
				if (shells[0] == 1) {
					scores[0]++;
				}
				if (shells[0] == 2) {
					scores[1]++;
				}
				if (shells[0] == 3) {
					scores[2]++;
				}
			}
			if (g == 2) {
				if (shells[1] == 2) {
					scores[1]++;
				}
				if (shells[1] == 3) {
					scores[2]++;
				}
				if (shells[1] == 1) {
					scores[0]++;
				}
			}
			if (g == 3) {
				if (shells[2] == 3) {
					scores[2]++;
				}
				if (shells[2] == 2) {
					scores[1]++;
				}
				if (shells[2] == 1) {
					scores[0]++;
				}
			}
			//System.out.print("swap " + (i + 1) + ": "); for (int x : shells) System.out.print(x + " "); System.out.println();
		}

		int max = scores[0];
		for (int x : scores) {
			if (x > max) {
				max = x;
			}
		}

		//for (int x : scores) System.out.print(x + " "); System.out.println();

		out.println(max);

		in.close();
		out.close();
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
