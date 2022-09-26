public class Task2_2 {
    public static void main(String[] args) {
        /*
        Щоб показати різницю між беззнаковим та знаковим зсувами вправо:
        я взяв від'ємне ціле число
         */

        int num = -12;
        int num2_copy = num;

        if (num>0) {
            System.out.println("Signed right shift");
            while (num != 0) {
                num = num >> 1;
                System.out.println("Number = "+ num + " binary = "+ Integer.toBinaryString(num));
            }

            System.out.println("Left shift + unsigned right shift");
            num2_copy = num2_copy << 1;
            System.out.println("Number = "+ num2_copy + " binary = "+ Integer.toBinaryString(num2_copy));
            while(num2_copy!=0){
                num2_copy = num2_copy >>> 1;
                System.out.println("Number = "+ num2_copy + " binary = "+ Integer.toBinaryString(num2_copy));
            }

        } else {
            System.out.println("Signed right shift");
            while (~num != 0) {
                num = num >> 1;
                System.out.println("Number = "+ num + " binary = "+ Integer.toBinaryString(num));
            }

            System.out.println("Left shift + unsigned right shift");
            num2_copy = num2_copy << 1;
            System.out.println("Number = "+ num2_copy + " binary = "+ Integer.toBinaryString(num2_copy));
            while(num2_copy!=0){
                num2_copy = num2_copy >>> 1;
                System.out.println("Number = "+ num2_copy + " binary = "+ Integer.toBinaryString(num2_copy));
            }
        }
    }
}
