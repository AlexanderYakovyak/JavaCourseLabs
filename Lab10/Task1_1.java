import java.util.Scanner;

public class Task1_1 {
    public static void main(String[] args){
        String regex = "[\\p{Punct}\\s]+";
        if(args.length>0){
            String input = args[0];
            String[] words = input.split(regex);
            System.out.println("The number of words in line = "+words.length);
        } else{
            Scanner sc = new Scanner(System.in);
            System.out.print("Input the string: ");
            String input = sc.nextLine();
            String[] words = input.split(regex);

            System.out.println("The number of words in line = "+words.length);
        }
    }
}
