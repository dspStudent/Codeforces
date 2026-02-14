import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class TestBeautifulNumbersMT {

    static final int N = 6; // brute-safe
    static final int THREADS = Runtime.getRuntime().availableProcessors();
    static final AtomicBoolean FOUND = new AtomicBoolean(false);

    // ---------- BRUTE FORCE ----------
    static boolean isBeautifulBrute(int[] p, int m) {
        int n = p.length;
        for (int l = 0; l + m <= n; l++) {
            boolean[] seen = new boolean[m + 1];
            boolean ok = true;
            for (int i = l; i < l + m; i++) {
                if (p[i] < 1 || p[i] > m || seen[p[i]]) {
                    ok = false;
                    break;
                }
                seen[p[i]] = true;
            }
            if (ok) return true;
        }
        return false;
    }

    static String bruteSolve(int[] p) {
        int n = p.length;
        StringBuilder sb = new StringBuilder();
        for (int m = 1; m <= n; m++) {
            sb.append(isBeautifulBrute(p, m) ? '1' : '0');
        }
        return sb.toString();
    }

    // ---------- YOUR LOGIC (UNCHANGED) ----------
    static int getSum(int n) {
        return n * (n + 1) / 2;
    }

    static String yourSolve(int[] a) {
        int n = a.length;
        int[] pref = new int[n];
        pref[0] = a[0];

        Map<Integer, Integer> map = new HashMap<>();
        map.put(a[0], 0);

        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + a[i];
            map.put(a[i], i);
        }

        int[] ans = new int[n + 1];
        int i = 0, j = n - 1;

        while (i < j) {
            int len = j - i + 1;
            int pt1 = (i == 0) ? 0 : pref[i - 1];
            int pt2 = pref[j];

            if (getSum(len) == (pt2 - pt1)) {
                ans[len]++;
                int pos = map.get(len);
                if (Math.abs(pos - i) > Math.abs(pos - j)) {
                    j = pos - 1;
                } else {
                    i = pos + 1;
                }
            } else {
                if (i + 1 < n && len - 1 == a[i + 1]) {
                    j--;
                } else if (j - 1 >= 0 && len - 1 == a[j - 1]) {
                    i++;
                } else {
                    i++; // IMPORTANT: keep this
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append('1');
        for (int k = 2; k <= n; k++) sb.append(ans[k]);
        return sb.toString();
    }

    // ---------- RANDOM PERM ----------
    static int[] randomPermutation(Random rnd) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) list.add(i);
        Collections.shuffle(list, rnd);
        int[] p = new int[N];
        for (int i = 0; i < N; i++) p[i] = list.get(i);
        return p;
    }

    // ---------- WORKER ----------
    static class Worker implements Runnable {
        public void run() {
            Random rnd = new Random(Thread.currentThread().getId());
            while (!FOUND.get()) {
                int[] p = randomPermutation(rnd);
                String brute = bruteSolve(p);
                String yours = yourSolve(p);

                if (!brute.equals(yours)) {
                    if (FOUND.compareAndSet(false, true)) {
                        System.out.println("❌ FOUND FAILING TEST CASE");
                        System.out.println("p = " + Arrays.toString(p));
                        System.out.println("Brute : " + brute);
                        System.out.println("Yours : " + yours);
                    }
                    return;
                }
            }
        }
    }

    // ---------- MAIN ----------
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(THREADS);
        for (int i = 0; i < THREADS; i++) {
            pool.execute(new Worker());
        }
        pool.shutdown();
        pool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        System.out.println("✅ No failures found (so far)");
    }
}
