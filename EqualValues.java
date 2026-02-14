        import java.io.*;
import java.util.*;
public class EqualValues {

    public static void main(String[] args) throws Exception {
        EqualValues o=new EqualValues();
        FastScanner sc = new FastScanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            List<int[]> a=new ArrayList<>();

            for(int i=0;i<n;i++){
            	int el=sc.nextInt();
            	if(a.isEmpty()){
            		a.add(new int[]{el,1});
            	}
            	else{
            		if(a.get(a.size()-1)[0]==el){
            			a.get(a.size()-1)[1]++;
            		}else{
            			a.add(new int[]{el, 1});
            		}
            	}
            }

            int lr[]=new int[a.size()];
            lr[0]=a.get(0)[1];

            for(int i=1;i<lr.length;i++){
            	lr[i]=lr[i-1]+a.get(i)[1];
            }

            int rl[]=new int[a.size()];
            rl[a.size()-1]=a.get(a.size()-1)[1];

            for(int i=a.size()-2;i>=0;i--){
            	rl[i]=rl[i+1]+a.get(i)[1];
            }

            long min=Long.MAX_VALUE;
            for(int i=0;i<a.size();i++){
            	int left=0;
            	if(i!=0){
            		left=lr[i-1];
            	}

            	int right=0;

            	if(i!=a.size()-1){
            		right=rl[i+1];
            	}

            	min=Math.min(((long)left+(long)right)*(a.get(i)[0]*1L), min);

            }

            println(min==Long.MAX_VALUE?0:min);

            
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
