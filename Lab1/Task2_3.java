import java.util.Scanner;

/** Represents a Task2_3 Lab1.
 * @author Alexander Yakovyak
 * @version 1.0
 * @since 1.0
 */
public class Task2_3 {

    public static void main(String args[]){

        System.out.println("Yakovyak, 10:35, Task2_3");

        Scanner in = new Scanner(System.in);

        System.out.println("Input two float numbers: ");
        Double[] nums = new Double[2];

        for (int i=0; i<2; i++){
            nums[i] = in.nextDouble();
        }

        double geometrical_mean = Math.pow((Math.abs(nums[0]*nums[1])), 0.5);

        System.out.println("Geometrical mean: "+ geometrical_mean);
        System.out.printf("Geometrical mean in scientific notation: %e", geometrical_mean);
    }
}
