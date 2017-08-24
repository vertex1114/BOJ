import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10809 {
	public static void main(String[] args) {
		String s = null;
		
		try(BufferedReader br = new  BufferedReader(new InputStreamReader(System.in))){
			s = br.readLine();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		int[] alpha = new int[26];
		Arrays.fill(alpha, -1);
		
		for(int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 'a';
			
			if(alpha[index] == -1)
				alpha[index] = i;
		}
		
		for(int x : alpha)
			System.out.print(x + " ");
	}
}
