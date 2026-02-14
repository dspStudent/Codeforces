        import java.io.*;
import java.util.*;
public class Digits {

	static long fact[]=new long [11];

	Digits(){
		fact[0]=1;
		for(int i=1;i<=10;i++){
			fact[i]=1L*fact[i-1]*i;
		}

		// println(Arrays.toString(fact));
	}
    public static void main(String[] args) throws Exception {
        Digits o=new Digits();
        FastScanner sc = new FastScanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int d=sc.nextInt();
            print(1+" ");

            if(n>=3 || d%3==0)print(3+" ");

            if(d==5)print(5+" ");

            int seen=1;

            long dig=d;
            long rem=0;
            int k=0;

            while(true){
            	k++;
            	rem=dig%7;
            	if(((seen&(1<<(rem))) >> rem)==1){
            		break;
            	}
            	
            	seen=seen | 1<<(rem);
            	// System.out.println(Integer.toBinaryString(seen) +" "+rem+" "+dig);
            	dig=1L*dig*10 + d;
            }
            // println("k "+k+" "+fact[n]);

            if(rem==0){
            	if(n<=k){
            		if(fact[n]%k==0){
            			print(7+" ");
            		}
            	}else{
            		print(7+" ");
            	}
            }

             seen=1;

             dig=d;
             rem=0;
             k=0;

            while(true){
            	k++;

            	rem=dig%9;
            	if(((seen&(1<<(rem)))>>rem)==1){
            		            	            	// System.out.println(Integer.toBinaryString(seen) +" "+rem+" "+dig);

            		break;
            	}
            	seen=seen | 1<<(rem);
            	            	// System.out.println(Integer.toBinaryString(seen) +" "+rem+" "+dig);

            	dig=1L*dig*10 + d;
            }

            // println(k+" ");

            if(rem==0){
            	if(n<=k){
            		if(fact[n]%k==0){
            			print(9+" ");
            		}
            	}else{
            		print(9+" ");
            	}
            }


            println("");
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
