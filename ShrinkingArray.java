        import java.io.*;
import java.util.*;
public class ShrinkingArray {

    public static void main(String[] args) throws Exception {
        ShrinkingArray o=new ShrinkingArray();
        FastScanner sc = new FastScanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            int a[]=new int[n];

            for(int i=0;i<n;i++){
            	a[i]=sc.nextInt();
            }

            boolean ansPrint=false;
            
            for(int i=0;i<n-1;i++){
            	if(Math.abs(a[i]-a[i+1])<=1){
            		println("0");
            		ansPrint=true;
            		break;
            	}
            }

            if(ansPrint) continue;

            int ans=Integer.MAX_VALUE;

            for(int i=0;i<n;i++){
            	int count=1;
            	int maxL=0;
            	int minL=Integer.MAX_VALUE;
            	boolean found=false;
            	// forward
            	for(int j=i+1;j<n-1;j++){
            		maxL=Math.max(Math.max(a[j], a[j+1]), maxL);
            		minL=Math.min(Math.min(a[j], a[j+1]), minL);
            		if(!(a[i] >= minL && a[i]<=maxL)){
            			count++;
            		}else{
            			found=true;
            			break;
            		}
            	}

            		if(found)
            		ans=Math.min(ans, count);
            	
            	// backowrd
            	count=1;
            	maxL=0;
            	minL=Integer.MAX_VALUE;
            	found=false;

            	for(int j=i-1;j>0;j--){
            		maxL=Math.max(Math.max(a[j], a[j-1]), maxL);
            		minL=Math.min(Math.min(a[j], a[j-1]), minL);
            		if(!(a[i] >= minL && a[i]<=maxL)){
            			count++;
            		}else{
            			found=true;

            			break;
            		}
            	}

            	if(found)
            	ans=Math.min(ans, count);

            }

            println(ans==Integer.MAX_VALUE?-1:ans);
            
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
