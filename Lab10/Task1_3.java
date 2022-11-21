import java.util.Scanner;

public class Task1_3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input string: ");

        String input = sc.nextLine().replace("small", "very large");

        System.out.println("Modified string: "+ input);
    }
}
