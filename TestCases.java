import java.io.*;
import java.util.*;
public class TestCases {
    public static void main(String[] args) {
        int n=(int)20;
        StringBuilder op=new StringBuilder();
        long x=20*((long)1e9);
        // op.append(x).append("\n");
        // op.append(1<<20).append("\n");
        for(int i=0;i<20;i++){
            Random rd=new Random();
            int rand1=rd.nextInt((int)1, (int)1e9+1);
            // int rand2=rd.nextInt(2, 300001);
            // int rand3=rd.nextInt(0, 300001);
            op.append(rand1+" ");  
        }
        
        System.out.print(op);
    }
}