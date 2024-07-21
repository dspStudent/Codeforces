import java.io.*;
import java.util.*;

public class TestCases {
    public static void main(String[] args) {
        int numTestCases = 1;
        StringBuilder output = new StringBuilder();

        Random rd = new Random();
        
        for (int i = 0; i < numTestCases; i++) {
            // Randomly generate n, m, and k within the given constraints
            int n = (int)1e5;
            int m = rd.nextInt(1, (int)1e4+1);
            int k = rd.nextInt((int) 1e9 + 1);

            // Append n, m, and k to the output
            // output.append(n).append(" ").append(m).append(" ").append(k).append("\n");

            // Generate n integers for the desired apartment sizes
            // output.append("[");
            for (int j = 0; j < n; j++) {
                int a = rd.nextInt(1, (int) 1e4+1) ;
                // int b = rd.nextInt(1, (int) 1e9+1) ;

                output.append(a+" ");
            }
            // output.append("]");

            // // Generate m integers for the apartment sizes
            // for (int j = 0; j < m; j++) {
            //     int b = rd.nextInt((int) 1e9) + 1;
            //     output.append(b).append(" ");
            // }
            // output.append("\n");
        }

        // Print the generated test cases
        System.out.print(output);
    }
}
