        import java.io.*;
import java.util.*;
public class SetOfStrangers {

    public static void main(String[] args) throws Exception {
        SetOfStrangers o=new SetOfStrangers();
        FastScanner sc = new FastScanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int a[][]=new int[n][m];
            Map<Integer, Boolean> map=new HashMap<>();
            for(int i=0;i<n;i++)for(int j=0;j<m;j++){
            	a[i][j]=sc.nextInt();
            }

            for(int i=0;i<n;i++){
            	for(int j=0;j<m;j++){
            		int el=a[i][j];
            		if(map.containsKey(el) && map.get(el)){
            			continue;
            		}
            		map.put(el, false);
            		if(i+1<n){
            			if(el==a[i+1][j]){
            				map.put(el, true);
            				continue;
            			}
            		}

            		if(j+1<m){
            			if(el==a[i][j+1]){
            				map.put(el, true);
            				continue;

            			}
            		}

            		if(j-1>=0){
            			if(el==a[i][j-1]){
            				map.put(el, true);
            				continue;

            			}
            		}

            		if(i-1>=0){
            			if(el==a[i-1][j]){
            				map.put(el, true);
            				continue;

            			}
            		}
            	}

            }
            // if(map.size()==1){

            // }
            long ans=0;
            boolean anyOne=false;
            for(int i: map.keySet()){
            	if(map.get(i)){
            		anyOne=true;
            		ans+=2;
            	}else{
            		ans++;
            	}
            }

            println(anyOne? ans-2: ans-1);


            
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
