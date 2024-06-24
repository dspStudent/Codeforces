import java.util.*;

public class CountSubmatricesWithAllOnes {
    public int[] leftMin(int a[]) {
        int n = a.length;
        int leftMin[] = new int[n];
        leftMin[0] = -1;
        int i = 0;
        Stack<Integer>st = new Stack<>();
        st.push(0);
        while (i < n) {
            while (!st.isEmpty() && a[st.peek()] >= a[i])st.pop();
            if (st.isEmpty())leftMin[i] = -1;
            else leftMin[i] = st.peek();
            st.push(i);
            i++;
        }
        return leftMin;
    }
    public int[] rightMin(int a[]) {
        int n = a.length;
        int rightMin[] = new int[n];
        rightMin[n - 1] = -1;
        int i = n - 2;
        Stack<Integer>st = new Stack<>();
        st.push(n - 1);
        while (i >= 0) {
            while (!st.isEmpty() && a[st.peek()] >= a[i])st.pop();
            if (st.isEmpty())rightMin[i] = -1;
            else rightMin[i] = st.peek();
            st.push(i);
            i--;
        }
        return rightMin;
    }
    public int[] leftMax(int a[]) {
        int n = a.length;
        int leftMax[] = new int[n];
        leftMax[0] = -1;
        int i = 0;
        Stack<Integer>st = new Stack<>();
        st.push(0);
        while (i < n) {
            while (!st.isEmpty() && a[st.peek()] <= a[i])st.pop();
            if (st.isEmpty())leftMax[i] = -1;
            else leftMax[i] = st.peek();
            st.push(i);
            i++;
        }
        return leftMax;
    }
    public int[] rightMax(int a[]) {
        int n = a.length;
        int rightMax[] = new int[n];
        rightMax[n - 1] = -1;
        int i = n - 2;
        Stack<Integer>st = new Stack<>();
        st.push(n - 1);
        while (i >= 0) {
            while (!st.isEmpty() && a[st.peek()] <= a[i])st.pop();
            if (st.isEmpty())rightMax[i] = -1;
            else rightMax[i] = st.peek();
            st.push(i);
            i--;
        }
        return rightMax;
    }
    private int ncr (int n, int c){
        return (n*(n-1)/2)*(c*(c-1)/2);
    }
    private int f(int []a) {
        int n = a.length, count = 0;
        int leftMin[] = leftMin(a);
        int rightMin[] = rightMin(a);
        System.out.println(Arrays.toString(leftMin));
        System.out.println(Arrays.toString(rightMin));
        int i=0;
        while (i<n) {
            if(a[i]==0){
                i++;continue;
            }
            int lMin = leftMin[i] + 1;
            int rMin = rightMin[i] == -1 ? n - 1 : rightMin[i] - 1;
            count += ncr(a[i]+1, rMin-lMin+1+1);
            
        }
        System.out.println(count);
        return count;
    }
    public int numSubmat(int[][] mat) {
        int n = mat.length, m = mat[0].length, count = 0;
        int a[] = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[j] = mat[i][j] == 0 ? 0 : a[j] + 1;
            }
            System.out.println(Arrays.toString(a));
            count += f(a);
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        // Removing the outer brackets
        input = input.substring(1, input.length() - 1);

        // Splitting the input string into rows
        String[] rows = input.split("\\],\\[");

        // Initializing the matrix based on the number of rows and columns
        int numRows = rows.length;
        int numCols = rows[0].split(",").length;
        int[][] mat = new int[numRows][numCols];

        // Parsing the rows
        for (int i = 0; i < numRows; i++) {
            rows[i] = rows[i].replace("[", "").replace("]", ""); // Removing any remaining brackets
            String[] elements = rows[i].split(",");
            for (int j = 0; j < numCols; j++) {
                mat[i][j] = Integer.parseInt(elements[j]);
            }
        }

        CountSubmatricesWithAllOnes mo = new CountSubmatricesWithAllOnes();
        int result = mo.numSubmat(mat);
        System.out.println("Number of submatrices: " + result);
    }
}

// [[1,0,1], 2
// [1,1,0],  4
// [1,1,0]]  7

// 3+

// [[0,1,1,0]    2 
// ,[0,1,1,1]    
// ,[1,1,1,0]]   



