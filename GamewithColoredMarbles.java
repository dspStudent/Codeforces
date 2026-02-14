        import java.io.*;
import java.util.*;
public class GamewithColoredMarbles {

    public static void main(String[] args) throws Exception {
        GamewithColoredMarbles o=new GamewithColoredMarbles();
        FastScanner sc = new FastScanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
           	Map<Integer, Integer> map=new HashMap<>();

           	for(int i=0;i<n;i++){
           		int el=sc.nextInt();
           		map.put(el, map.getOrDefault(el, 0)+1);
           	}

           	int ans=0;
           	int uni=0;

           	for(int i:map.keySet()){
           		if(map.get(i)==1)uni++;
           	}

           	ans=map.size()-uni;

           	ans+= 2*((uni+1)/2);

           	// TreeMap<Integer, Integer> tm=new TreeMap<>((x, y)-> {
           	// 	if(map.get(x)==map.get(y)){
           	// 		return y-x;
           	// 	}
           	// 	return map.get(x) -map.get(y);
           	// });

           	// tm.putAll(map);

           	// println(tm.toString());

           	// Map<Integer, Integer> a=new HashMap<>();

           	// int i=1;
           	// while(!tm.isEmpty()){
           	// 	println(i+" "+tm.toString());
           	// 	int key=tm.firstKey();

           	// 	if(i==1){
           	// 		a.put(key, a.getOrDefault(tm.get(key), 0)+1);
           	// 		i=i-1;
	        //    	}else{
	        //    		i=1;
	        //    	}

           	// 	if(tm.get(key)==1){
           	// 		tm.remove(key);
           	// 	}else{
           	// 		tm.put(key, tm.get(key)-1);
           	// 	}
           	// }

           	// long ans=a.size();
           	// println("ans"+a);

           	// for(int key:a.keySet()){
           	// 	if(a.get(key)==map.get(key)){
           	// 		ans++;
           	// 	}
           	// }

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
