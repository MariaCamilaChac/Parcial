import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class DualIssues {
	
	  public static void ordenacionMergeSort(int vec[]){  //function 
          if(vec.length<=1) return;
          int mitad= vec.length/2;  // need split the array in half
          int izq[]=Arrays.copyOfRange(vec, 0, mitad);  //this function allow obtain a range of the matrix and save it in a new array
          int der[]=Arrays.copyOfRange(vec, mitad, vec.length);
          ordenacionMergeSort(izq);
          ordenacionMergeSort(der);       
          combinarVector(vec, izq, der);
  }
  
  public static void combinarVector(int v[], int izq[],int der[]){ // Function to compare and link up the arrays
          int i=0;
          int j=0;
          //create the iterations with conditionals for sort the arrays separately
          for(int k=0;k<v.length;k++){
                  if(i>=izq.length){
                          v[k]=der[j];
                          j++;
                          continue;
                  }
                  if(j>=der.length){
                          v[k]=izq[i];
                          i++;
                          continue;
                  }
                  if(izq[i]<der[j]){
                          v[k]=izq[i];
                          i++;
                  }else{
                          v[k]=der[j];
                          j++;
                  }
          }
  }
 
//method for check if is prime
	public boolean isPrime(int x) {
		
		int C = 0;
		
		for (int i = 1; i <= x; i++) {
			if(x%i == 0 ) {
				C += 1;	
			}
		}
		
		if(C == 2) 
			return true;
		else 
			return false;
		}
	
	//method for check the max value
	public int MayorPrime(int array[]) {
		
		int N = 0;
		int C = 0;
		int Mayor = 0;
		int last;
		int x;
		
		for (int k = 0; k < array.length; k++) {
			
			if(isPrime(array[k])) {
				C++;
			}
		}
		
		int[] primeArray = new int[C];
		
		for (int i = 0; i < array.length; i++) {
			
			if(isPrime(array[i])) {
				
				primeArray[N] = array[i];
				N++;
			}
		}		
		
		if(C<1) {
			
			Mayor = -1;
			
		}else if(C==1) {
			
			Mayor = primeArray[0] * primeArray[0];
			
		}else {
			
			ordenacionMergeSort(primeArray);
			
			last = primeArray[primeArray.length-1];
			x = primeArray[primeArray.length-2];
			
			Mayor = last*x;
		}
		
		return Mayor;	
	}

	public static void main(String[] args) throws IOException {
		
		DualIssues DI = new DualIssues();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int Cases = Integer.parseInt(br.readLine());
		int Total[] = new int[Cases];
		
		for (int i = 0; i < Cases; i++){
			
			int Num = Integer.parseInt(br.readLine());
			
			String cadena = br.readLine();
			String[] cadena_2 = cadena.split(" ");
			
			int array[] = new int[Num];
			
			for (int j = 0; j < Num; j++) {
				
				array[j] = Integer.parseInt(cadena_2[j]);
				
			}
			
			DI.ordenacionMergeSort(array);
			
			Total[i] = DI.MayorPrime(array);
			
		}
		
		for (int i = 0; i < Total.length; i++) {
			System.out.println(Total[i]);
		}
		
	}
	
}