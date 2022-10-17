import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class Task2_1 {

    public static double[][] generate_matrix(int n){
        double[][] a = new double[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0;  j < n;  j++){
                a[i][j] =  (Math.random() * 2*n)-n;
            }
        }

        System.out.println("\nInitial matrix: ");
        display_matrix(a);

        return a;
    }

    public static void display_matrix(double[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0;  j < matrix.length;  j++){
                System.out.printf(" %+5.3f |", matrix[i][j]);
            }
            System.out.println(" ");
        }
        System.out.println(" \n");
    }

    public static void row_sort(int n, int k, double[][] matrix){
        Map<Double, Integer> valuesMap = new java.util.HashMap<>(Collections.emptyMap());

        double[] tempArr  = new double[n];

        for(int i = 0; i < n; i++){
            tempArr[i] = matrix[i][k];
            valuesMap.put(matrix[i][k], i);
        }
        Arrays.sort(tempArr);

        double[][] b = new double[n][n];
        for(int i = 0; i < n; i++){
            int row = valuesMap.get(tempArr[i]);
            for(int j = 0; j < n; j++){
                b[i][j] = matrix[row][j];
            }
        }
        System.out.printf("Matrix sorted by %d-th column elements\n", k+1);
        display_matrix(b);

    }

    public static void column_sort(int n, int k, double[][] matrix){
        Map<Double, Integer> valuesMap = new java.util.HashMap<>(Collections.emptyMap());

        double[] tempArr  = new double[n];

        for(int i = 0; i < n; i++){
            tempArr[i] = matrix[k][i];
            valuesMap.put(matrix[k][i], i);
        }
        Arrays.sort(tempArr);

        double[][] b = new double[n][n];
        for(int i = 0; i < n; i++){
            int column = valuesMap.get(tempArr[i]);
            for(int j = 0; j < n; j++){
                b[j][i] = matrix[j][column];
            }
        }
        System.out.printf("Matrix sorted by %d-th row elements\n", k+1);
        display_matrix(b);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input n: ");
        int n = 0;
        n = sc.nextInt();

        System.out.print("Input k: ");
        int k = sc.nextInt()-1;

        double[][] a = generate_matrix(n);

        row_sort(n,k,a);
        column_sort(n,k,a);


    }
}
