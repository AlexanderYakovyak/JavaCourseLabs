import java.util.Scanner;

/** Represents a Task2_2 Lab1.
 * @author Alexander Yakovyak
 * @version 1.0
 * @since 1.0
 */
public class Task2_2 {

    public static void main(String args[]){

        System.out.println("Yakovyak, 10:35, Task2_2");

        Scanner in = new Scanner(System.in);

        System.out.println("Input first integer: ");
        int num1 = in.nextInt();
        System.out.println("Input second integer: ");
        int num2 = in.nextInt();

        System.out.println("Using log:");
        System.out.printf("Length num1 = %d \n", (int)Math.log10(Math.abs(num1))+1);
        System.out.printf("Length num2 = %d \n",(int)Math.log10(Math.abs(num2))+1);


        String new_num1 = Integer.toString(Math.abs(num1));
        String new_num2 = Integer.toString(Math.abs(num2));

        System.out.println("\nUsing strings:");
        System.out.println("Length num1 = "+new_num1.length());
        System.out.println("Length num2 = "+new_num2.length());


        double num1_d = num1;
        double num2_d = num2;

        num1_d = 1/num1_d;
        num2_d = 1/num2_d;

        double harmonic_mean = 2/(num1_d+num2_d);
        System.out.printf("\nHarmonic mean = %.02f", harmonic_mean);

    }
}
