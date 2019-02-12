import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class oldsleepy {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("sleepy.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));

		int n = Integer.parseInt(in.readLine());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		
		String[] s = in.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(s[i]));
			sorted.add(Integer.parseInt(s[i]));
		}
		
		Collections.sort(sorted);
		int min = sorted.get(0);
		int max = sorted.get(sorted.size() - 1);

		int count = 0;
		while (!list.equals(sorted)) {
			//System.out.println();for (int x : list) System.out.print(x + " ");
			
			int first = list.get(0);
			
			if (first == min) {
				if (list.indexOf(max) == list.size() - 1)
					list.add(first);
				else
					list.add(list.indexOf(max) + 1, first);
			}
			else {
				int index = sorted.indexOf(first);
				list.add(list.indexOf(sorted.get(index - 1)) + 1, first);
			}
			list.remove(0);
			count++;
		}

		//System.out.println();for (int x : list) System.out.print(x + " ");
		out.println(count);

		in.close();
		out.close();
	}

}
