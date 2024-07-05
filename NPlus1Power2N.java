import java.io.*;
import java.util.*;
public class NPlus1Power2N {
	private static long mathPow(long a, int b) {
		long res = 1L;
		while (b != 0) {
			if ((b & 1) == 1)res = (res * a);
			a = (a * a);
			b >>= 1;
		}
		return res;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer out = new StringBuffer();
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			long pn = mathPow(2, n);
			if (n == 1) {
				out.append("[1, 1]" + " 1").append("\n");
				continue;
			}
			if (n == 2) {
				out.append("[1, 1, 2]" + " 4").append("\n");
				continue;
			}
			if (n == 3) {
				out.append("[1, 2, 2, 3]" + " 8").append("\n");
				continue;
			}
			List<Long>a = new ArrayList<>();
			for (int i = 1; i <= n - 2; i++)a.add((long)i);
			int sumN1 = (n - 1) * (n) / 2;
			if ((pn - sumN1) % 2 == 0) {
				a.add((long)n - 1);
			} else {
				sumN1 += 1;
			}
			a.add((pn - sumN1) / 2L);
			a.add((pn - sumN1) / 2L);
			out.append(a + " " + pn).append("\n");
		}
		System.out.println(out);
	}
}

// n=1
// p=2
// 1 1

// n=2
// p=4
// 1 1 2

// n=3
// p=8
// 1 3 2 2

// n=4
// p=16
// 1 2 3 5 5

// n=5
// p=32
// 1 2 3 4 6 6

// n=6
// p=64
// 1 2 3 4 6 24 24

// n=7
// p=128