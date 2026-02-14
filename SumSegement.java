        import java.io.*;
import java.util.*;
public class SumSegement {

    public static void main(String[] args) throws Exception {
        SumSegement o=new SumSegement();
        FastScanner sc = new FastScanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[]=new int[n];
            int pref[]=new int[n];
            int pos=n;
            for(int i=0;i<n;i++){
            	a[i]=sc.nextInt();
            	if(a[i]!=-1 && a[i]!=1){
            		pos=i;
            	}
            	if(i==0){
            		pref[i]=a[i];
            	}else{
            		pref[i]=pref[i-1]+a[i];
            	}
            }

            int leftMin=0;
            int leftMax=0;

            // leftMin
            int sum=0;
            for(int i=0;i<pos;i++){
            	sum+=a[i];
            	leftMin=Math.min(leftMin, sum);
            	if(sum>0)sum=0;
            }

            sum=0;
            for(int i=0;i<pos;i++){
            	sum+=a[i];
            	leftMax=Math.max(leftMax, sum);
            	if(sum<0)sum=0;
            }

            int rightMin=0;
            int rightMax=0;

            // leftMin
             sum=0;
            for(int i=pos+1;i<n;i++){
            	sum+=a[i];
            	rightMin=Math.min(rightMin, sum);
            	if(sum>0)sum=0;
            }

            sum=0;
            for(int i=pos+1;i<n;i++){
            	sum+=a[i];
            	rightMax=Math.max(rightMax, sum);
            	if(sum<0)sum=0;
            }

            TreeSet<Integer> set=new TreeSet<>();

            for(int i=Math.min(leftMin, rightMin);i<= Math.max(rightMax, leftMax);i++){
            	set.add(i);
            }

            if(pos==n){
            	println(set.size());
            for(int i:set)print(i+" ");
            println("");
            continue;
            } 	
            int msn=a[pos], msx=a[pos];
            int mpn=a[pos], mpx=a[pos];

            if(pos!=n)
            for(int i=0;i<n;i++){
            	if(i>pos){
            		mpx=Math.max(pref[i]-(pos==0?0:pref[pos-1]), mpx);
            		mpn=Math.min(pref[i]-(pos==0?0:pref[pos-1]), mpn);
            	}else if(i<pos){
            		msx=Math.max(pref[pos]-(i==0?0:pref[i-1]), msx);
            		msn=Math.min(pref[pos]-(i==0?0:pref[i-1]), msn);
            	}
            }

            int mn=Math.min(Math.min(msn, mpn), msn+mpn-a[pos]);
            int mx=Math.max(Math.max(msx, mpx), msx+mpx-a[pos]);

            // println(mx+" "+mn);

            for(int i=mn;i<=mx;i++){
            	set.add(i);
            }

            println(set.size());
            for(int i:set)print(i+" ");
            println("");
            
            // println(Arrays.toString(pref)+" "+pos);

            
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
