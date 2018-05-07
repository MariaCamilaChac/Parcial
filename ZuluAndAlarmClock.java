import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ZuluAndAlarmClock {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        /*T test cases N numbers of clocks K number of alarms, operation for the number of operations for each clock configuration
          temp for save temporally the number to increase or decrease.*/
        int T, N, K, operation = 0, temp[] = new int[3];
        /*smallers for the configuration of alarm with less steps, smaller for the comparision to find the smaller value.*/
        int smallers[], smaller = 0;
        /*index for the loops*/
        int i, j, m = 0;
        /*this matrix for the clocks and alarms, operations for the counters of the operations of each alarm configuration.*/
        int clocks[][], alarms[][], operations[][];

        T = Integer.parseInt(br.readLine());
        input = br.readLine();

        N = Integer.parseInt(input.split(" ")[0]);
        K = Integer.parseInt(input.split(" ")[1]);

        clocks = new int[N][3]; //3 is for the units of time.
        alarms = new int[K][3];//3 is for the units of time.
        operations = new int[N][K]; // a counter for each clock configuration to set alarm
        smallers = new int[K];

        for (i = 0; i < N; i++) { //for save the clocks
            input = br.readLine();
            for (j = 0; j < 3; j++) {
                clocks[i][j] = Integer.parseInt(input.split(":")[j]);
            }
        }

        for (i = 0; i < K; i++) { //for save the alarms
            input = br.readLine();
            for (j = 0; j < 3; j++) {
                alarms[i][j] = Integer.parseInt(input.split(":")[j]);
            }
        }

        while (T-- > 0) {
            for (i = 0; i < N; i++) { //the clocks
                for (j = 0; j < K; j++) { //the alarms
                    temp = clocks[i].clone();
                    for (m = 2; m >= 0; m--) { //units of time
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
                                } else {
                                    while (temp[m] != alarms[j][m]) {
                                        temp[m]++;
                                        operation++;
                                        if (temp[m] == 24) {
                                            temp[m] = 0;
                                        }
                                    }
                                }
                            } else {
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
                                } else {
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

            for (j = 0; j < K; j++) { //find the smallers value for each alarm configuration.
                smaller = operations[0][j];
                for (i = 0; i < N; i++) {
                    if (operations[i][j] < smaller) {
                        smaller = operations[i][j];
                    }
                }
                smallers[j] = smaller;
            }

            smaller = 0;
            for (j = 0; j < K; j++) {
                smaller += smallers[j];
            }

            bw.write(smaller + "\n");
            bw.flush();
        }
    }
}