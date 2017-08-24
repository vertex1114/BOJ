import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2902 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		br.close();
		boolean flag = false;
		
		for(int i = 0; i < s.length(); i++) {
			if(i == 0)
				System.out.print(s.charAt(0));
			else if(s.charAt(i) == '-')
				flag = true;
			else if(flag) {
				System.out.print(s.charAt(i));
				flag = false;
			}
		}
	}
}
