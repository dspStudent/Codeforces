import java.util.*;

public class QuotientAndRemainder {

	int ubM1(long q[], int start, int end, long x){

		while(start<end){
			int mid=start+(end-start)/2;
			// System.out.println("ubM1 "+" start "+start+" end "+end+" mid "+mid+" x "+x);
			if(x >= q[mid]){
				start=mid+1;
			}else{
				end=mid;
			}
		}

		return start-1;
	}

	long solve(long q[], long r[], int n, long k){
		Arrays.sort(q);
		Arrays.sort(r);
		// System.out.println(Arrays.toString(q));
		int i=0, j=n-1;
		int count=0;

		while(i<n && j>=0){
			long x=(k-r[i])/(r[i]+1);
			// System.out.println("x "+x+" k "+k+" r[i] "+r[i]+" i "+i+" j "+j);

			int index=ubM1(q, 0, j+1, x);
			// System.out.println(" idex "+ index);

			if(index==-1){
				i++;
			}
			else{
				i++;
				j=index-1;
				count++;
			}

		}

		return count;

	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuotientAndRemainder o=new QuotientAndRemainder();
        
        // Read the number of test cases
        int t = sc.nextInt();
        
        // Process each test case
        while(t-- > 0) {
            int n = sc.nextInt();

            long k=sc.nextLong();

            long q[]=new long[n];
            long r[]=new long[n];

            for(int i=0;i<n;i++)q[i]=sc.nextLong();
            for(int i=0;i<n;i++)r[i]=sc.nextLong();


          	
          	System.out.println(o.solve(q, r, n, k));  
            
        }
        
        sc.close();
    }
    
}