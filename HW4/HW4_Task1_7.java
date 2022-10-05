import java.util.Arrays;
import java.util.Scanner;

public class HW4_Task1_7 {

    static int[] equal(int[] numbers, int size){
        int[] even = new int[size];
        int count = 0;

        for(int num: numbers){

            int orig = num;
            int count_even = 0;
            int count_odd = 0;

            while(num>0){
                int remainder = num%10;
                num = num/10;
                if(remainder%2==0){
                    count_even+=1;
                }else{
                    count_odd+=1;
                }

            }

            if(count_even==count_odd){
                even[count] = orig;
                count+=1;
            }

        }

        return Arrays.copyOf(even, count);
    }

    static int[] even_numbers(int[] numbers, int size){
        int[] even = new int[size];
        int count = 0;

        for(int num: numbers){

            int orig = num;
            boolean all_even = true;

            while(num>0){
                int remainder = num%10;
                num = num/10;
                if(remainder%2!=0){
                    all_even = false;
                }

            }

            if(all_even){
                even[count] = orig;
                count+=1;
            }

        }

        return Arrays.copyOf(even, count);
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Input n: ");
        int n = sc.nextInt();

        int[] numbers = new int[n];

        System.out.println("Input n integer numbers: ");

        for(int i=0;i<n;++i){
            numbers[i] = sc.nextInt();
        }

        int[] even = even_numbers(numbers,n);

        System.out.println("\nЧисла, що містять лише парні цифри:");
        for(int num:even){
            System.out.printf("%d ", num);
        }
        System.out.println("\nЇх кількість = "+even.length);

        int[] zebra = equal(numbers, n);

        System.out.println("\nЧисла з рівною кількістю парних та непарних цифр:");
        for(int num:zebra){
            System.out.printf("%d ", num);
        }
        System.out.println("\nЇх кількість = "+zebra.length);
    }
}
