import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class revegetate {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("revegetate.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));

		String[] s = in.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		Map<Integer, Set<Integer>> same = new HashMap<>();
		Map<Integer, Set<Integer>> diff = new HashMap<>();
		for (int i = 0; i < m; i++) {
			String[] temp = in.readLine().split(" ");
			int p1 = Integer.parseInt(temp[1]) - 1;
			int p2 = Integer.parseInt(temp[2]) - 1;
			if (temp[0].equals("S")) {
				same.putIfAbsent(p1, new HashSet<>());
				same.putIfAbsent(p2, new HashSet<>());
				same.get(p1).add(p2);
				same.get(p2).add(p1);
			} else {
				diff.putIfAbsent(p1, new HashSet<>());
				diff.putIfAbsent(p2, new HashSet<>());
				diff.get(p1).add(p2);
				diff.get(p2).add(p1);
			}
		}
		String res = getWay(n, same, diff);
		out.println(res);
		
		in.close();
		out.close();
	}

	public static String getWay(int N, Map<Integer, Set<Integer>> same, Map<Integer, Set<Integer>> diff) {
		int[] pastures = new int[N];
		StringBuilder res = new StringBuilder();

		int count = 0;
		for (int i = 0; i < N; i++) {
			if (pastures[i] == 0) {
				if (!dfs(pastures, i, same, diff, 1)) {
					return "0";
				}
				count++;
			}
		}
		res.append(1);
		while (count-- > 0) {
			res.append(0);
		}
		return res.toString();
	}

	public static boolean dfs(int[] pastures, int slot, Map<Integer, Set<Integer>> same,
			Map<Integer, Set<Integer>> diff, int color) {
		if (pastures[slot] != 0 && pastures[slot] != color) {
			return false;
		}
		if (pastures[slot] != 0 && pastures[slot] == color) {
			return true;
		}
		pastures[slot] = color;
		if (same.containsKey(slot)) {
			for (int x : same.get(slot)) {
				if (!dfs(pastures, x, same, diff, color)) {
					return false;
				}
			}
		}
		if (diff.containsKey(slot)) {
			for (int x : diff.get(slot)) {
				if (!dfs(pastures, x, same, diff, -color)) {
					return false;
				}
			}
		}
		return true;
	}

}
