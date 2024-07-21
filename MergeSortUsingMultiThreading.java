import java.util.*;
import java.io.*;

public class MergeSortUsingMultiThreading implements Runnable {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder op = new StringBuilder();
	public static StringTokenizer st;
	int a[];
	int start;
	int end;

	MergeSortUsingMultiThreading(int a[], int start, int end) {
		this.a = a;
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {

		if (start >= end) {
			return;
		}
		int mid = start + (end - start) / 2;

		// Thread left = new Thread(new MergeSortUsingMultiThreading(a, start, mid));

		// Thread right = new Thread(new MergeSortUsingMultiThreading(a, mid + 1, end));

		java.util.concurrent.ExecutorService ex= java.util.concurrent.Executors.newCachedThreadPool();
		ex.execute(new MergeSortUsingMultiThreading(a, start, mid));
		ex.execute(new MergeSortUsingMultiThreading(a, mid + 1, end));

		ex.shutdown();
		
		// left.start();
		// right.start();

		// try {
		// 	left.join();
		// 	right.join();
		// } catch (Exception ex) {
		// 	System.out.println("at 31, 32");
		// }

		merge(a, start, mid, end);
		System.out.println(Thread.currentThread().getName() + Arrays.toString(a));
	}

	public void merge(int a[], int start, int mid, int end) {

		int left = start, right = mid + 1, it = 0;

		int arr[] = new int[end - start + 1];

		while (left <= mid && right <= end) {
			if (a[left] > a[right]) {
				arr[it] = a[right];
				right++;
			} else {
				arr[it] = a[left];
				left++;
			}
			it++;
		}

		while (left <= mid) {
			arr[it] = a[left];
			it++; left++;
		}

		while (right <= end) {
			arr[it] = a[right];
			it++; right++;
		}

		for (int i = start, j = 0; i <= end; i++, j++) {
			a[i] = arr[j];
		}

	}

	public static void main  (String[] args) throws IOException {

		int n = sToInt(br.readLine());
		int a[] = nextIntA(n);
		// Thread mainThread = new Thread(new MergeSortUsingMultiThreading(a, 0, n - 1));

		 java.util.concurrent.ExecutorService ex= java.util.concurrent.Executors.newCachedThreadPool();

		ex.execute(new MergeSortUsingMultiThreading(a, 0, n - 1));


		// mainThread.start();
		ex.shutdown();

		System.out.println(Arrays.toString(a));
	}

	public static int sToInt(String s) {
		return Integer.parseInt(s);
	}

	public static int[] nextIntA(int n)throws IOException {
		int a[] = new int[n];
		st = nst(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = sToInt(st.nextToken());
		}
		return a;
	}

	//StringTokenIzer
	public static StringTokenizer nst(String s) {
		return new StringTokenizer(s);
	}


}