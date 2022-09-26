public class Task2_1 {
    public static void main(String[] args) {
        int first_num = 0x123;
        int second_num = 0x522;

        int x1 = first_num | second_num;
        int x2 = first_num & second_num;
        int x3 = first_num ^ second_num;

        System.out.printf("Result in decimal: x1=%d, x2=%d, x3=%d \n", x1,x2,x3);
        System.out.printf("Result in hex: x1=%x, x2=%x, x3=%x \n", x1,x2,x3);


    }
}
