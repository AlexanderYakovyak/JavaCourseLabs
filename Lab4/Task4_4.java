import java.util.Scanner;

public class Task4_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input n: ");
        int n = sc.nextInt();

        for(int i = 10; i < 100; ++i){
            if((i-10)%n==0){
                System.out.println();
            }
            System.out.printf("%d ", i);

        }
    }

}
