import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StrangeOrder {
	

	public Node head = null; //Empty list
	
	public boolean isEmpty() {//Method Check if empty
		
		return head == null ? true : false;
	}//end methoh
	
	public int listSize() {//gets List size
		
		int counter = 1;
		Node temp = head;
		
		while(temp.next != null)
		{
			
			
			temp = temp.next;
			counter +=1;
		}
		
		return counter;
		
	}//end method
	
	
	public Node getNode(int index) {//Lineal Search in ths list
		
		if(listSize()<index) {
			return null;
		}else {
			
			Node temp = head;
			for (int i = 0; i < index; i++) {
				
				temp = temp.next;
				
			}
			
			return temp;
			
		}
		
	}//end method
	
	
	
	public void insertAtEnd(Node newNode) {//Method insert at end of the list
		
		if(isEmpty()) {			
			head = newNode;	
		}
		else{
			Node temp = head;

			while(temp.next != null) 

				temp = temp.next;
	
			temp.next = newNode;	
		}

	}//end method
	

	
	public int GCD (int num, int den) {
		
		if (num != 0){
			int gcd = 0;
			int resto = 0;
			
			do {	
				resto = num % den;
				num = den;
				
				if(resto != 0)
					den = resto;
			
				if(resto == 0)
					gcd = den;
				
			}while(resto != 0);
					
			return gcd;
		}
		
		return 1;		
	}
	

	public void deleteAtIndex(int index) {//method delete at index of the list
		
		Node temp ;
		Node pre = head;
		
		if(index != 0)
		{
			for(int i = 0; i < index-1; i++)
				pre = pre.next;
			
			temp = pre.next;
			pre.next = temp.next;
			temp = null;
			System.gc();
		}
		else
		{
			head = pre.next;
			pre = null;
			System.gc();//Call Garbaje collector (destructor)
		}
		
		
	}//end method


	public void printList() throws IOException {//Method that prints the contents of the list
	
	BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
	
	Node temp = head;
	
	while(temp != null) {
		
		bw.write(temp.toString()+"\n");
		temp = temp.next;
	}

	bw.flush();

	}//end method


	
	
	   public static void main(String args[] ) throws Exception {
	       
	      	StrangeOrder p = new StrangeOrder();
			StrangeOrder a = new StrangeOrder();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			try {
				
				int x = 0;
				int n = Integer.parseInt(br.readLine());
				
				for(int i = n; i > 0; i--)
					p.insertAtEnd(new Node(i));
				
				for(int i = 0; i < n; i++)
				{
					for(int j = 0; j < p.listSize(); j++)
					{
						if(p.getNode(j).Value > x)
						{
							x = p.getNode(j).Value;
							a.insertAtEnd(new Node(x));
							p.deleteAtIndex(j);
						}
						
						if(p.isEmpty())
							break;
					
					}
					
					if(p.isEmpty())
						break;
					
					for(int j = 0; j < p.listSize(); j++)
					{
						if(p.GCD(x, p.getNode(j).Value) != 1)
						{
							a.insertAtEnd(new Node(p.getNode(j).Value));
							p.deleteAtIndex(j);
							j = 0;
							
							if(p.isEmpty())
								break;
						}
					}
					
					x = 0;
				}
				
				a.printList();
				
			}catch (Exception ex) {}
	 
	    }

	 
	}