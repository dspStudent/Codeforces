import java.util.*;

public class JellyfishAndUndertale {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of test cases
        int t = sc.nextInt();
        
        // Process each test case
        while(t-- > 0) {
            long n = sc.nextLong();
            long c=sc.nextLong();
            int size=sc.nextInt();

            long a[]=new long[size];

            for(int i=0;i<size;i++)a[i]=sc.nextLong();

            Arrays.sort(a);

            long time= c - (c - (c-1));

            // i=0;

            for(int i=0;i<size;i++){
            	if(1+a[i] > n){
            		time+= n - (n- (n-1));
            	}
            	else{
            		a[i]++;
            		time+=a[i] - (a[i] - (a[i]-1));
            	}
            }

            
            System.out.println(time+=1);
        }
        
        sc.close();
    }
    
   
}