public class Task1_6 {

    public static void main(String args[]){

        double res = 0;

        for(String arg: args) {
            res+=Double.parseDouble(arg);
        }

        System.out.println("Sum of arguments: "+ res);
        System.out.println("Number of double numbers: " + args.length);
    }
}
