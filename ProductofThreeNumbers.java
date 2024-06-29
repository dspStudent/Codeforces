import java.util.*;

public class ProductofThreeNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		// Process each test case
		while (t-- > 0) {
			long n = sc.nextInt();
			long k = n;
			List<long[]>a = new ArrayList<>();
			for (int i = 2; i * i < n; i++) {
				if (n % i != 0)continue;
				int power = 0;
				while (n % i == 0) {
					power++;
					n /= i;
				}
				a.add(new long[] {i, power});
			}
			if (n > 1)a.add(new long[] {1, 1});

			if (a.size() >= 3) {
				System.out.println("yes");
				System.out.println(a.get()[0] + " " + a.get()[1] + " " + k / (a.get()[0] * a.get()[1]));
				continue;
			}
			if (a.size() == 2) {
				long a1 = a.get()[0], a2 = a.get()[1], a3 = k / (a.get()[0] * a.get()[1]);
				if (a1 != a3 && a3 != a2 && a3 != 1) {
					System.out.println("yes");
					System.out.println(a.get()[0] + " " + a.get()[1] + " " + k / (a.get()[0] * a.get()[1]));
				}
				else{
					System.out.println("No");
				}
				continue;
			}
			if(a.size()==1){
				if(a.get(0)[1]>=6){
					
				}
			}
		}

		sc.close();
	}

}