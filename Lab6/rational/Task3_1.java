package rational;

import java.util.Scanner;

public class Task3_1 {

    public static RationalFraction[] transform_array(RationalFraction[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i].n!=0 || arr[i+1].n!=0)
                arr[i] = arr[i].add(arr[i+1]);
        }
        return arr;
    }

    public static   void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть кількість раціональних чисел, які ви хочете помістити в масив: ");
        int n = sc.nextInt();

        RationalFraction[] rational_array = new RationalFraction[n];

        System.out.printf("Введіть %d раціональних чисел \n",n);

        for(int i=0; i<n; ++i){
            System.out.println("Раціональне число номер "+(i+1));
            System.out.print("m,n = ");
            RationalFraction current = new RationalFraction(sc.nextInt(),sc.nextInt());
            rational_array[i] = current;

        }
        System.out.println();

        System.out.println("Введені числа: ");
        for(RationalFraction num: rational_array){
            if(num.n!=0)
                System.out.println(num);
        }
        System.out.println();

        rational_array = transform_array(rational_array);

        System.out.println("Новий масив, зі зміненними числами: ");
        for(RationalFraction num: rational_array){
            if(num.n!=0)
                System.out.println(num);
        }

    }
}
