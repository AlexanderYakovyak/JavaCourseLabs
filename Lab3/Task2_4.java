import java.util.Scanner;

public class Task2_4 {
    public static void convert(int n, byte m){
        int bit_to_change = 1 << m;

        n = n ^ bit_to_change;

        System.out.println(n);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n;
        byte m;

        System.out.println("Input n and m: ");
        n = sc.nextInt();
        m = sc.nextByte();

        convert(n,m);

    }
}
