import java.io.*;
import java.util.*;
public class HaveYourCakeAndEatItToo {
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder op=new StringBuilder();
    public static StringTokenizer st;

    private String solve(String a[], String b[], String c[], long part){
    	int n=a.length, ai=0, aj=-1, bi=-1, bj=-1, ci=-1, cj=-1;
    	long aSum=0, bSum=0, cSum=0;
    	for(int i=ai;i<n;i++){
    		aSum+=sToInt(a[i]);
    		if(aSum>=part){
    			aj=i;
    			break;
    		}
    	}
    	if(aj==-1)return "false";
    	bi=aj+1;
    	for(int i=bi;i<n;i++){
    		bSum+=sToInt(b[i]);
    		if(bSum>=part){
    			bj=i;break;
    		}
    	}
    	if(bj==-1)return "false";
    	ci=bj+1;
    	for(int i=ci;i<n;i++){
    		cSum+=sToInt(c[i]);
    		if(cSum>=part){
    			cj=i;break;
    		}
    	}
    	if(cj==-1)return "false";
    	return "true"+(ai+1)+" "+(aj+1)+" "+(bi+1)+" "+(bj+1)+" "+(ci+1)+" "+(cj+1);
    }

    public void run(String a[], String b[], String c[], long part){
    	String aString=solve(a, b, c, part);
    	if(aString.startsWith("true")){
    		op.append(aString.substring(4)).append("\n");
    		return;
    		

    	}

    	aString=solve(b, c, a, part);

    	if(aString.startsWith("true")){
    		String ans[]=aString.substring(4).split(" ");
    		String a1=ans[0]+" "+ans[1];
    		String a2=ans[2]+" "+ans[3];
    		String a3=ans[4]+" "+ans[5];
    		op.append(a3+" "+a1+" "+a2).append("\n");
    		return;
    	}

    	aString=solve(c, a, b, part);
    	if(aString.startsWith("true")){
    		String ans[]=aString.substring(4).split(" ");
    		String a1=ans[0]+" "+ans[1];
    		String a2=ans[2]+" "+ans[3];
    		String a3=ans[4]+" "+ans[5];
    		op.append(a2+" "+a3+" "+a1).append("\n");
    		return;
    	}

    	aString=solve(b, a, c, part);
    	if(aString.startsWith("true")){
    		String ans[]=aString.substring(4).split(" ");
    		String a1=ans[0]+" "+ans[1];
    		String a2=ans[2]+" "+ans[3];
    		String a3=ans[4]+" "+ans[5];
    		op.append(a2+" "+a1+" "+a3).append("\n");
    		return;
    	}

    	aString=solve(a, c, b, part);
    	if(aString.startsWith("true")){
    		String ans[]=aString.substring(4).split(" ");
    		String a1=ans[0]+" "+ans[1];
    		String a2=ans[2]+" "+ans[3];
    		String a3=ans[4]+" "+ans[5];
    		op.append(a1+" "+a3+" "+a2).append("\n");
    		return;
    	}

    	aString=solve(c, b, a, part);
    	if(aString.startsWith("true")){
    		String ans[]=aString.substring(4).split(" ");
    		String a1=ans[0]+" "+ans[1];
    		String a2=ans[2]+" "+ans[3];
    		String a3=ans[4]+" "+ans[5];
    		op.append(a3+" "+a2+" "+a1).append("\n");
    		return;
    	}

    	op.append(-1).append("\n");

    }
    public static void main(String[] args) throws IOException{ 
        int t = Integer.parseInt(br.readLine());
        HaveYourCakeAndEatItToo o=new HaveYourCakeAndEatItToo();
        while(t-- > 0) {
        	int n=Integer.parseInt(br.readLine());
            String a[]=br.readLine().split(" ");
            String b[]=br.readLine().split(" ");
            String c[]=br.readLine().split(" ");
            double sum=Arrays.stream(a).mapToDouble(i->Double.parseDouble(i)).sum();
            long part=(long)Math.ceil(sum/3.0);
           	o.run(a, b, c, part);
        }
        System.out.println(op);
    }

    public static char str(String s, int i){
    	return s.charAt(i);
    } 
    public static int sToInt(String s){
    	return Integer.parseInt(s);
    }
    public static long sToLong(String s){
    	return Long.parseLong(s);
    }
    public static int sToInt(char c){
    	return Integer.parseInt(c+"");
    }
    public static long sToLong(char c){
    	return Long.parseLong(c+"");
    }
}