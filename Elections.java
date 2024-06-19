// "static void main" must be defined in a public class.
import java.util.*;
public class Elections {
    private static void printEl(long a[]){
        Arrays.stream(a).forEach(i->{
            System.out.print(i+" ");
            });
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long t=sc.nextLong();
        while(t-->0L){
            int n=sc.nextInt(), maxInd=0;;
            long k=sc.nextLong();
            long a[]=new long[n];
            long pref[]=new long[n];
            long ans[]=new long[n];
            long max=0;

            for(int i=0;i<n;i++){
                a[i]=sc.nextLong();
                pref[i]+=i>=1?pref[i-1]+a[i]:a[i];
                if(max < a[i]){
                    maxInd=i;
                    max=a[i];
                }
            }
            ans[maxInd]=a[0]+k>=max?maxInd:0;
            ans[0]=k+a[0]>=max?0:1;
            for(int i=1;i<n;i++){
                if(i==maxInd)continue;
                ans[i]=pref[i]+k>=max?i:i+1;
            }
            // System.out.println(max+" "+maxInd);
            // System.out.println(Arrays.toString(pref));
            printEl(ans);
        }
    }
}

// 4 5
// 3 10 7 1
// 3 13 20 21
// 1 0  
// n=3
// k=5

