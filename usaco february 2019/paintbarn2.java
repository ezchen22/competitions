import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class paintbarn2 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("paintbarn.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
		
		String[] s = in.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		
		ArrayList<int[]> points = new ArrayList<int[]>();
		
		int max = 0;
		for (int i = 0; i < n; i++) {
			s = in.readLine().split(" ");
			int[] temp = new int[4];
			for (int j = 0; j < 4; j++) {
				temp[j] = Integer.parseInt(s[j]);
				max = temp[j] > max ? temp[j] : max;
			}
			points.add(temp);
		}
		
		int[][] plane = new int[max + 1][max + 1];
		
		for (int[] arr : points) 
			for (int i = arr[0]; i < arr[2]; i++)
				for (int j = arr[1]; j < arr[3]; j++)
					plane[i][j]++;
		
		
		int count = 0;
		for (int[] arr : plane)
			for (int x : arr)
				if (x == k)
					count++;
		
		System.out.println(count);
			
		in.close();
		out.close();
	}

}