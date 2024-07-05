import java.io.*;
import java.util.*;
public class TrailingZeros {
	// final static long MOD=(long)1e9+7;
	private static long mathPow(long a, int b){
			long res=1L;
			while(b!=0){
				if((b&1)==1)res=(res * a);
				a=(a * a);
				b>>=1;
			}
			return res;
		}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), i=1;
		long x=5, x1=5, c=0;
		while(x<=n){
			c+=Math.floor(((double)(n)/(double)x));
			x=mathPow(x1, ++i);
		}
		System.out.println(c);
	}
}

