        import java.io.*;
import java.util.*;
public class CountGoodNumbers {

    public static void main(String[] args) throws Exception {
        CountGoodNumbers o=new CountGoodNumbers();
        FastScanner sc = new FastScanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            long l = sc.nextLong();
            long r = sc.nextLong();

            int cop=2*3*5*7;

            int count=(2-1)*(3-1)*(5-1)*(7-1);

            long countRComplete=r/cop;

            long countLComplete=(l-1)/cop;
            

            long ansL=0;
            long ansR=0;


            for(long i=countLComplete*cop ; i<l;i++){
            	if(i%2!=0 && i%3!=0 && i%5!=0 && i%7!=0)ansL++;
            }

            for(long i=countRComplete*cop ;i<=r;i++){
            	if(i%2!=0 && i%3!=0 && i%5!=0 && i%7!=0)ansR++;
            }

            long ans=(countRComplete-countLComplete)* count + (ansR-ansL);

            println(ans);

            
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
