import java.io.*;
import java.util.*;
public class SEQSpoj {
    public static void main(String[] args) throws IOException{ 
     	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuffer out=new StringBuffer();
        while(t-- > 0) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int size=Integer.parseInt(st.nextToken());
            int b[]=new int[size];
            int c[]=new int[size];
            StringTokenizer sb=new StringTokenizer(br.readLine());
            StringTokenizer sc=new StringTokenizer(br.readLine());
            for (int i=0;i<size;i++) {
            	b[i]=Integer.parseInt(sb.nextToken());
            	c[i]=Integer.parseInt(sc.nextToken());
            }
           	int n=Integer.parseInt(br.readLine().trim());
           	if(n<=k)out.append(b[n-1]).append("\n");
           	
        }
        System.out.println(out);
    }
}

// ai = bi (for i <= k)
// ai = c1*ai-1 + c2*ai-2 + ... + ck*ai-k (for i > k)


//       ai-1       ai 
//       ai-2       
//       ai-3
//       ai-4
//       ai-5
//       ai-6
//       ai-7
//       ai-8
//       ai-9
//       ai-10


//      c1 c2 c3 c4 c5 c6 c7 c8 c9 c10
//      1 
//          1
//             1
//                1
//                   1
//                      1
//                         1
//                            1
//                              1  
//                                 1
