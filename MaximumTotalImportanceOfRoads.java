import java.util.*;

public class MaximumTotalImportanceOfRoads {
	public long maximumImportance(int n, int[][] roads) {
        // Array to store the degree of each city
        int[] degree = new int[n];
        
        // Calculate the degree of each city
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }
        
        // Create a list of cities and sort by degree
        Integer[] cities = new Integer[n];
        for (int i = 0; i < n; i++) {
            cities[i] = i;
        }
        Arrays.sort(cities, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return Integer.compare(degree[b], degree[a]);
            }
        });
        
        // Assign values to cities starting from the highest degree
        long totalImportance = 0;
        for (int i = 0; i < n; i++) {
            totalImportance += (long) (n - i) * degree[cities[i]];
        }
        
        return totalImportance;
    }
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();


		int roadsCount = scanner.nextInt();


		int[][] roads = new int[roadsCount][2];

		for (int i = 0; i < roadsCount; i++) {
			roads[i][0] = scanner.nextInt();
			roads[i][1] = scanner.nextInt();
		}

		MaximumTotalImportanceOfRoads o=new MaximumTotalImportanceOfRoads();
		long result = o.maximumImportance(n, roads);
		System.out.println( result);
	}
}