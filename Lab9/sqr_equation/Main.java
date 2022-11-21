package sqr_equation;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        double a, b, c;

        WrongType io = new WrongType();

        try {
            SqrEqn qadr1 = new SqrEqn(2, -6, 4);
            qadr1.solution();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        try {
            SqrEqn qadr2 = new SqrEqn(1, 2, 3);
            qadr2.solution();
        } catch (DiscriminantEqnException e) {
            e.printStackTrace();
        }

        try {
            SqrEqn qadr3 = new SqrEqn(0, 2, 3);
            qadr3.solution();
        } catch (SqrEqnException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Input a, b, c:");
            a = io.readDouble();
            b = io.readDouble();
            c = io.readDouble();

            SqrEqn qadr = new SqrEqn(a, b, c);
            qadr.solution();
            qadr.printRoots();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }
}
