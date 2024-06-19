import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class TestClass {
    public static double f(double x1, double y1, double x2, double y2, int v1) {
        double dis = Math.sqrt(((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)));
        return dis / v1;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            double start = -1e9, end = 1e9;
            while (end - start > 1e-7) {
                double mid1 = start + (end - start) / 3;
                double mid2 = end - (end - start) / 3;
                double left = f(x1, y1, mid1, y2, v1);
                double right = f(x1, y1, mid2, y2, v1);
                if (left > right) {
                    start = mid1;
                } else {
                    end = mid2;
                }
            }

            double dis = f(x1, y1, end, 0, v1) + f(end, 0, x2, y2, v2);
            System.out.println(String.format("%.5f", dis));
        }
    }
}
