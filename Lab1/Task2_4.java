import java.util.Scanner;

/** Represents a Task2_4 Lab1.
 * @author Alexander Yakovyak
 * @version 1.0
 * @since 1.0
 */
public class Task2_4 {

    public static void main(String args[]){

        System.out.println("Yakovyak, 10:35, Task2_4");

        Scanner in = new Scanner(System.in);

        System.out.println("Input the weather in Celsius:");

        double celsius = in.nextDouble();

        double fahrenheit = 9*celsius/5 + 32;

        System.out.println("Temperature in Fahrenheit = "+fahrenheit);
    }
}
