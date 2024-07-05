import java.io.*;
import java.util.*;
public class TestCases {
    public static void main(String[] args) {
        int n=(int)1e5;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            Random rd=new Random();
            int rand1=rd.nextInt(1, 1<<17);
            int rand2=rd.nextInt(1<<30);
            sb.append(rand1+" "+rand2).append("\n");  
        }
        System.out.print(sb);
    }
}