        import java.io.*;
import java.util.*;
public class ArrayColoring {

    public static void main(String[] args) throws Exception {
        ArrayColoring o=new ArrayColoring();
        FastScanner sc = new FastScanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            // List<int[]> a=new ArrayList<>();
            // for(int i=0;i<n;i++){
            // 	int f=sc.nextInt();
            // 	int s=i%2;
            // 	a.add(new int[]{f , s});
            // }

            // Collections.sort(a, (x, y)->x[0]-y[0]);
            boolean ans=true;
            // for(int i=1;i<n;i++){
            // 	if(a.get(i-1)[1]==a.get(i)[1]){
            // 		ans=false;
            // 		break;
            // 	}
            // }
            int prev=sc.nextInt();
            for(int i=1;i<n;i++){
            	int cur=sc.nextInt();
            	if(prev%2==cur%2 && ans){
            		ans=false;
            	}
            	prev=cur;
            }
            println(ans? "yes":"no");
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
