import java.util.*;

public class SakurakoKosukeAndThePermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SakurakoKosukeAndThePermutation o=new SakurakoKosukeAndThePermutation();
        
        // Read the number of test cases
        int t = sc.nextInt();
        
        // Process each test case
        while(t-- > 0) {
            int n = sc.nextInt();

            int a[]=new int[n+1];
            for(int i=1;i<=n;i++)a[i]=sc.nextInt();

            int vis[]=new int[n+1];

            int i=1, ans=0;
            while(i<=n){
            	if(vis[i]==-1){
            		i++;
            		continue;
            	}

            	int j=a[i], len=0;
            	vis[i]=-1;
            	while(j<=n){
            		len++;
            		if(vis[j]==-1){
            			break;
            		}
            		vis[j]=-1;
            		j=a[j];
            	}
            	ans+=(len-1)/2;
            	i++;
            }
            System.out.println(ans);
            
        }
        
        sc.close();
    }
    
   
}