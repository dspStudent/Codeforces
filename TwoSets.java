import java.io.*;
import java.util.*;
public class TwoSets {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer one = new StringBuffer();
		StringBuffer sec = new StringBuffer();
		long sum = t * (t + 1) / 2;
		if (sum % 2 != 0) {
			System.out.println("NO");
			return;
		}
		one.append("YES").append("\n");
		if (t % 2 == 0) {
			one.append(t / 2).append("\n");
			sec.append(t / 2).append("\n");
			int i = 1, j = t;
			while (i < j) {
				if (i % 2 != 0) {
					one.append(i + " ").append(j + " ");
					i++; j--;
				} else {
					sec.append(i + " ").append(j + " ");
					i++; j--;
				}
			}
			one.append("\n").append(sec);
			System.out.println(one);
			return;
		}
		one.append(((t / 2))).append("\n");
		sec.append((t / 2)+1).append("\n");
		one.append(t-- +" ");
		int i = 1, j = t;
		while (i < j) {
			if (i % 2 == 0) {
				one.append(i + " ").append(j + " ");
				i++; j--;
			} else {
				sec.append(i + " ").append(j + " ");
				i++; j--;
			}
		}
		one.append("\n").append(sec);
		System.out.println(one);
	}
}
