import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class paintbarn {

	int[][] array = new int[1001][1001];

	public void paint(int[][] array, int x1, int y1, int x2, int y2) {
		for (int i = x1; i < x2; i++) 
			for (int j = y1; j < y2; j++) 
				array[i][j]++;
	}

	public void parser() {
		String line;
		try {
			BufferedReader in = new BufferedReader(new FileReader("paintbarn.in"));
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
			while ((line = in.readLine()) != null) {
				String[] firstLine = line.split(" ");
				int totalLine = Integer.parseInt(firstLine[0]);
				int k = Integer.valueOf(firstLine[1]);
				while (totalLine-- > 0 && (line = in.readLine()) != null) {
					String[] str = line.split(" ");
					Integer[] pair = new Integer[4];
					for (int i = 0; i < 4; i++) {
						pair[i] = Integer.valueOf(str[i]);
					}
					paint(array, pair[0], pair[1], pair[2], pair[3]);
				}
				int res = 0;
				for (int i = 0; i < 1001; i++) 
					for (int j = 0; j < 1001; j++) 
						if (array[i][j] == k) 
							res++;
				out.println(res);
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
		paintbarn test = new paintbarn();
		test.parser();
	}

}
