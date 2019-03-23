import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class herding2 {

	public int[] getMaxMinSteps(TreeSet<Integer> set, int n) {
		int[] res = new int[] {Integer.MAX_VALUE, 0};
		dfs(set, n, 0, res);
		return res;
	}

	private void dfs(TreeSet<Integer> set, int n, int steps, int[] res) {
		int min = set.first();
		int max = set.last();
		if (max - min == n - 1) {
			res[0] = Math.min(res[0], steps);
			res[1] = Math.max(res[1], steps);
			return;
		}
		set.remove(min);
		int nextMin = set.first();
		for (int i = nextMin + 1; i < max; i++) {
			if (!set.contains(i)) {
				set.add(i);
				dfs(set, n, steps + 1, res);
				set.remove(i);
			}
		}
		set.add(min);
		set.remove(max);
		int nextMax = set.last();
		for (int i = min + 1; i < nextMax; i++) {
			if (!set.contains(i)) {
				set.add(i);
				dfs(set, n, steps + 1, res);
				set.remove(i);
			}
		}
		set.add(max);
	}

	public void parser() {
		String line;
		try {
			BufferedReader in = new BufferedReader(new FileReader("herding.in"));
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
			while ((line = in.readLine()) != null) {
				int totalLine = Integer.parseInt(line);
				int n = totalLine;
				TreeSet<Integer> set = new TreeSet<Integer>();
				while (totalLine-- > 0 && (line = in.readLine()) != null) {
					set.add(Integer.valueOf(line));
				}
				int[] res = getMaxMinSteps(set, n);
				out.println(res[0]);
				out.print(res[1]);
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
		herding2 test = new herding2();
		test.parser();
	}

}
