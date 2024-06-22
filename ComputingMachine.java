import java.util.*;

public class ComputingMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the number of test cases
        int t = sc.nextInt();
        
        // Process each test case
        while(t-- > 0) {
        	//input
            int n = sc.nextInt();
 			char a[]=sc.next().toCharArray();
 			char b[]=sc.next().toCharArray();
            char a1[]=a.clone();
 			char b1[]=b.clone();
            int l=0, r=2;
            while(r<n && l<n){
            	if(a1[l]=='0' && a1[r]=='0')b1[r-1]='1';
            	if(b1[l]=='1' && b1[l]=='1')a1[r-1]='1';
            	r++;l++;
            }
            System.out.println(Arrays.toString(a1)+" "+Arrays.toString(b1));
            
            int q=sc.nextInt();
            while(q-- >0){
            	int start=sc.nextInt()-1;
            	int end=sc.nextInt()-1;
            	int count=0;
            	// System.out.println(start+" "+end);
            	if(start>=1 && start<n-1){
            		if((start>=2 && start<n-2 && a[start]=='0' 
            		            			&& a[start-2]=='0' && a[start+2]=='0')){
            			// System.out.println("yes");
            			count--;
            		}
            		else if(a[start]!='1' && (b[start-1]=='1' && b[start+1]=='1')){
            			count--;
            		}
            		else if((a[start-1]!='1' && (a[start-1]=='0' && a[start+1]=='0') && start>=2 && b[start-2]=='1'))
            			count--;
            	}
            	if(end>=1 && end<n-1){
            		if((end>=2 && end<n-2 && a[end]=='0' 
            		            			&& a[end-2]=='0' && a[end+2]=='0')){
            			// System.out.println("yes");
            			count--;
            		}
            		else if(a[end]!='1' && (b[end-1]=='1' && b[end+1]=='1')){
            			count--;
            		}
            		else if((a[end-1]!='1' && (a[end-1]=='0' && a[end+1]=='0') && end>=2 && b[end-2]=='1'))
            			count--;
            	}
            	boolean ob=false;
            	if((end-start+1)%2!=0){
            		ob=true;
            	}
            	while(start < end){
            		if(a1[start]=='1'){
            			count++;
            		}
            		if(a1[end]=='1'){
            			count++;
            		}
            		start++;
            		end--;
            	}
            	if(ob && a1[start]=='1')count++;
            	System.out.println(count);
            }
        }
        
        sc.close();
    }
    
   
}


// 1 1 1 1
// 0 0 0 0

