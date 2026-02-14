import java.util.Scanner;

public class VasilijeInCacak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of test cases
        int t = sc.nextInt();
        
        // Process each test case
        while(t-- > 0) {
            int n = sc.nextInt();
            int k=sc.nextInt();
            long x=sc.nextLong();

            long lb=0, ub=0;

            int f=0, s=n-1-k;

            // long 

            int need=n-k;

            lb= ((long)k * ((long)k+1))/2;

            ub= (long)n * ((long)n+1)/2 - ((long)need * ((long)need+1)/2);

            // for(int i=0;i<n;i++){
            // 	if(f<=i+1){
            // 		lb+=sc.nextLong();
            // 	}
            // 	if(f>=s){
            // 		ub+=sc.nextLong();
            // 	}
            // 	f++;
            // }

            if(x>=lb && x<=ub){
            	System.out.println("Yes");
            }else{
            	System.out.println("No");
            }
            
        }
        
        sc.close();
    }
    
}