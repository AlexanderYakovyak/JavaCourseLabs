import java.util.Scanner;

public class Task4_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input n: ");
        int n = sc.nextInt();

        for(int i = 1; i < 1001; ++i){

            if((i-1)%n==0){
                System.out.println();
            }
            System.out.printf("%4d ", i);

        }
    }
}
