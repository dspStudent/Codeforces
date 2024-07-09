import java.io.*;
import java.util.*;
public class CornerTwist {
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder op=new StringBuilder();
    public static StringTokenizer st;

    private String run(char s[][], char d[][]){
    	int n=s.length, m=s[0].length;
    	for(int i=0;i<n-1;i++){
    		for(int j=0;j<m-1;j++){
    			if(s[i][j]==d[i][j])continue;
    			int x=s[i][j]-'0', y=d[i][j]-'0';
    			
    			int steps=x>y?y+3-x:y-x;
    			x=(x+steps)%3;
    			s[i][j]=(char)(x+'0');
    			int dx=s[i+1][j+1]-'0';
    			dx=(dx+steps)%3;
    			s[i+1][j+1]=(char)(dx+'0');

    			s[i+1][j]=(char)((s[i+1][j]-'0' +steps*2)%3+'0');
    			s[i][j+1]=(char)((s[i][j+1]-'0' +steps*2)%3+'0');
    		}
    	}
    	int size=Math.max(n, m);
    	for(int i=0;i<size;i++){
    		if(i<m){
    			if(s[n-1][i]!=d[n-1][i])return "no";
    		}
    		if(i<n){
    			if(s[i][m-1]!=d[i][m-1])return "no";
    		}
    	}
    	return "yes";
    }
    public static void main(String[] args) throws IOException{ 
        int t = Integer.parseInt(br.readLine());
        CornerTwist o=new CornerTwist();
        while(t-- > 0) {
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken()), m=Integer.parseInt(st.nextToken());
            char s[][]=new char[n][m];
            for(int i=0;i<n;i++){
            	s[i]=br.readLine().trim().toCharArray();
            }
            char d[][]=new char[n][m];
            for(int i=0;i<n;i++){
            	d[i]=br.readLine().trim().toCharArray();
            }
            op.append(o.run(s, d)).append("\n");
        }
        System.out.println(op);
    }
}




