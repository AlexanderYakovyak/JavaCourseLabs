import java.util.Scanner;

public class Task2_5 {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input n: ");
        int n = 0;
        n = sc.nextInt();

        double[][] a = generate_matrix(n);


        double[][] t = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                t[i][j] = a[j][i];

            }
        }

        System.out.println("Transposed matrix: ");
        display_matrix(t);
    }
}
