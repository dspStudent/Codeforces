import java.io.*;
import java.util.*;
public class CoinPilesCsese {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer out = new StringBuffer();
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken()), y = Long.parseLong(st.nextToken());
			if (x == 0 && y == 0) {
				out.append("YES").append("\n");
				continue;
			}
			if (x == 0 || y == 0) {
				out.append("NO").append("\n"); continue;
			}
			if (x < y) {
				y = x ^ y;
				x = x ^ y;
				y = x ^ y;
			}
			if (x > 2 * y) {
				out.append("NO").append("\n");
				continue;
			}
			if ((x + y) % 3 == 0) {

				out.append("YES").append("\n");
				continue;
			}
			out.append("NO").append("\n");
		}
		System.out.println(out);
	}
}