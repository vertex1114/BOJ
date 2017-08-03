import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MyQue<T>{
	Node first;
	Node last;
	int size;
	
	class Node<T>{
		Node next;
		Node previous;
		T data;
		
		Node(T data){
			next = null;
			previous = null;
			this.data = data;
		}
	}
	
	MyQue(){
		first = new Node(null);
		last = new Node(null);
		size = 0;
	}
	
	public void enQue(T data){
		Node newNode = new Node(data);
		size++;
		
		if(size == 1){
			first = newNode;
			last = newNode;
			first.next = last;
			first.previous= last;
			last.next = first;
			last.previous = first;
		}else{
			first.previous = newNode;
			newNode.next = first;
			first = newNode;
			first.previous = last;
			last.next = first;
		}
	}
	
	public void leftQue(){
		Node temp = first;
		first = temp.next;
		last = temp;
	}
	
	public T deQue(){
		Node temp = first;
		first = temp.next;
		first.previous = last;
		last.next = first;
		T data = (T)temp.data;
		temp = null;
		size--;
		return data;
	}
}

public class BOJ_1158 {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] s = br.readLine().split(" ");
    	int N = Integer.parseInt(s[0]);
    	int M = Integer.parseInt(s[1]);
    	MyQue<Integer> q = new MyQue<>();
    	
    	for(int i = N; i > 0; i--)
    		q.enQue(i);
    	
    	System.out.print("<");
    	while(q.size != 0){
    		for(int i = 1; i < M; i++)
    			q.leftQue();
    		
    		if(q.size == 1){
    			System.out.print(q.deQue() + ">");
    		}else
    			System.out.print(q.deQue() + ", ");
    	}
    }
}