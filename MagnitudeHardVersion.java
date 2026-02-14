import java.util.*;

public class MagnitudeHardVersion {

	long solve(int a[], int n, int k){

		long mag1[]=new long[n];

		long mag2[]=new long[n];

		int pow=0;

		mag1[0]=a[0];

		mag2[0]=Math.abs(a[0]);

		if(mag1[0]!=mag2[0])pow+=1;

		for(int i=1;i<n;i++){
			mag1[i]=mag1[i-1]+a[i];

			mag2[i]=mag2[i-1]+a[i];

			if(mag1[i]<0 && Math.abs(mag1[i])==Math.max(mag2[i], Math.abs(mag1[i]))){
				pow++;
				mag2[i]=Math.max(mag2[i], Math.abs(mag1[i]));
			}

		}

		// if(mag1[n-1]!=mag2[n-1])pow++;


		return (long)Math.pow(2, n-pow);

	}

    public static void main(String[] args) {
    	MagnitudeHardVersion o=new MagnitudeHardVersion();
        Scanner sc = new Scanner(System.in);
        
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