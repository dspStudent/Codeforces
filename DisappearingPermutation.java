        import java.io.*;
import java.util.*;
public class DisappearingPermutation {

	static void dfs(int node, List<Integer> adj[], Stack<Integer> st, boolean vis[]){

		vis[node]=true;
		st.push(node);
		for(int child: adj[node]){
			if(!vis[child]){
				dfs(child, adj, st, vis);
			}
		}

	}

    public static void main(String[] args) throws Exception {
        DisappearingPermutation o=new DisappearingPermutation();
        FastScanner sc = new FastScanner();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[]=new int[n+1];

            List<Integer> adj[]=new ArrayList[n+1];

            for(int i=0;i<=n;i++)adj[i]=(new ArrayList<>());

            int p[]=new int[n];
            int d[]=new int[n];

            for(int i=0;i<n;i++)p[i]=sc.nextInt();
            for(int i=0;i<n;i++)d[i]=sc.nextInt();

            for(int i=0;i<n;i++){
            	adj[i+1].add(p[i]);
            	adj[p[i]].add(i+1);
            }

            boolean vis[]=new boolean[n+1];

            Stack<Integer> st=new Stack<>();
            Map<Integer, Integer> map=new HashMap<>();
            int comp=1;

            for(int i=1;i<=n;i++){
            	if(!vis[i]){
            	            	dfs(i, adj, st, vis);
            	
            	            	// int size=st.size();
            	
            	            	map.put(comp, st.size());
            	
            	            	while(!st.isEmpty()){
            	            		a[st.pop()]=comp;
            	            	}
            	
            	            	comp++;}
            }

            Set<Integer> set=new HashSet<>();

            int ans[]=new int[n];


            for(int i=0;i<n;i++){
            	int x=a[d[i]];

            	// println("i "+i+" x "+x);
            	if(set.contains(x)){
            		// println("i "+i);
            		ans[i]=ans[i-1];
            		// println(a[i]);
            	}else{
            		ans[i]=(i==0?0:ans[i-1])+map.get(x);
            		set.add(x);
            	}

            	print(ans[i]+" ");

            }

            println("");


            // println("a -> "+Arrays.toString(a));
            // println("map -> "+map);

            // println("ans -> "+Arrays.toString(ans));


            

            
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
