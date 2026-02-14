        import java.io.*;

public class MakeItZero {

    public static void main(String[] args) throws Exception {
        MakeItZero o=new MakeItZero();
        FastScanner sc = new FastScanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();


            int a[]=new int[n];

            int xor=0;

            for(int i=0;i<n;i++){

            	a[i]=sc.nextInt();
            	// xor^=a[i];

            }

            int l=0, r=n-1;

            // while(l<=r){
            // 	if(a[l]==0){
            // 		l++;
            // 	}

            // 	if(a[r]==0){
            // 		r--;
            // 	}

            // 	if(a[l]!=0 && a[r]!=0)break;
            // }

            // n=r-l+1;
            // System.out.println(n+" "+l+" "+r);
            if(n<=0){
            	println(0);
            }else if(n%2==0){
            	println(2);
            	println((l+1)+" "+(r+1));
            	println((l+1)+" "+(r+1));
            }
            else{
            	println(4);
            	println((l+2)+" "+(r+1));
            	println((l+2)+" "+(r+1));
            	println((l+1)+" "+(r));
            	println((l+1)+" "+(r));

            }



            
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
