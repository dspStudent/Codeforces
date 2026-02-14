import java.util.*;

public class ShiftedMEX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of test cases
        int t = sc.nextInt();
        
        // Process each test case
        while(t-- > 0) {
            int n = sc.nextInt();
            List<Integer> a=new ArrayList<>();

            Set<Integer> set=new HashSet<>();

            for(int i=0;i<n;i++){
            	int el=sc.nextInt();
            	if(!set.contains(el)){
            		a.add(el);
            		set.add(el);
            	}
            }

            Collections.sort(a);
            // System.out.println(a);

            int max=1;
            int i=0, j=1;

            while(j<a.size()){
            	if(Math.abs(a.get(j-1)-a.get(j))==1){
            		
            	}
            	else{
            		i=j;
            	}
            	max=Math.max(max, j-i+1);
            	j++;
            }

            System.out.println(max);
         }
        
        sc.close();
    }
    
    
}