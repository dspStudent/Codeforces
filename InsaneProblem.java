import java.util.*;

public class InsaneProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
       
        int t = sc.nextInt();
        
        // Process each test case
        while(t-- > 0) {
            // int n = sc.nextInt();
            long k=sc.nextLong();
            long l1=sc.nextLong();
            long r1=sc.nextLong();
            long l2=sc.nextLong();
            long r2=sc.nextLong();
            long ans=0;
            long mul=1;

            for(int i=1;i<=32;i++){
            
            	long e=Math.min(r2/mul, r1) - Math.max((long)((l2 + mul - 1) / mul), l1);

            	
            	// System.out.println("i "+i+" "+e+" mul"+mul);
            	if(e+1>=0)
            	ans+=e+1;

            	// System.out.println(i+" "+ans);
            	if(mul > (long) r2)break;
            	mul=mul*k;
            }

            System.out.println(ans);
         	
        }
        
        sc.close();
    }
    
  
}