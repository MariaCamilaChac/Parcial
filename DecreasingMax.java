import java.util.*;
import java.io.*;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class DecreasingMax {
  
    public  static class Scann{ //CLASS TO READ THE NUMBER WITH THE METHOD SCANN
	
    	private byte[] buf=new byte[1024];   
    	private int index;
    	private InputStream in;
    	private int total;
    	public Scann()
    	{
    		in=System.in;
    	}
 
    	public int scanner()throws IOException   {
    		if(total<0)
    			throw new InputMismatchException();
    		if(index>=total){
            
    			index=0;
    			total=in.read(buf);
    			if(total<=0)
    				
    				return -1;
        
    		}
        
    		return buf[index++];
    
    	}
    	
    	private boolean isWhiteSpace(int n){ //complement method for class scanner and read white spaces
    		
    		if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1)
    			return true;
    		return false;
    	}
    
    
    	public int nextInt()throws IOException{
    		int integer=0;
    		int n=scanner();
    		while(isWhiteSpace(n))    
    			n=scanner();
    		int neg=1;
    		if(n=='-')                
    		{
    			neg=-1;
    			n=scanner();
        
    		}
    		
    		while(!isWhiteSpace(n)){
            
    			if(n>='0'&&n<='9'){
                
    				integer*=10;
    				integer+=n-'0';
    				n=scanner();
            
    			}
            
    			else throw new InputMismatchException();
    		}
    		return neg*integer;
    	}

    }

    
  public static void main(String args[] ) throws Exception {
        
        Scann leer = new Scann();
        int t = leer.nextInt();
        int mod=1000000007;
       
        while(t-->0){
           
        	int n= leer.nextInt();
            int a[] = new int[n];
            long r[] = new long[n];
            int max[] = new int[n];
            int entrada[] = new int[n];
            int m=0;
            for (int i = 0; i < n; i++) {
            a[i] = leer.nextInt(); 
            if(a[i]>m){ //Compared the  numbers
                m = a[i];
            }
            max[i] = m;
        }
        Stack<Integer> s1 = new Stack<Integer> (); //imports class stack
        s1 . push(0);
        entrada[0] = 0;
        for (int i=1; i<n; i++)
    {
       
        int top=s1.peek(); //this method is used to look at the object at the top of this stack without removing it from the stack.
 
        if (a[i]<a[top])
        {
            entrada[i] = top;
            s1.push(i); // this method is used to Pushes an item onto the top of this stack.
        
        }else{
            while (a[i] >a[s1.peek()])
            {
               s1.pop(); // this method is used to remove the object at the top of this stack and returns that object as the value of this function.
               if(s1.isEmpty()){
                   entrada[i]=i;
                   s1.push(i);
                   break;
               }
            }
            entrada[i]=s1.peek();
            s1.push(i);
        }
    }
    
        
            for (int i = 0; i < n; i++) {
            if(a[i]==max[i]&& i!=0 && max[i-1]!=max[i]){
               r[i]=1;
            }else if(i!=0 && a[i-1] >=a[i]){
                r[i]=(2*r[i-1]) % mod;
                
            }else if(i!=0){
                int j=entrada[i];

                int x=i-j-1;

                r[i]=((r[j]*((x+2)%mod))) % mod;
            }else{
                r[i]=1;
            }
           
        } 
        

            System.out.println(""+r[n-1]);
        }
        
        
 
       
    }
    
}
