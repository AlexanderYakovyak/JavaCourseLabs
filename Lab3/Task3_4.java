public class Task3_4 {

    public static void main(String[] args) {

        if(args.length>2) {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = Integer.parseInt(args[2]);

            int diff = 0;

            if (a != b) {
                diff += 1;
            }
            if (a != c) {
                diff += 1;
            }
            if (b != c) {
                diff += 1;
            }
            if (a==b & b==c){
                diff = 1;
            }

            System.out.printf("There is %d different numbers", diff);
        }
    }
}
