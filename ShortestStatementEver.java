import java.io.*;
import java.util.*;
public class ShortestStatementEver {

	static int p2[]=new int[33];
	static int p1[]=new int[33];


	ShortestStatementEver(){
		p2[0]=0;
		p1[0]=0;
		p2[1]=1;
		p1[1]=0;	
		for(int i=2;i<p2.length;i++){
			p2[i]=2*p2[i-1];
			p1[i]=p2[i]-1;
		}
	}

	int lb(int a[], int start, int end, int el){

		while(start< end){
			int mid= start+ (end-start)/2;
			if(el > a[mid]){
				start=mid+1;
			}else{
				end=mid;
			}
		}
		return start;
	}

	int ub(int a[], int start, int end, int el){
		// println(el);

		while(start< end){
			int mid= start+ (end-start)/2;
			if(el >= a[mid]){
				start=mid+1;
			}else{
				end=mid;
			}
		}
		return start;
	}

    public static void main(String[] args) throws Exception {
        ShortestStatementEver o=new ShortestStatementEver();
        FastScanner sc = new FastScanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            // int n = sc.nextInt();

            int x=sc.nextInt();
            int y=sc.nextInt();

            // p is power of 2
            // q is power of 2-1

            int fpl=o.lb(p2, 0, 33, x);
            int fql=o.lb(p1, 0, 33, y);
            // println("fp "+fpl+" fq "+fql+" x "+x+" y "+y+" p2fp "+p2[fpl]+" p1fp "+p1[fql]);

            int ansfl=Math.abs(p2[fpl]-x)+ Math.abs(p1[fql]-y);

            // println(ansfl);

            int fpu=o.ub(p2, 0, 33, x);
            int fqu=o.ub(p1, 0, 33, y);
            // println("fp "+fp+" fq "+fq+" x "+x+" y "+y+" p2fp "+p2[fp]+" p1fp "+p1[fq]);

            int ansfu=Math.abs(p2[fpu]-x)+ Math.abs(p1[fqu]-y);



            // q is power of 2
            // p is power of 2-1

            int spl=o.lb(p1, 0, 33, x);
            int sql=o.lb(p2, 0, 33, y);

            int anssl=Math.abs(p1[spl]-x)+ Math.abs(p2[sql]-y);

            int spu=o.ub(p1, 0, 33, x);
            int squ=o.ub(p2, 0, 33, y);

            int anssu=Math.abs(p1[spu]-x)+ Math.abs(p2[squ]-y);

            // println(Arrays.toString(p1));


            // if(ans > Math.abs(p1[spl]-x)+ Math.abs(p2[sql]-y)){
            // 	println(spl+" "+sql);
            // }else{
            // 	println(fpl+" "+fql);
            // }

           TreeMap<Integer, String> ans=new TreeMap<>((x1, y1)-> x1-y1);

           ans.put(ansfl, p2[fpl]+" "+p1[fql]);
           // ans.put(ansfu, p2[fpu]+" "+p1[fqu]);
           ans.put(anssl, p1[spl]+" "+p2[sql]);
           // ans.put(anssl, p1[spu]+" "+p2[squ]);

           println(ans.get(ans.firstKey()));
           // println(ans.toString());
           // println();




            
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
