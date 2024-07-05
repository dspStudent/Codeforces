import java.io.*;
import java.util.*;
public class NearestVectorsCodeForces {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer out = new StringBuffer();
		List<int[]>vec = new ArrayList<>();
		int c = 0;
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			vec.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), ++c});
		}
		Collections.sort(vec, (i, j)->Double.compare( Math.atan2((double)i[1], (double)i[0]) , Math.atan2((double)j[1] , (double)j[0])) );
		int n = vec.size();
		// for (int i[] : vec)System.out.println(Arrays.toString(i));
		double min = 180.0;
		int ans1 = 0, ans2 = 0;
		for (int i = 1; i < n; i++) {
				int []line1 = vec.get(i-1);
				int []line2 = vec.get(i);
				double a1 = (double)line1[0], b1 = (double)line1[1], a2 = (double)line2[0], b2 = (double)line2[1];
				double cosIn = (a1 * a2 + b1 * b2) / (Math.sqrt(a1 * a1 + b1 * b1) * Math.sqrt(a2 * a2 + b2 * b2));
				cosIn = Math.max(-1.0, Math.min(1.0, cosIn));
				double angle = Math.acos(cosIn);
				if (min > angle) {
					min = angle;
					ans1 = line1[2]; ans2 = line2[2];
				}
		}
		System.out.println(ans1 + " " + ans2);
	}
}