import java.util.Scanner;

public class Task2_2 {
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

    static void right_cycle(int step, int n, double[][] matrix){
        double[][] copy = new double[n][n];

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                int new_index = (j+step)%n;
                copy[i][new_index] = matrix[i][j];
            }
        }

        System.out.printf("Cycle to the right with %d-steps \n", step);
        display_matrix(copy);
    }

    static void left_cycle(int step, int n, double[][] matrix){
        double[][] copy = new double[n][n];

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                int new_index = (j-step);
                if(new_index<0){
                    new_index = n+new_index;
                }
                copy[i][new_index] = matrix[i][j];
            }
        }

        System.out.printf("Cycle to the left with %d-steps \n", step);
        display_matrix(copy);
    }

    static void bottom_cycle(int step, int n, double[][] matrix){
        double[][] copy = new double[n][n];

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                int new_index = (i+step)%n;
                copy[new_index][j] = matrix[i][j];
            }
        }

        System.out.printf("Cycle to the bottom with %d-steps \n", step);
        display_matrix(copy);
    }

    static void top_cycle(int step, int n, double[][] matrix){
        double[][] copy = new double[n][n];

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                int new_index = (i-step);
                if(new_index<0){
                    new_index = n+new_index;
                }
                copy[new_index][j] = matrix[i][j];
            }
        }

        System.out.printf("Cycle to the top with %d-steps \n", step);
        display_matrix(copy);
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input n: ");
        int n =  sc.nextInt();

        System.out.print("Input k: ");
        int k = sc.nextInt();

        double[][] a = generate_matrix(n);
        right_cycle(k,n,a);
        left_cycle(k,n,a);
        bottom_cycle(k,n,a);
        top_cycle(k,n,a);

    }
}
