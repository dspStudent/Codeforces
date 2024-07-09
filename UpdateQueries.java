import java.io.*;
import java.util.*;
public class UpdateQueries {
	private String solve(String s, int a[], char c[]){
		int n=a.length;
		StringBuilder sb=new StringBuilder(s);
		Arrays.sort(a);
		Arrays.sort(c);
		int start=0, end=n-1;
		while(start<end){
			a[start]=a[start] ^ a[end];
			a[end]=a[start] ^ a[end];
			a[start]=a[start] ^ a[end];

			char t=c[end];
			c[end]=c[start];
			c[start]=t;

			start++;end--;

		}
		for(int i=0;i<n;i++){
			sb.setCharAt(a[i]-1, c[i]);
		}
		return sb.toString();
	}
    public static void main(String[] args) throws IOException{ 
     	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder op=new StringBuilder();
        while(t-- > 0) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken()), m=Integer.parseInt(st.nextToken());
            String s=br.readLine().trim();
            int a[]=new int[m];
            
            st=new StringTokenizer(br.readLine());
            char []c=br.readLine().toCharArray();

            for(int i=0;i<m;i++){
            	a[i]=Integer.parseInt(st.nextToken());
            }
            UpdateQueries o=new UpdateQueries();
            op.append(o.solve(s, a, c)).append("\n");
        }
        System.out.println(op);
    }
}


