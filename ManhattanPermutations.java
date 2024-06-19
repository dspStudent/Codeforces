// "static void main" must be defined in a public class.
import java.util.*;
public class ManhattanPermutations {
    private static void printEl(long a[]){
        System.out.println("Yes");
        Arrays.stream(a).forEach(i->{
            if(i!=0)
            System.out.print(i+" ");
            });
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long t=sc.nextLong();
        while(t-->0L){
            int n=sc.nextInt();
            long k=sc.nextLong();
            if(k%2!=0){
                System.out.println("NO");continue;
            }
            long []a=new long[n+1];
            long max=0;
            for(int i=1;i<=n;i++){
                a[i]=(long)i;
                max+=Math.abs((n-(i-1))-i);
            }
            if(k==0){
                printEl(a);
                continue;
            }
            if(k>max){
                System.out.println("NO");
                continue;
            }
            if(k==max){
                int i=1, j=n;
                while(i<j){
                    a[i]=a[i]^a[j];
                    a[j]=a[i]^a[j];
                    a[i]=a[i]^a[j];
                    i++;j--;
                }
                printEl(a);
                continue;
            }
            long x=k/2;
            int i=1, j=n;
            while(i<j){
                if(x==0){
                    printEl(a);break;
                }
                if(Math.abs(a[i]-a[j]) == x){
                    x=x-Math.abs(a[i]-a[j]);
                    a[i]=a[i]^a[j];
                    a[j]=a[i]^a[j];
                    a[i]=a[i]^a[j];
                    printEl(a);
                    break;
                }
                if( Math.abs(a[i]-a[j]) < x){
                    x=x-Math.abs(a[i]-a[j]);
                    a[i]=a[i]^a[j];
                    a[j]=a[i]^a[j];
                    a[i]=a[i]^a[j];
                    i++;j--;
                }
                else j--;
            }
            
        }
    }
}

