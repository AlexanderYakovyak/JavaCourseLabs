import java.util.Scanner;


public class Task3_8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x;
        x = sc.nextDouble();

        double fraction1 = x%1;
        double whole_part1;

        if(x>0) {
            whole_part1 = x - fraction1;
        }else{
            whole_part1 = x - fraction1 - 1;
        }

        System.out.printf("Whole part = %f \n",whole_part1);
        System.out.printf("Fraction part = %f \n",fraction1);

        System.out.printf("Floor = %f \n",Math.floor(x));
        System.out.printf("Ceil = %f \n",Math.ceil(x));
        System.out.printf("Round = %d \n",Math.round(x));



    }
}
