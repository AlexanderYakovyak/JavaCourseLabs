import java.util.ArrayList;
import java.util.Scanner;

public class HW5_Task2_10 {
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

    public static void solve_task(int n, double[][] matrix){
        double max_element = matrix[0][0];
        int[] index = {0,0};
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(matrix[i][j]>max_element){
                    max_element = matrix[i][j];
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        System.out.printf("The maximal element in a matrix: %.3f\n\n", max_element);

        ArrayList <Integer> rows_to_delete = new ArrayList<Integer>();
        ArrayList <Integer> columns_to_delete = new ArrayList<Integer>();

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(matrix[i][j]==max_element){
                    rows_to_delete.add(i);
                    columns_to_delete.add(j);
                }
            }
        }

        double[][] res = new double[n-rows_to_delete.size()][n-columns_to_delete.size()];
        int new_row = 0;
        int new_column = 0;

        for(int i=0;i<n;++i){
            if(!rows_to_delete.contains(i)){
                for(int j=0;j<n;++j){
                    if(!columns_to_delete.contains(j)){
                        res[new_row][new_column] = matrix[i][j];
                        new_column+=1;
                    }
                }
                new_row+=1;
                new_column=0;
            }
        }
        System.out.println("New matrix: ");
        display_matrix(res);


    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input n: ");
        int n =  sc.nextInt();


        double[][] a = generate_matrix(n);

        solve_task(n,a);



    }
}
