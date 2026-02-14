        import java.io.*;
import java.util.*;
public class MEXReordering {

    public static void main(String[] args) throws Exception {
        MEXReordering o=new MEXReordering();
        FastScanner sc = new FastScanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[]=new int[n];
            boolean ans=false;
            for(int i=0;i<n;i++){
            	a[i]=sc.nextInt();
            	if(a[i]==0){
            		ans=true;
            	}
            }

            if(!ans){
            	println("no");
            	continue;
            }

            Arrays.sort(a);
            
            for(int i=1;i<n;i++){
            	int leftMex=0, rightMex=0;
            	HashSet <Integer> lset=new HashSet<>();
            	for(int j=0;j<i;j++){
            		lset.add(a[j]);
            	}

            	HashSet <Integer> rset=new HashSet<>();
            	for(int j=i;j<n;j++){
            		rset.add(a[j]);
            	}

            	for(int it=0;it<=100;it++){
            		if(!lset.contains(it)){
            			leftMex=it;
            			break;
            		}
            	}

            	for(int it=0;it<=100;it++){
            		if(!rset.contains(it)){
            			rightMex=it;
            			break;
            		}
            	}
            	if(leftMex==rightMex){
            		ans=false;
            		break;
            	}
            }
            println(ans?"yes":"no");
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
