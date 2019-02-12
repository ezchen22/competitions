import java.io.*;
import java.util.HashMap;

public class oldoldguess {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("guess.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) {
			String[] s = in.readLine().split(" ");
			for (int j = 2; j < s.length; j++) {
				if (map.containsKey(s[j]))
					map.put(s[j], map.get(s[j]) + 1);
				else
					map.put(s[j], 1);
			}
		}
		
		//for (String k : map.keySet()) System.out.println(k + " " + map.get(k));
		
		int count = 0;
		while (!allSingle(map)) {
			map.remove(max(map));
			count++;
		}
		
		out.println(count + 1);
		
		//for (String k : map.keySet()) System.out.println(k + " " + map.get(k));
		
		in.close();
		out.close();
	}
	
	public static String max(HashMap<String, Integer> map) {
		int max = 0;
		String s = "";
		for (String k : map.keySet()) {
			if (map.get(k) > max) {
				max = map.get(k);
				s = k;
			}
		}
		return s;
	}
	
	public static boolean allSingle(HashMap<String, Integer> map) {
		for (String k : map.keySet()) {
			if (map.get(k) > 1) {
				return false;
			}
		}
		return true;
	}
}
