// "static void main" must be defined in a public class.
import java.util.*;
public class NewBakery {
    private static long f(long n, long a, long b, long mid){
        // if(mid==0)return n*a;
        long bsum=b*(mid);
        long sum=(mid-1L)*(mid)/2L;
        long asum=a*(n-mid);
        return bsum-sum+asum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long t=sc.nextInt();
        while(t-- > 0){
            long n=sc.nextInt();
            long a=sc.nextInt();
            long b=sc.nextInt();
            long start=0L, end=Math.min(b, n);
            long ans=0L;
            while(start<=end){
                long mid1=start+(end - start)/3L;
                long mid2=end-(end-start)/3L;
                long left=f(n, a, b, mid1);
                long right=f(n, a, b, mid2);
                // System.out.println(left+" "+mid1+" "+right+" "+mid2);
                if(left==right){
                    start=mid1;end=mid2;
                    ans=Math.max(ans,left);
                }
                if(left>right){
                    end=mid2-1L;
                }
                else {
                    start=mid1+1L;
                }
            }
            System.out.println(f(n, a, b, end));
        }
    }
}

// 0 1 2 3 4 5 6
// 8 7 6 5 5 5 5

// 8 8 8 8







