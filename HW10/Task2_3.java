import java.util.Scanner;
import java.util.regex.Pattern;

public class Task2_3 {
    public static void main(String[] args){
        String regex = "/(.)\\1*/";

        Scanner sc = new Scanner(System.in);
        System.out.print("Input string: ");

        String input = sc.nextLine();

        char prev_char = input.charAt(0);
        int index_start = 0;
        int seq_length = 1;
        int max_length = 1;
        String longest_sequence = "";
        char c = ' ';


        for (int i = 1; i < input.length() + 1; ++i){

            if(i!=input.length()) {
                c = input.charAt(i);
            }

            if((i!=input.length()) && (c==prev_char)){
                seq_length+=1;
            } else {
                if(seq_length>max_length){
                    max_length = seq_length;
                    longest_sequence = input.substring(index_start, index_start+seq_length);
                }
                index_start = i;
                seq_length = 1;
            }


            prev_char = c;

        }

        System.out.printf("The longest sequence of a length %d:  %s",max_length, longest_sequence );


    }
}
