import java.util.*;


class LightSwitches {

	int f(int rem, int a[], int k){
		int max=Arrays.stream(a).max().getAsInt();
		// System.out.println("f-> "+rem+" "+k+" "+max);

		int mod=2*k;
		int t=(max- (max%mod)) + rem; // remove the present rminder and add the rem
		return   t<max?t+mod:t;
	}

	int solve(int a[], int n, int k){
		int dp[]=new int[2*k];
		for(int i=0;i<n;i++){
			// System.out.println(a[i]%(2*k));
			dp[(a[i]%(2*k))]++;
		}
		// System.out.println(Arrays.toString(dp));
		int firstSum=0, end=0, start=0;

		while(end<dp.length+k){

			firstSum+=dp[end%(2*k)];

			if(end-start+1>k){
				// System.out.println(end-start+1 +" "+start+" "+(end%(2*k))+" "+firstSum);
				firstSum-=dp[start];
				start++;
			}


			if(firstSum==n){
				return f(end % (2*k), a, k);
			}
			end++;
		}

		return -1;

	}

    public static void main(String[] args) {
    	LightSwitches o=new LightSwitches();
        Scanner sc = new Scanner(System.in);
        
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