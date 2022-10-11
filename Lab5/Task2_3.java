import java.util.Scanner;

public class Task2_3 {
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

    public static int solve_task(int n, double[][] matrix){
        int max_streak = 0;
        double prev_el = matrix[0][0];
        int curr_streak = 1;

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(matrix[i][j]>prev_el) {
                    curr_streak += 1;
                }else{
                    if (curr_streak>max_streak){
                        max_streak = curr_streak;
                    }
                    curr_streak = 1;
                }
                prev_el = matrix[i][j];
            }
        }

        System.out.println("Maximum number of ascending numbers = "+max_streak);
        return max_streak;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input n: ");
        int n = 0;
        n = sc.nextInt();

        double[][] a = generate_matrix(n);

        solve_task(n,a);


    }
}
