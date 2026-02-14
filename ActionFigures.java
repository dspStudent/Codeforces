        import java.io.*;
import java.util.*;
public class ActionFigures {

	static boolean f(char c[], int k){

		Queue<Integer> q=new ArrayDeque<>();

		int n=c.length;

		// long total=1L*n*(n+1)/2;

		for(int i=c.length-1;i>=0;i--){
			if(k==0){
				return q.size()<=(i+1);
			}
			if(c[i]=='1'){
				// total-=(i+1);
				k--;
				q.add(i+1);
			}else{
				q.poll();
			}
		}

		return false;

	}

	static int lb(char c[], int start, int end){
		while(start < end){
			int mid=start+(end-start)/2;
					// println("start "+start+" end "+end+" k "+mid);

			if(f(c, mid)){
				start=mid+1;
			}else{
				end=mid;
			}
		}

		return start-1;
	}

    public static void main(String[] args) throws Exception {
        ActionFigures o=new ActionFigures();
        FastScanner sc = new FastScanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            long total=1L*n*(n+1L)/2L;

            char c[]=sc.nextLine().strip().toCharArray();

            // if(n==1){
            // 	println(1);
            // 	continue;
            // }

            // println("tot "+total);
            

            

            // for(int i=n-1;i>=0;i--){
            // 	if(c[i]=='1'){
            // 		if((q.size())*1L < (i+1)){
            // 			total-=(i+1);
            // 			q.add(i+1);
            // 		}
            // 		// else{
            // 		// 	q.poll();
            // 		// }
            // 	}else{
            // 		q.poll();
            // 	}
            // }

        int k=(lb(c, 1, n+1));


		// long total=1L*n*(n+1)/2;

		// println("after k "+k);

		for(int i=c.length-1;i>=0;i--){
			if(k==0){
				break;
			}
			if(c[i]=='1'){
				total-=(i+1);
				k--;
			}
		}
		println(total);

            
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
