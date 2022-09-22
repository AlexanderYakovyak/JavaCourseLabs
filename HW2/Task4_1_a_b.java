import java.util.Scanner;

public class Task4_1_a_b {

    public static void main(String[] args){
        Task4_1_a_b task = new Task4_1_a_b();
        task.input();
    }

    public void input() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input x: ");
        double x = sc.nextDouble();
        this.a(x);
        this.b(x);
    }

    public double a(double x){
        // x^4 + 2*x^2 + 1 = (x^2+1)^2
        double step1 = x*x;
        double step2 = step1+1;
        double step3 = step2*step2;

        System.out.printf("a) y = %.2f \n", step3);

        return step3;
    }

    public double b(double x){
        // x^4 + x^3 + x^2 + x + 1 = (x^5-1)/(x-1) - сума членів геометричної прогресіїї
        double step1 = x*x;
        double step2 = step1*x;
        double step3 = step1*step2;
        double step4 = step3-1;
        double step5 = x-1;
        double step6 = step4/step5;

        if (x==1) {
            System.out.println("b) y = 5");
            return 5;
        }else {
            System.out.printf("b) y = %.2f \n", step6);
            return step6;
        }

    }

}
