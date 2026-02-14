        import java.io.*;
import java.util.*;
public class DeckCards {

    public static void main(String[] args) throws Exception {
        DeckCards o=new DeckCards();
        FastScanner sc = new FastScanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k=sc.nextInt();
            int a=0, b=0, c=0;
            
            char ch[]=sc.nextLine().strip().toCharArray();

            if(n==k){
                StringBuilder sb=new StringBuilder();
                for(int i=0;i<n;i++)sb.append("-");
                println(sb.toString());
                continue;
            }

            for(char i:ch){
                if(i=='0')a++;
                else if(i=='1')b++;
                else c++;
            }
            StringBuilder sb1=new StringBuilder();

            for(int i=0;i<a;i++)sb1.append("-");

            StringBuilder sb3=new StringBuilder();
            StringBuilder sb2=new StringBuilder();


            for(int i=0;i<b;i++)sb3.append("-");

            if(c==n-a-b){
                for(int i=0;i<c;i++)sb2.append("-");
            }else{

                int leftP=n-a-b;

                c=c*2;

                if(leftP-c<0){
                    for(int i=0;i<leftP;i++)sb2.append("?");

                }else{
                    for(int i=0;i<c/2;i++){
                        sb2.append("?");
                    }
                    for(int i=0;i<leftP-c;i++){
                        sb2.append("+");
                    }
                    for(int i=0;i<c/2;i++){
                        sb2.append("?");
                    }
                }
                



            }

            println(sb1.toString()+sb2.toString()+sb3.toString());


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
