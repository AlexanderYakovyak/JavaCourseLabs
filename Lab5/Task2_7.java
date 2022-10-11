import java.util.Scanner;

public class Task2_7 {

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

    static double[][] rotate_matrix_90(int n, double[][] matrix, boolean display)
    {
        double[][] new_matrix = new double[n][n];
        for(int i = 0; i < matrix.length; i++)
            new_matrix[i] = matrix[i].clone();

        for (int i = 0; i < n / 2; ++i) {
            for (int j = i; j < n -i-1; j++) {

                double temp = new_matrix[i][j];

                new_matrix[i][j] = new_matrix[j][n-1-i];

                new_matrix[j][n-1-i] = new_matrix[n-1-i][n-1-j];

                new_matrix[n-1-i][n-1-j] = new_matrix[n-1-j][i];

                new_matrix[n-1-j][i] = temp;
            }
        }

        if(display) {
            System.out.println("Counterclockwise 90-degrees matrix: ");
            display_matrix(new_matrix);
        }

        return new_matrix;

    }

    //Просто повернути два рази на 90 градусів
    static double[][] rotate_matrix_180(int n, double[][] matrix, boolean display){
        double[][] matrix_180 = rotate_matrix_90(n, matrix, false);
        matrix_180 = rotate_matrix_90(n,matrix_180, false);


        if(display) {
            System.out.println("Counterclockwise 180-degrees matrix: ");
            display_matrix(matrix_180);
        }

        return matrix_180;
    }

    static double[][] rotate_matrix_270(int n, double matrix[][], boolean display)
    {
        double[][] new_matrix = new double[n][n];

        for(int i = 0; i < matrix.length; i++)
            new_matrix[i] = matrix[i].clone();

        for (int i = 0; i < n / 2; i++)
        {
            for (int j = i; j < n - i - 1; j++)
            {
                double temp = new_matrix[i][j];
                new_matrix[i][j] = new_matrix[n - 1 - j][i];
                new_matrix[n - 1 - j][i] = new_matrix[n - 1 - i][n - 1 - j];
                new_matrix[n - 1 - i][n - 1 - j] = new_matrix[j][n - 1 - i];
                new_matrix[j][n - 1 - i] = temp;
            }
        }

        if(display) {
            System.out.println("Counterclockwise 270-degrees matrix: ");
            display_matrix(new_matrix);
        }

        return new_matrix;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = 0;
        n = sc.nextInt();

        double[][] a = generate_matrix(n);

        rotate_matrix_90(n,a, true);
        rotate_matrix_180(n,a, true);
        rotate_matrix_270(n,a, true);

    }


}
