        import java.io.*;
import java.util.*;
public class CollectingGame {

	static int ubM(long a[][], int start, int end, long k){
		while(start< end){
			int mid=start+(end-start)/2;

			if(k>=a[mid][0]){
				start=mid+1;
			}else{
				end=mid;
			}
		}

		return start-1;
	}

    public static void main(String[] args) throws Exception {
        CollectingGame o=new CollectingGame();
        FastScanner sc = new FastScanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            long a[][]=new long[n][2];

            long pref[]=new long[n];

            for(int i=0;i<n;i++){
            	a[i][0]=sc.nextLong();
            	a[i][1]=i;
            	
            }


			Arrays.sort(a, (x, y) -> Long.compare(x[0], y[0]));
			List<Long> arr=new ArrayList<>();

            for(int i=0;i<n;i++){
            	if(i==0){
            		pref[i]=a[i][0];
            	}else{
            		pref[i]=pref[i-1]+a[i][0];
            	}

            	arr.add(0L);
            }

            Map<Long,Long> map=new HashMap<>();

            for(int i=0;i<n;i++){
            	long score=a[0][0];
            	long sum=pref[i];
            	long ans=0;
            	int index=ubM(a, 0, n,sum);
            	
            	int prevIndex=index-1;
            	
            	while(index!=i && index!=n && prevIndex!=index){
            		prevIndex=index;
            		sum=pref[prevIndex];
            		index=ubM(a, 0, n, sum);
            	}
            	ans+=index;

            	// map.put(a[i][1], ans);
            	arr.set((int)a[i][1], ans);

            }

            for(int i=0;i<n;i++){
            	print(arr.get(i)+" ");
            }
            println("");

            // println(map+"");

            
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
