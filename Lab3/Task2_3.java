public class Task2_3 {

    public static void display_char(char c){
        System.out.printf("Char c = %c in binary = %s \n", c, Integer.toBinaryString(c));
    }
    public static void main(String[] args) {
        char c1 = 'a';
        char c2 = '!';
        char c3 = '#';

        display_char(c1);
        display_char(c2);
        display_char(c3);

    }
}
