//silver
import java.awt.Point;
import java.awt.Polygon;
import java.io.*;
import java.util.*;

public class mountains {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("mountains.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));

		int n = Integer.parseInt(in.readLine());
		ArrayList<Triangle> mountains = new ArrayList<Triangle>();
		for (int i = 0; i < n; i++) {
			String[] s = in.readLine().split(" ");
			Triangle add = new Triangle(new Point(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
			boolean b = true;
			ArrayList<Triangle> remove = new ArrayList<Triangle>();
			for (Triangle t : mountains) {
				if (t.overlaps(add)) {
					b = false;
				}
				if (add.overlaps(t))
					remove.add(t);
			}
			if (b) {
				mountains.add(new Triangle(new Point(Integer.parseInt(s[0]), Integer.parseInt(s[1]))));
				mountains.removeAll(remove);
			}
		}
		
		/*ArrayList<Triangle> remove = new ArrayList<Triangle>();
		for (int i = 0; i < mountains.size(); i++) {
			for (int j = i + 1; j < mountains.size(); j++) {
				if (mountains.get(i).overlaps(mountains.get(j)) && remove.indexOf(mountains.get(j)) == -1) {
					remove.add(mountains.get(j));
				}
				if (mountains.get(j).overlaps(mountains.get(i)) && remove.indexOf(mountains.get(i)) == -1) { 
					remove.add(mountains.get(i));
				}
			}
		}*/
		
		out.println(mountains.size());
		
		in.close();
		out.close();
	}
	
	

}

class Triangle {
	
	public Polygon poly;
	public Point peak;
	
	public Triangle(Point p) {
		peak = p;
		int a = (int)p.getX();
		int b = (int)p.getY();
		poly = new Polygon(new int[]{a - b, a, a + b}, new int[]{0, b, 0}, 3);
	}
	
	
	public boolean overlaps(Triangle other) {
		Polygon p = other.poly;
		return poly.xpoints[0] <= p.xpoints[0] && poly.xpoints[2] >= p.xpoints[2] && poly.ypoints[1] >= p.ypoints[1];
		//return poly.contains(other.peak);
	}
	
}
