import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ZuluAndAlarmClock {

	public static void main(String[] args) throws IOException {
        	
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
      			
    int operation = 0, temp[] = new int[3];
     
    int smaller = 0;
   
       
    int T = Integer.parseInt(br.readLine());
    String input = br.readLine();

    int N = Integer.parseInt(input.split(" ")[0]);
    int K = Integer.parseInt(input.split(" ")[1]);

    int[][] clocks = new int[N][3]; 
    
    int[][] alarms = new int[K][3];
        
    int[][] operations = new int[N][K]; // a counter for each clock configuration to set alarm
        
    int []smallers = new int[K];

    for (int i = 0; i < N; i++) { //input of the user
    	
    	input = br.readLine();
    	
    	for (int j = 0; j < 3; j++) {
    		clocks[i][j] = Integer.parseInt(input.split(":")[j]);
        }
        	
    }

    for (int i = 0; i < K; i++) { //for save the alarms
    	input = br.readLine();
    	for (int j = 0; j < 3; j++) {
    		alarms[i][j] = Integer.parseInt(input.split(":")[j]);    	
    	}
    }

    while (T-- > 0) {
    	for (int i = 0; i < N; i++) { //the clocks
    		
    		for (int j = 0; j < K; j++) { //the alarms
    			temp = clocks[i].clone();
    		
    			for (int m = 2; m >= 0; m--) { //units of time
    			
    				if (temp[m] != alarms[j][m]) {
    				
    					if (m == 0) { // if we are comparing hours
    					
    						if ((temp[m] > alarms[j][m] && Math.abs(temp[m] - alarms[j][m]) < 12) || 	
    								(temp[m] < alarms[j][m] && Math.abs(temp[m] - alarms[j][m]) > 12) ) {
    						
    							while (temp[m] != alarms[j][m]) {
    								temp[m]--;
    								operation++;
    							
    								if (temp[m] == -1) {
    									temp[m] = 23;
    								}    
    							}
                            
    						} 
    						else {
    							while (temp[m] != alarms[j][m]) {
    								temp[m]++;
    								operation++;
    								
    								if (temp[m] == 24) 
    									temp[m] = 0;                        
                                    }
                                }
                            } 
    					else {
    						if ((temp[m] > alarms[j][m] && Math.abs(temp[m] - alarms[j][m]) < 30) || 
    							(temp[m] < alarms[j][m] && Math.abs(temp[m] - alarms[j][m]) > 30)) {
                                    	
    							while (temp[m] != alarms[j][m]) {
    								temp[m]--;
    								operation++;
    								
    								if (temp[m] == -1) {
    									temp[m] = 59;
    									temp[m - 1]--;   
    								}
                          		}      
    						}
    						else {
                                 
    							while (temp[m] != alarms[j][m]) {
    								temp[m]++;
    								operation++;
    								if (temp[m] == 60) {
    									temp[m] = 0;
    									temp[m - 1]++;
                                        
    								}
                                    
    							}
                                
    						}
                            
    					}
                        
    				}
                    
    			}
    			operations[i][j] = operation;
    			operation = 0;
                	
    		}
            
    	}

    	for (int j = 0; j < K; j++) { //find the smaller value for each alarm configuration.
    		smaller = operations[0][j];
    		for (int i = 0; i < N; i++) {
    			if (operations[i][j] < smaller) 
    				smaller = operations[i][j];
                    	
                }
                	
    		smallers[j] = smaller;
            
    	}

    	smaller = 0;
    	for (int j = 0; j < K; j++) 
    		smaller += smallers[j];
            	
    	bw.write(smaller + "\n");
    	bw.flush();
       }
    
	}
}
