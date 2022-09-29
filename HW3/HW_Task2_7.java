import java.math.BigInteger;
import java.util.Scanner;

public class HW_Task2_7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        long num1;
        long num2;
        System.out.println("Input two long integers: ");

        num1 = sc.nextLong();
        num2 = sc.nextLong();

        BigInteger new_num1 = BigInteger.valueOf(num1);
        BigInteger new_num2 = BigInteger.valueOf(num2);

        BigInteger res1 = new_num1.add(new_num2);
        BigInteger res2 = new_num1.subtract(new_num2);


        System.out.printf("Addition: %d \n", res1);
        System.out.printf("Subtraction: %d", res2);


    }
}
