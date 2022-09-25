import java.util.Scanner;

public class Task3_28 {

    public static void main(String[] args){
        Task3_28 task = new Task3_28();
        task.input(args);
    }

    public void input(String[] args){
        Scanner sc = new Scanner(System.in);

        double R,r;
        if (args.length==0){
            System.out.print("Input the major radius R of torus: ");
            R = sc.nextDouble();
            System.out.print("Input the major radius r of torus: ");
            r = sc.nextDouble();

            System.out.printf("The volume of torus = %.3f", volume(R,r));
        } else{
            R = Double.parseDouble(args[0]);
            r = Double.parseDouble(args[1]);

            System.out.printf("The volume of torus = %.3f", volume(R,r));
        }
    }

    public double volume(double R,double r){
        return Math.PI*Math.PI*R*Math.pow(r,2);
    }
}
