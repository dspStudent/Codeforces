import java.io.*;
import java.util.*;
public class TrickySum {
    public static void main(String[] args) throws IOException{ 
     	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuffer out=new StringBuffer();
        while(t-- > 0) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            long n=Long.parseLong(st.nextToken());
            long sum=n*(n+1L)/2L;
            for(int i=0;i<64;i++){
            	if((1<<i)>n)break;
            	sum-=2*(1<<i);
            }
            out.append(sum).append("\n");
        }
        System.out.println(out);
    }
}