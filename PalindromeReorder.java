import java.io.*;
import java.util.*;
public class PalindromeReorder {
	private String solve(String s) {
		int hash[] = new int[26];
		for (char c : s.toCharArray()) {
			hash[c - 'A']++;
		}
		int count = 0;
		char letter = '#';
		for (int i = 0; i < 26; i++) {
			if (count == 2)return "NO SOLUTION";
			if (hash[i] % 2 != 0) {
				letter = (char)('A' + i);
				count++;
			}
		}
		StringBuilder start = new StringBuilder(), end = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			if (i != letter - 'A') {
				start.append(((char)(i + 'A') + "").repeat(hash[i] / 2));
				end.append(((char)(i + 'A') + "").repeat(hash[i] / 2));
			}
		}
		if(letter!='#'){
			start.append((letter+"").repeat(hash[letter-'A']));
		}
		start.append(end.reverse());
		return start.toString();
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		PalindromeReorder o = new PalindromeReorder();
		System.out.println(o.solve(s));
	}
}