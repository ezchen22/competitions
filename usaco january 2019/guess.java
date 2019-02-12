//bronze
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class guess {

	public static int calculate(List<Set<String>> animal) {
		if (animal == null || animal.size() == 0) {
			return 0;
		}
		int max = 0;
		for (int i = 0; i < animal.size() - 1; i++) {
			Set<String> a1 = animal.get(i);
			for (int j = i + 1; j < animal.size(); j++) {
				Set<String> a2 = animal.get(j);
				int overlap = 0;
				for (String s : a2) {
					if (a1.contains(s)) {
						overlap++;
					}
				}
				max = Math.max(max, overlap);
			}
		}

		return max + 1;
	}

	public static void main(String[] args) throws IOException {
		String line;
		BufferedReader in = new BufferedReader(new FileReader("guess.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));

		while ((line = in.readLine()) != null) {
			int totalLine = Integer.parseInt(line);
			List<Set<String>> animal = new ArrayList<>();
			while (totalLine-- > 0 && (line = in.readLine()) != null) {
				String[] str = line.split(" ");
				animal.add(new HashSet<>());
				for (int i = 2; i < str.length; i++) {
					animal.get(animal.size() - 1).add(str[i]);
				}
			}
			out.println(calculate(animal));
		}
		in.close();
		out.close();
	}
}
