import java.util.*;

public class IncreasingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        long a[]=new long[n];
        for(int i=0;i<n;i++)a[i]=sc.nextLong();
        long count=0;
        for(int i=1;i<n;i++){
        	if(a[i-1]<=a[i])continue;
        	count+=a[i-1]-a[i];
        	a[i]+=a[i-1]-a[i];
        }
        System.out.println(count);
        sc.close();
    }
}