import java.io.*;
import java.util.*;
public class BitStringCses {
	final static long MOD=(long)1e9+7;
	private long mathPow(long a, int b){
		long res=1L;
		while(b!=0){
			if((b&1)==1)res=(res%MOD * a%MOD)%MOD;
			a=(a%MOD * a%MOD)%MOD;
			b>>=1;
		}
		return res;
	}
    public static void main(String[] args) throws IOException{ 
     	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BitStringCses b=new BitStringCses();
        System.out.println(b.mathPow((long)2, n));
    }
}