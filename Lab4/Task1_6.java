import java.util.Scanner;

public class Task1_6 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Input the sequence of integer numbers: ");

        String input = sc.nextLine();
        String[] numbers = input.split(" ");

        int min_length = numbers[0].length();

        for(int i=1;i<numbers.length;++i){

            if(((numbers[i].charAt(0) == '-') && ((numbers[i].length() - 1) < min_length))){
                min_length = numbers[i].length();
            }else if (numbers[i].length()<min_length){
                min_length = numbers[i].length();
            }
        }
        String[] res = new String[numbers.length];

        int counter = 0;
        for(int i=0; i< numbers.length;++i){
            if((numbers[i].charAt(0) == '-') && ((numbers[i].length()-1)==min_length)) {
                res[counter] = numbers[i];
                counter += 1;
            }else if(numbers[i].length()==min_length){
                res[counter] = numbers[i];
                counter+=1;
            }
        }

        System.out.println("The numbers with least digits: ");

        for(int i=0;i<counter;++i){
            System.out.print(res[i]+' ');
        }


    }
}
