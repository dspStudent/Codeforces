        import java.io.*;
import java.util.*;
public class MoveEnd {

    public static void main(String[] args) throws Exception {
        MoveEnd o=new MoveEnd();
        FastScanner sc = new FastScanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[]=new int[n];
            PriorityQueue<int[]> pq=new PriorityQueue<>((x, y)-> y[0]-x[0]);

            long pref[]=new long[n];

            for(int i=0;i<n;i++){

            	a[i]=sc.nextInt();
            	if(i==0){
            		pref[0]=a[0];
            	}else{
            		pref[i]=pref[i-1]+a[i];
            	}

            	pq.add(new int[]{a[i], i});
            }

            int start[]=pq.poll();

            long sum=start[0];

            Set<Integer> set=new HashSet<>();
            set.add(start[1]);

            int ig=start[1];

            long prev=sum;
            set.add(n-1);

            print(start[0]+" ");

            // while(true){

        	for(int i=n-2;i>=0;i--){

        		if(start[1]==i){
                    // sum=0;
        			prev=(pref[n-1]-(i==0?0:pref[i-1]));
        			print(prev+" ");
        		}
        		else if(i>start[1]){
        			set.add(i);
        			prev=((pref[n-1]-pref[i])+sum);
        			print(prev+" ");
        		}else{
        			while(!pq.isEmpty()){
        				start=pq.poll();
        				if(set.contains(start[1])){
        					continue;
        				}
        				else{
        					set.add(start[1]);
        					break;
        				}
        			}
                    set.add(i);
        			sum=start[0];
        			prev=sum+prev;
        			print(prev+" ");
        		}
        	}

        	println("");

            // }

            
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
