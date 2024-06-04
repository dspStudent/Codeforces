import java.util.Scanner;
public class LineTrip{
	public static int f(int a[], int x, int n){
		int max=a[0];
		for(int i=1;i<a.length;i++){
			max=Math.max(max, a[i]-a[i-1]);
		}
		max=Math.max(max, 2*(x-a[a.length-1]));
		return max;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int x=sc.nextInt();
			int a[]=new int[n];
			for(int i=0;i<n;i++)a[i]=sc.nextInt();
			System.out.println(f(a, x, n));
		}
	}
}
