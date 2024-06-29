import java.io.*;
import java.util.*;
public class NumberSpiral {
    public static void main(String[] args) throws IOException{ 
     	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        // Process each test case
        StringBuffer sb=new StringBuffer();
        while(t-- > 0) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            long n = Integer.parseInt(st.nextToken()), m=Integer.parseInt(st.nextToken()), ans=0L;
            if(n<=m){
            	if(m%2!=0){
            		ans=m*m - (n-1); 
            	}
            	else{
            		ans=(m-1)*(m-1)+1 +(n-1);
            	}
            }
            else {
            	if(n%2==0){
            		ans=n*n - (m-1);
            	}
            	else{
            		ans= (n-1)*(n-1) + 1+ (m-1);
            	}
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}