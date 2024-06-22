import java.util.*;
public class  CountNumberofNiceSubarrays {
	private int f (int a[], int k) {
		int count = 0, odd = 0, n = a.length;
		int i = 0, j = 0;
		while (j < n) {
			if (a[j] % 2 != 0)odd++;

			while (odd > k) {
				if (a[i] % 2 != 0)odd--;
				i++;
			}
			int len = j - i + 1;
			count += len ;
			// System.out.println("i: "+i + " j: " + j + " odd: " + odd + " count: " + count);
			j++;
		}
		return count;
	}
	public int numberOfSubarrays(int[] a, int k) {
		return f(a, k) -f(a, k-1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CountNumberofNiceSubarrays s = new CountNumberofNiceSubarrays();
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)a[i] = sc.nextInt();
		int k = sc.nextInt();
		int ans = s.numberOfSubarrays(a , k);
		System.out.println(ans);

		sc.close();
	}
}