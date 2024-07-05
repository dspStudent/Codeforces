import java.io.*;
import java.util.*;
public class QueriesOnAStringRotateCodeForces {
	public static String f(StringBuilder sb, int start , int end, int k){
		int i=start, j=end, mid=end-k;
		while(i<mid){
			char c=sb.charAt(i);
			sb.setCharAt(i, sb.charAt(mid));
			sb.setCharAt(mid, c);
			i++;mid--;
		}
		mid=end-(k-1);
		while(mid<j){
			char c=sb.charAt(mid);
			sb.setCharAt(mid, sb.charAt(j));
			sb.setCharAt(j, c);
			mid++;j--;
		}
		i=start; j=end;
		while(i<j){
			char c=sb.charAt(i);
			sb.setCharAt(i, sb.charAt(j));
			sb.setCharAt(j, c);
			i++;j--;
		}
		return sb.toString();
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine());
		StringBuffer out = new StringBuffer();
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1,
			    end = Integer.parseInt(st.nextToken())-1,
			    k = Integer.parseInt(st.nextToken());
			int len=end-start+1;
			k%=len;
			out.append(f(sb, start, end, k)).append("\n");
		}
		System.out.println(sb);
	}
}
