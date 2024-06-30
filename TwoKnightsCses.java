import java.io.*;
import java.util.*;
public class TwoKnightsCses {
    private long ncr(long n, long r) {
        return n * (n - 1) / 2;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Long.parseLong(br.readLine());
        StringBuffer out = new StringBuffer();
        TwoKnightsCses o = new TwoKnightsCses();
        for (long i = 1; i <= t; i++) {
            long ans = o.ncr(i * i, 2) - 2 * (2 * ((i - 1) * (i - 2)));
            out.append(ans).append("\n");
        }
        System.out.println(out);
    }
}