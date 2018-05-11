import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class zuluAndGames {
	
	public int value;
	public int value2;
	
	public zuluAndGames next;
	public zuluAndGames(){}
	
	public zuluAndGames(int V1, int V2){//constructor
		
		this.value = V1;
		this.value2 = V2;
			
	}
	
	public String toString() {//method to print the queue
		
		return "Menor: " + this.value + " Mayor: " + this.value2+ "\n";
		
	}
	
	public zuluAndGames head = null;
	
	public boolean isEmpty() {//Method Check if empty
		
		return head == null ? true : false;
		
	}//end method
	
	public void enqueue(zuluAndGames newNode) {//Method insert at end of the list
		
		if(isEmpty()) {
			
			head = newNode;	
			
		}else{
			
		
			zuluAndGames temp = head;
		
			while(temp.next != null) {
			
				temp = temp.next;
			}
		
			temp.next = newNode;	
		}

	}
	
	public void printList() throws IOException {//Method that print the list
		
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		
		zuluAndGames temp = head;
		while(temp != null) {
			
			bw.write(temp.toString());
			temp = temp.next;
		}
		
		bw.write("\n");
		bw.flush();
		
	}
	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		zuluAndGames game = new zuluAndGames();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int level = Integer.parseInt(br.readLine());
		
		String lower = br.readLine();
		String hight = br.readLine();
		
		String[] lowLevel = lower.split(" ");
		String[] hightLevel = hight.split(" ");
		
		for (int i = 0; i < level; i++) {
			
			game.enqueue(new zuluAndGames(Integer.parseInt(lowLevel[i]),Integer.parseInt(hightLevel[i]))); //enqueue the numbers
			
		}
		
				
		int pruv = 0;
		
		zuluAndGames temp = game.head;
		zuluAndGames temp2 = temp.next;
		
		for (int i = 0; i < level - 1; i++) {
			
			for (int j = i; j < level - 1; j++) {
				
				if(((temp.value >= temp2.value)&&(temp.value <= temp2.value2)) || 
						((temp.value2 >= temp2.value)&&(temp.value2 <= temp2.value2))) {	
				}else {
					
					if(temp.value2 < temp2.value2) {
						
						pruv += temp2.value2;
						
						
					}else {
						
					 pruv += temp.value2;
						
					}
				}
				temp2 = temp2.next;
			}
			
			temp = temp.next;
			temp2 = temp.next;
			
		}
		
		System.out.println(pruv);
	}
}
