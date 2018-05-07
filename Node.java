/**
* Data Structure, Node
*	@author :Camila chacón
*	@date 19-03-2019
*	@version 1
**/
// this is father class or principal class
public class Node {
	


	public Node next; //pointer
	public int Value;

	public Node (int value) {
	
		this.Value = value;
	}
	
	
	public String toString() { //print in console
		return this.Value +" "; 
	}
	
}
