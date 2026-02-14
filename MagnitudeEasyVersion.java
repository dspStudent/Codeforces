import java.util.*;

public class MagnitudeEasyVersion {


	long solve(int a[], int n, int k){
		
		long pref[][]=new long[n][2];
		long past=0;
		int present=0;
		pref[0][0]=a[0];
		// if(pref[0][0]<0){
			present=1;
			pref[0][1]=Math.abs(a[0]);
			past=a[0];
		// }

		for(int i=1;i<n;i++){
			pref[i][0]=pref[i-1][0] + a[i];
			pref[i][1]=pref[i-1][1] +a[i];
			long mag1=Math.abs(pref[i][0]);

			long mag2=Math.abs(pref[i][1]);

			if(mag1> mag2){
				pref[i][1]=mag1;
			}

			pref[i][1]=Math.max(mag1, mag2);

		}
		return Math.max(pref[n-1][0], pref[n-1][1]);

	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MagnitudeEasyVersion o=new MagnitudeEasyVersion();

        
        // Read the number of test cases
        int t = sc.nextInt();
        
        // Process each test case
        while(t-- > 0) {
            int n = sc.nextInt();

            int a[]=new int[n];
            for(int i=0;i<n;i++){
            	a[i]=sc.nextInt();
            }

            System.out.println(o.solve(a, n, 0));

          
        }

        
        sc.close();
    }
    
  
}