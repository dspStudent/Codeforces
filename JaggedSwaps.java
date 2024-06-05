import java.util.Scanner;
public class JaggedSwaps{
	public static boolean f(int a[]){
		for(int i=1;i<a.length;i++)if(a[i-1]>a[i])return false;
		return true;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int a[]=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			if(a[0]==1)System.out.println("YES");
			else System.out.println("NO");
		}
	}
}