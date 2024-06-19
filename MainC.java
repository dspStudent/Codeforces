// "static void main" must be defined in a public class.
import java.util.*;
public class MainC {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)a[i]=sc.nextInt();
           
            int sum=a[0];
            for(int i=1;i<n-1;i++){
                    if(sum==a[i]){
                        a[i]=a[i]^a[i+1];
                        a[i+1]=a[i]^a[i+1];
                        a[i]=a[i]^a[i+1];
                    }
                sum+=a[i];
            }
            if(sum==a[n-1]){
                System.out.println("No");
            }
            else {
                System.out.println("yes");
                Arrays.stream(a).forEach(i->System.out.print(i+" "));
                System.out.println();
            }
            
            
        }
    }
}