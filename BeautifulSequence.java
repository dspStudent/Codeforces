        import java.io.*;
import java.util.*;
public class BeautifulSequence {

	static int mod=998244353;

	static int pow2(int a, int b){
		if(b==0)return 1;

		if(b%2==0){
			int mul=pow2(a, b/2);
			return (int)(1L*mul * mul%mod );
		}

		int mul=pow2(a, (b-1)/2);

		int temp=(int)(1L*mul*mul%mod);

		return (int)(1L*temp*a%mod);

	}
	// 	static int pow2(int a, int b) {
	//     long res = 1;
	//     long base = a;

	//     while (b > 0) {
	//         if ((b & 1) == 1) res = res * base % mod;
	//         base = base * base % mod;
	//         b >>= 1;
	//     }
	//     return (int) res;
	// }



    public static void main(String[] args) throws Exception {
        BeautifulSequence o=new BeautifulSequence();
        FastScanner sc = new FastScanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[]=new int[n];
            int pref[]=new int[n];

            List<Integer> three=new ArrayList<>();
            List<Integer> one=new ArrayList<>();


            for(int i=0;i<n;i++){
            	a[i]=sc.nextInt();

            	if(i==0){
            		pref[0]=a[0]==2?1:0;
            	}else{
            		pref[i]=(a[i]==2?1:0)+pref[i-1];
            	}

            	if(a[i]==3)three.add(i);
            	else if (a[i]==1)one.add(i);
            }

            int sum=0;

            for(int i:three){
            	sum=(sum+pow2(2, pref[i]))%mod;
            }

            // println("sum "+sum);
            // println("one "+one.toString());
            // println("three "+three.toString());



            int j=0;
            long ans=0;

            for(int i:one){
            	while( j<three.size()&& three.get(j)-i<2){
            		sum=((sum-pow2(2, pref[three.get(j)]))%mod + mod)%mod;
            		j++;
            	}
            	int os=pow2(2,pref[i]);

            	int div=(int)(1L*sum*1L*pow2(os, mod-2)%mod);

            	// println("pow "+ pow2(os, mod-2) );

            	ans= ((ans + div - (three.size()-1 -j+1) )%mod +mod)%mod;

            	// println(i+" "+j+" "+os+" "+sum+" "+ans+" "+div);

            }

            println(ans);
            
            

            // println(ans);
            
        }
        flush();
    }

   // -------- FAST INPUT --------
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        byte[] nextBytes() throws IOException {
            int c;
            do {
                c = readByte();
            } while (c <= ' ');

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            while (c > ' ') {
                out.write(c);
                c = readByte();
            }
            return out.toByteArray();
        }

        String next() throws IOException {
            byte[] b = nextBytes();
            return new String(b);   // ASCII input assumed (CP standard)
        }

        byte[] nextLineBytes() throws IOException {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int c;

            // consume any previous newline
            while (true) {
                c = readByte();
                if (c == -1 || c != '\n') break;
            }

            while (c != -1 && c != '\n') {
                out.write(c);
                c = readByte();
            }

            return out.toByteArray();
        }

        String nextLine() throws IOException {
            byte[] b = nextLineBytes();
            return new String(b);
        }


        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do {
                c = readByte();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = readByte();
            }

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }

        long nextLong() throws IOException {
            int c, sign = 1;
            long val = 0;
            do {
                c = readByte();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = readByte();
            }

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    // -------- FAST OUTPUT --------
    static final StringBuilder sb = new StringBuilder();
    static final BufferedOutputStream out = new BufferedOutputStream(System.out);

    static void print(int x) {
        sb.append(x);
    }

    static void println(int x) {
        sb.append(x).append('\n');
    }

    static void print(long x) {
        sb.append(x);
    }

    static void println(long x) {
        sb.append(x).append('\n');
    }

    static void print(double x) {
        sb.append(x);
    }

    static void println(double x) {
        sb.append(x).append('\n');
    }

    static void print(String s) {
        sb.append(s);
    }

    static void println(String s) {
        sb.append(s).append('\n');
    }

    static void flush() throws IOException {
        out.write(sb.toString().getBytes());
        out.flush();
        sb.setLength(0);
    }

    // -------- USAGE --------

}
