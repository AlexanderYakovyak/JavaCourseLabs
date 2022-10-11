import java.util.Scanner;

public class Task2_4 {
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

    public static double[] solve_task(int n, double[][] matrix){

        double[] sums = new double[n];
        double curr_sum = 0;
        boolean positive = false;

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(matrix[i][j]>0 && !positive){
                    positive = true;
                }else if (matrix[i][j]>0 && positive){
                    sums[i] = curr_sum;
                    curr_sum=0;
                    positive = false;
                }else if(positive){
                    curr_sum+=matrix[i][j];
                }
            }
            positive = false;
            curr_sum=0;
        }

        return sums;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = 0;
        n = sc.nextInt();

        double[][] a = generate_matrix(n);
        double[] res = solve_task(n,a);

        for(int i=0;i<n;++i){
            System.out.printf("%d row\n", (i+1));
            if(res[i]==0){
                System.out.println("There is no elements between first and second positive numbers");
                System.out.println("Or there is no two positive numbers in a row\n");
            }else {
                System.out.printf("The sum between first and second positive numbers = %.3f\n\n", res[i]);
            }
        }

    }
}
