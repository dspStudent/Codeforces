import java.util.*;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Set<Integer>set=new HashSet<>();
        int n = sc.nextInt()-1;
        int a[]=new int[n];
        for(int i=0;i<n;i++){
        	a[i]=sc.nextInt();
        }
        n++;
        long sum=((n)*(n+1L))/2L;
        long suma=Arrays.stream(a).sum();
        int ans=(int)(sum-suma);
        System.out.println(ans);
        sc.close();
    }
    
}