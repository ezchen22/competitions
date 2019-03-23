import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class oldherding {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("herding.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
		
		int n = Integer.parseInt(in.readLine());
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		/*ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(in.readLine()));
		}
		
		int min1 = 1;
		for (int i = list.size() - 1; i > 0; i--) {
			if (list.get(i) <= list.get(i - 1)) {
				break;
			}
			min1++;
		}
		
		int min2 = 1;
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) >= list.get(i + 1))
				break;
			min2++;
		}
		
		System.out.println(list.size() - (min1 > min2 ? min1 : min2));
		System.out.println(min1 + min2);*/
		
		int t = radixsort(arr);
		out.println(t);
		out.print(arr.length - t);
		
		in.close();
		out.close();
	}
	
	public static int radixsort(int[] arr) {
		int m = getMax(arr);
		int count = 0;
		for (int exp = 1; m / exp > 0; exp *= 10) {
			countSort(arr, exp);
			count++;
		}
		return count;
	}

	public static int getMax(int[] arr) {
		int max = arr[0];
		for (int x : arr) {
			if (x > max)
				max = x;
		}
		return max;
	}

	public static void countSort(int[] arr, int exp) {
		int[] output = new int[arr.length];
		int[] count = new int[10];

		for (int i = 0; i < arr.length; i++)
			count[(arr[i] / exp) % 10]++;
		for (int i = 1; i < 10; i++)
			count[i] += count[i - 1];

		for (int i = arr.length - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}

		for (int i = 0; i < arr.length; i++)
			arr[i] = output[i];
	}

}

/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class herding {

	private int[] groupCow(int N, Set<Integer> cows, int l, int r) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int count = 0;
		int idx = l;
		while (idx <= r) {
			if (cows.contains(idx)) {
				count++;
			}
			if (idx - N >= l && cows.contains(idx - N)) {
				count--;
			}
			if (idx - N >= l - 1) {
				min = Math.min(min, N - count);
				max = Math.max(max, N - count);
			}
			idx++;
		}
		return new int[] { min, max };
	}

	public void parser() {
		String line;
		try {
			BufferedReader in = new BufferedReader(new FileReader("herding.in"));
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
			while ((line = in.readLine()) != null) {
				int N = Integer.parseInt(line);
				//System.out.println("N = " + N);
				Set<Integer> cows = new HashSet<>();
				int l = Integer.MAX_VALUE;
				int r = Integer.MIN_VALUE;
				int total = N;
				while (total-- > 0 && (line = in.readLine()) != null) {
					//System.out.println(line);
					int location = Integer.parseInt(line);
					l = Math.min(l, location);
					r = Math.max(r, location);
					cows.add(location);
				}
				//System.out.println("l = " + l + " r = " + r);
				int[] res = groupCow(N, cows, l, r);
				//System.out.println("min = " + res[0] + " max = " + res[1]);
				out.println(res[0]);
				out.println(res[1]);
			}
			in.close();
			out.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		herding h = new herding();
		h.parser();
	}
	
}*/
