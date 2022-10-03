import java.util.Scanner;

public class Task1_2 {

    public static int getMaxValue(int[] numbers){

        int max = numbers[0];

        for(int i=1;i < numbers.length;i++){
            if(numbers[i] > max){
                max = numbers[i];
            }
        }
        return max;
    }


    public static int getMinValue(int[] numbers){

        int min = numbers[0];

        for(int i=1;i<numbers.length;i++){
            if(numbers[i] < min){
                min = numbers[i];
            }
        }
        return min;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Input the sequence of integer numbers: ");

        String input = sc.nextLine();
        String[] numbers = input.split(" ");

        int[] int_numbers = new int[numbers.length];

        for(int i=0;i< numbers.length;++i){
            int_numbers[i] = Integer.parseInt(numbers[i]);
        }


        System.out.printf("The minimal number in an array: %d \n", getMinValue(int_numbers));
        System.out.printf("The maximum number in an array: %d", getMaxValue(int_numbers));

    }
}
