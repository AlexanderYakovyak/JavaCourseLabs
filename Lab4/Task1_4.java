import java.util.Arrays;
import java.util.Scanner;

public class Task1_4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Input the sequence of integer numbers: ");

        String input = sc.nextLine();
        String[] numbers = input.split(" ");

        int[] int_numbers = new int[numbers.length];

        for(int i=0;i< numbers.length;++i){
            int_numbers[i] = Integer.parseInt(numbers[i]);
        }


        int prev=int_numbers[0], rep=1, freq_num=int_numbers[0], max_rep = 1;

        for(int i=1; i<int_numbers.length;++i){
            if(int_numbers[i]==prev){
                rep+=1;

                if(rep>max_rep){
                    max_rep = rep;
                    freq_num = prev;
                } else if (rep==max_rep) {

                    if(prev>freq_num){
                        freq_num = prev;
                    }
                }

            }else{
                if(rep>max_rep){
                    max_rep = rep;
                    freq_num = prev;
                } else if (rep==max_rep) {
                    if(prev>freq_num){
                        max_rep = rep;
                        freq_num = prev;
                    }
                }
                rep=1;

            }
            prev = int_numbers[i];
        }

        System.out.printf("The most frequent number is %d, appears %d times in a row ", freq_num, max_rep);


    }
}
