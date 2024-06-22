import java.util.*;

public class WeirdAlgorithm {
	static List<Long>a=new ArrayList<>();
	private static void solve (long n){
		while(n!=1){
			a.add(n);
			if(n%2==0)n/=2;
			else n=n*3+1;
		}
		a.add(1L);
	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        solve(n);
        a.stream().forEach(i->System.out.print(i+" "));
        sc.close();
    }
}
    