import java.util.Scanner;

public class Task2_6 {
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


    public static double matrix_norm(int n, double[][] matrix){
        double norm = 0;
        double curr_norm = 0;

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                curr_norm+=Math.abs(matrix[j][i]);
            }
            if (curr_norm>norm){
                norm = curr_norm;
            }
            curr_norm = 0;
        }

        return norm;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = 0;
        n = sc.nextInt();

        double[][] a = generate_matrix(n);


        System.out.printf("The norm of this matrix = %.3f \n", matrix_norm(n,a));

    }
}
