public class HW_Task2_7 {
    public static void main(String args[]){
        int multiplication = 1;

        for(String s: args){
            int temp = Integer.parseInt(s);
            multiplication*=temp;
        }

        System.out.println("Multiplication = "+multiplication);
    }
}
