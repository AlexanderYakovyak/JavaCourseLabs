import java.util.Scanner;
import java.util.Stack;

public class Task2 {
    public static void main(String[] args){
        Stack<Integer> stk = new Stack<Integer>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Please, input integer: ");
        int number = sc.nextInt();

        while(number>1){
            int part = number%10;
            stk.push(part);
            number = number/10;
        }

        System.out.println("Number of reverse-order digits");
        for(Integer digit: stk){
            System.out.print(digit);
        }

    }
}
