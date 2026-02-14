        import java.io.*;
import java.util.*;
public class BlackCells {

    public static void main(String[] args) throws Exception {
        BlackCells o=new BlackCells();
        FastScanner sc = new FastScanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long a[]=new long[n];

            for(int i=0;i<n;i++)a[i]=sc.nextLong();
            if(n==1){
            	println(1);
            	continue;
            }

            Arrays.sort(a);
            long min=0;
            if(n%2==0){
            	for(int i=1;i<n;i+=2){
            		min=Math.max(min, (long)(a[i]-a[i-1]));
            	}
            	println(min);
            	continue;
            }else{
            	
            	long ans=(long)1e18;

            	int ind=0;

            	long maxi=a[1]-a[0];

            	for(int i=2;i<n;i++){

            		if(a[i]-a[i-1] > maxi){
            			ind=i-1;	
            			maxi=a[i]-a[i-1];
            		}
            	}

            	// for(int i=0;i<n;i++){
            	// println(ind);

            	ind = ind%2==0? ind:ind+1;

            		long max=0;
            		int j=0, k=1;
            		while(k<n){
            			if(j==ind){
            				j++;
            				k++;
            				max=Math.max(max, 1);
            				continue;
            			}else{
            				max=Math.max(max, (long)(a[k]-a[j]));
            				j=k+1;
            				k=j+1;
            			}
            		}
            		ans=Math.min(ans, max);

            	// }

            	println(ans);
            }

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
