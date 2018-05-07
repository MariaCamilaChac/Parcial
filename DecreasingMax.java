import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DecreasingMax {
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int n = sc.nextInt();
			int n1[] = new int[n+1];
			int n2[] = new int[100001];
			int n3[] = new int[n+1];
			int max=0 , pos=0;
			long ans = 1;
			long mod = 1000000007;
			int q=0;
			for(int i=1;i<=n;i++)
			{
				int m = sc.nextInt();
				n2[m] = i;
			}
			for(int j=100000;j>0;j--){
				if(n2[j]>q && n2[j]!=0){
					ans = q>0?(ans*(n2[j]-q+1))%mod:1;
					q=n2[j];
				}
			}
			
			System.out.println(ans);
			
		}
		
	}
 
}