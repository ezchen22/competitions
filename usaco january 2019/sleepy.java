//bronze
import java.io.*;
import java.util.ArrayList;

public class sleepy {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("sleepy.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));

		int n = Integer.parseInt(in.readLine());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		String[] s = in.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(s[i]));
		}
		
		int count = 1;
		for (int i = list.size() - 1; i > 0; i--) {
			if (list.get(i) <= list.get(i - 1)) {
				break;
			}
			count++;
		}
		
		
		out.println(list.size() - count);

		in.close();
		out.close();
	}

}
