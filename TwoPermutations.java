import java.util.*;

public class TwoPermutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of test cases
        int t = sc.nextInt();
        
        // Process each test case
        while(t-- > 0) {
            int n = sc.nextInt();
            int a=sc.nextInt();
            int b=sc.nextInt();
            if(a==b && n==a){
            	System.out.println("Yes");
            	continue;
            }
            if(n-a-b>1)System.out.println("yes");
            else System.out.println("NO");
        }
        
        sc.close();
    }
    
    // Example method to calculate goals needed for victory
    // public static int calculateGoals(int n) {
    //     // Implement your logic here
    //     return 0; // Placeholder return statement
    // }
}