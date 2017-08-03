import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int testCase = Integer.parseInt(br.readLine());
    	Stack stack = new Stack();
    	
    	for(int z = 0; z < testCase; z++) {
    		String str = br.readLine();
    		boolean flag = false;
    		
    		for(int i = 0; i < str.length(); i++) {
    			if(str.charAt(i) == '(')
    				stack.push('(');
    			else {
    				if(!stack.isEmpty())
    					stack.pop();
    				else {
    					flag = true;
    					break;
    				}
    			}
    		}
    		
    		if(!stack.isEmpty())
    			flag = true;
    		
    		if(flag)
    			System.out.println("NO");
    		else
    			System.out.println("YES");
    		
    		stack.clear();
    	}
    }
}