import java.util.Scanner;

public class Swaps {
	String solve(int a[], int b[], int n){

		int min
	
	}
    public static void main(String[] args) {
    	Swaps o=new Swaps();
        Scanner sc = new Scanner(System.in);
        
        // Read the number of test cases
        int t = sc.nextInt();
        
        // Process each test case
        while(t-- > 0) {
            int n = sc.nextInt();
            
            int a[]=new int[n];
            int b[]=new int[n];

            for(int i=0;i<n;i++){
            	a[i]=sc.nextInt();
            }
           	
           	for(int i=0;i<n;i++){
            	b[i]=sc.nextInt();
            }
           
           	System.out.println(o.solve(a, b, n));
        }
        
        sc.close();
    }
    
    
}