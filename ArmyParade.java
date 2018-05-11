import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ArmyParade {
    public static int NumberTroopers = 0;
    
    public static void changeRows(int[][] matrix, int row, int col){
        int bubble[];
        bubble = matrix[row].clone();
        matrix[row] = matrix[col];
        matrix[col] = bubble;
    }
    
    public static void NumberPartition(int matrix[][],int finalRow,int finalCol, int initialRow){
        for (int i = initialRow; i < finalRow; i++) {
            for (int j = 0; j < finalCol; j++) {
                if(matrix[i][j] == 1){
                    NumberTroopers++;
                }
            }
        }
    }
    
    public static void Matrix(int matrix[][], int value){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = value;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        
        // n number of columns, m number of row, k number of troopers, r for row and c for column*/
        
        int N, M, K, R, C, troop[][], Troop[][];
       
        int i, j, initialRow = 0, rowToChange1 = 1, rowToChange2 = 2;
        int finalRow = 2, finalCol = 2;
        String input;
        
        input = br.readLine();
        
        N = Integer.parseInt(input.split(" ")[0]);
        M = Integer.parseInt(input.split(" ")[1]);
        K = Integer.parseInt(input.split(" ")[2]);
        
        troop = new int[N][M];
        Matrix(troop, 1);//1 for the officers
        
        for (i = 0; i < K; i++) {
            input = br.readLine();
            R = Integer.parseInt(input.split(" ")[0]);
            C = Integer.parseInt(input.split(" ")[1]);
            troop[R-1][C-1] = 0;//0 for the troopers
        }
        
        Troop = troop.clone();
        while(finalRow < N || finalCol < M){
            while (rowToChange1 < N) {
                for (i = 0; i < N - rowToChange1; i++) {
                    NumberPartition(troop, finalRow, finalCol, initialRow);
                    changeRows(troop, rowToChange1, rowToChange2);
                }
                initialRow++;
                rowToChange1++;
                finalRow++;
            }
            if(finalRow + 1 <= N && finalCol == M ){
                finalRow++;
            }
            if(finalCol + 1 <= M && finalRow == N){
                finalCol++;
            }
            if(finalRow + 1 <= N && finalCol + 1 <= M){
                finalRow++;
                finalCol++;
            }
            initialRow = 0;
            rowToChange1 = finalRow;
            troop = Troop.clone();
        }
        
       NumberPartition(troop, N, M, 0);
        
        bw.write(NumberTroopers + "\n");
        bw.flush();
    }
}