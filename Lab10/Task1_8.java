import java.util.Scanner;

public class Task1_8 {
    public static void main(String[] args){

        if(args.length>0){
            String input = args[0];
            String word = args[1];

            System.out.print("Case-sensitive answer: ");
            System.out.println(input.contains(word));

            System.out.print("Ignoring case: ");
            System.out.println(input.toLowerCase().contains(word.toLowerCase()));

        } else{
            Scanner sc = new Scanner(System.in);
            System.out.print("Input the string: ");

            String input = sc.nextLine();

            System.out.print("Input the word to check: ");

            String word = sc.next();

            System.out.print("Case-sensitive answer: ");
            System.out.println(input.contains(word));

            System.out.print("Ignoring case: ");
            System.out.println(input.toLowerCase().contains(word.toLowerCase()));


        }
    }
}
