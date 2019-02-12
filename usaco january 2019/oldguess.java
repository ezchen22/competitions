import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class oldguess {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("guess.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));

		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		
		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) {
			String[] s = in.readLine().split(" ");
			ArrayList<String> temp = new ArrayList<String>();
			for (int j = 0; j < Integer.parseInt(s[1]); j++) {
				temp.add(s[j + 2]);
			}
			list.add(temp);
		}
		
		int count = 0;
		while (!allSingle(list)) {
			String most = mostCommon(list);
			ArrayList<ArrayList<String>> toRemove = new ArrayList<ArrayList<String>>();
			for (ArrayList<String> sub : list) {
				if (!sub.contains(most))
					toRemove.add(sub);
			}
			list.removeAll(toRemove);
			for (ArrayList<String> sub : list) {
				sub.remove(sub.indexOf(most));
			}
			count++;
			//for (ArrayList<String> s : list) {for (String s2 : s) {System.out.print(s2 + " "); }System.out.println();}
		}
		
		System.out.println(count + 1);
		
		in.close();
		out.close();
	}
	
	
	
	public static boolean allSingle(ArrayList<ArrayList<String>> list) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				String s = list.get(i).get(j);
				if (map.containsKey(s))
					map.put(s, map.get(s) + 1);
				else
					map.put(s, 1);
			}
		}
		for (String k : map.keySet()) {
			if (map.get(k) > 1) {
				return false;
			}
		}
		return true;
	}
	
	public static String mostCommon(ArrayList<ArrayList<String>> list) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				String s = list.get(i).get(j);
				if (map.containsKey(s))
					map.put(s, map.get(s) + 1);
				else
					map.put(s, 1);
			}
		}
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
}
