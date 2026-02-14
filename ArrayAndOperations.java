import java.util.*;

public class ArrayAndOperations {

	int solve(int a[], int n, int k){

		int sum=0;
		int i=0;
		for(i=0;i<n-2*k;i++)sum+=a[i];
		// System.out.println("i "+i);
		int j=n-k-1;
		int it=n-1;
		// System.out.println("j "+j+" it "+it);
		while(j>=i){
			// System.out.println("j "+j+" it "+it+" su "+(a[it]==a[j]?0:1));

			sum+=a[it]==a[j]?1:0;

			it--;j--;
		}

		return sum;


	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayAndOperations o=new ArrayAndOperations();
        
        // Read the number of test cases
        int t = sc.nextInt();
        
        // Process each test case
        while(t-- > 0) {
            int n = sc.nextInt();
            int k=sc.nextInt();

            int a[]=new int[n];
            for(int i=0;i<n;i++){
            	a[i]=sc.nextInt();
            }
            Arrays.sort(a);
            System.out.println(o.solve(a, n, k));
            
        }
        
        sc.close();
    }
    
    // Example method to calculate goals needed for victory
    // public static int calculateGoals(int n) {
    //     // Implement your logic here
    //     return 0; // Placeholder return statement
    // }
}