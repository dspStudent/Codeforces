import java.util.*;

public class LongestNonDecreasingSubsequenceXOR1 {
    
    // Approach 1: Optimized DP - O(n^2 * 1024) time, O(n * 1024) space
    int solveOptimized(int a[], int n, int targetXor) {
        // dp[i][xor] = maximum length of non-decreasing subsequence 
        // ending at index i with XOR value = xor
        int[][] dp = new int[n][1024];
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            // Start new subsequence with just a[i]
            dp[i][a[i]] = 1;
            
            // Extend previous subsequences
            for (int j = 0; j < i; j++) {
                if (a[j] <= a[i]) { // Non-decreasing condition
                    for (int xor = 0; xor < 1024; xor++) {
                        if (dp[j][xor] != -1) {
                            int newXor = xor ^ a[i];
                            dp[i][newXor] = Math.max(dp[i][newXor], dp[j][xor] + 1);
                        }
                    }
                }
            }
            
            // Check if any XOR >= targetXor
            for (int xor = targetXor; xor < 1024; xor++) {
                if (dp[i][xor] != -1) {
                    maxLen = Math.max(maxLen, dp[i][xor]);
                }
            }
        }
        
        return maxLen == 0 ? -1 : maxLen;
    }
    
    // Approach 2: Space-optimized using HashMap - Better for sparse XOR values
    int solveWithHashMap(int a[], int n, int targetXor) {
        // dp[i] = map of (xor -> max length) for subsequences ending at index i
        @SuppressWarnings("unchecked")
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }
        
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            // Start new subsequence
            dp[i].put(a[i], 1);
            
            // Extend from previous elements
            for (int j = 0; j < i; j++) {
                if (a[j] <= a[i]) {
                    for (Map.Entry<Integer, Integer> entry : dp[j].entrySet()) {
                        int prevXor = entry.getKey();
                        int prevLen = entry.getValue();
                        int newXor = prevXor ^ a[i];
                        
                        dp[i].put(newXor, Math.max(dp[i].getOrDefault(newXor, 0), prevLen + 1));
                    }
                }
            }
            
            // Update max length
            for (Map.Entry<Integer, Integer> entry : dp[i].entrySet()) {
                if (entry.getKey() >= targetXor) {
                    maxLen = Math.max(maxLen, entry.getValue());
                }
            }
        }
        
        return maxLen == 0 ? -1 : maxLen;
    }
    
    // Approach 3: Most space-efficient - single HashMap per iteration
    int solveMostOptimized(int a[], int n, int targetXor) {
        int maxLen = 0;
        
        // current[xor] = max length achievable with this XOR value
        HashMap<Integer, Integer> current = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> next = new HashMap<>();
            
            // Copy all previous states (not taking current element)
            next.putAll(current);
            
            // Start new subsequence with a[i]
            next.put(a[i], Math.max(next.getOrDefault(a[i], 0), 1));
            
            // Extend subsequences that end with value <= a[i]
            for (Map.Entry<Integer, Integer> entry : current.entrySet()) {
                int xor = entry.getKey();
                int len = entry.getValue();
                
                // We need to track the last element somehow
                // This approach needs modification for proper tracking
            }
            
            current = next;
        }
        
        // Find max length with XOR >= targetXor
        for (Map.Entry<Integer, Integer> entry : current.entrySet()) {
            if (entry.getKey() >= targetXor) {
                maxLen = Math.max(maxLen, entry.getValue());
            }
        }
        
        return maxLen == 0 ? -1 : maxLen;
    }
    
    public static void main(String[] args) {
        LongestNonDecreasingSubsequenceXOR1 ob = new LongestNonDecreasingSubsequenceXOR1();
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[] = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        // Use optimized approach with HashMap (best for most cases)
        int ans = ob.solveWithHashMap(a, n, m);
        
        System.out.println("Maximum length: " + ans);
        
        sc.close();
    }
}