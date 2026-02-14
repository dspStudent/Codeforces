        import java.io.*;
import java.util.*;
public class NewYearCake {

	int twoPow[]=new int[21];

	NewYearCake(){
		twoPow[0]=1;
		for(int i=1;i<21;i++){
			twoPow[i]=2*twoPow[i-1];
		}
	}
    public static void main(String[] args) throws Exception {
        NewYearCake o=new NewYearCake();
        FastScanner sc = new FastScanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            // int n = sc.nextInt();
            int x=sc.nextInt();
            int y=sc.nextInt();

            int a=x;
            int b=y;
            // println(Arrays.toString(o.twoPow));
            int abCount=0;
            // a first, b second
            for(int i=0;i<=20;i++){
            	// println("i "+i+" to "+o.twoPow[i]+" "+a+" "+b);
            	if(i%2==0){
            		if(a-o.twoPow[i]<0)break;

            		a=a-o.twoPow[i];
            		
            	}else{
            		if(b-o.twoPow[i]<0)break;
            		b=b-o.twoPow[i];
            		// abCount++;
            	}
            	abCount++;

            }
            a=x;
            b=y;
            int baCount=0;
            // b first , a second
            for(int i=0;i<=20;i++){
            	// println("i "+i+" to "+o.twoPow[i]+" "+a+" "+b);
            	if(i%2==0){

            		if(b-o.twoPow[i]<0)break;
            		b=b-o.twoPow[i];
            	}else{
            		if(a-o.twoPow[i]<0)break;
            		a=a-o.twoPow[i];
            		// baCount++;
            	}
            	baCount++;

            }

            println(Math.max(abCount, baCount));
            
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
