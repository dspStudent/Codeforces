import java.util.*;

public class ForkedTLE900 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of test cases
        int t = sc.nextInt();
        
        // Process each test case
        while(t-- > 0) {
            long a=sc.nextLong();
            long b=sc.nextLong();

            long xk=sc.nextLong();
            long yk=sc.nextLong();

            long xq=sc.nextLong();
            long yq=sc.nextLong();

            long x[]={a, a,-a,b,-b, -a, -b, b};
            long y[]={b,-b,b,a, a, -b, -a, -a};

            HashSet<String> set=new HashSet<>();

            for(int i=0;i<8;i++){
            	long dx=xk+x[i];
            	long dy=yk+y[i];
            	set.add(dx+""+dy);
            }

            // System.out.println(set);
            int count=0;

            for(int i=0;i<8;i++){
            	long dx=xq+x[i];
            	long dy=yq+y[i];
            	// System.out.println(" --->"+ dx+""+dy);
            	if(set.contains(dx+""+dy)){
            		set.remove(dx+""+dy);	
            		count++;
            	}
            	
            }

            System.out.println(count);

          
        }
        
        sc.close();
    }
    
    // Example method to calculate goals needed for victory
    // public static int calculateGoals(int n) {
    //     // Implement your logic here
    //     return 0; // Placeholder return statement
    // }
}