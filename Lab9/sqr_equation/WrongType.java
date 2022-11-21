package sqr_equation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WrongType {
    static Scanner sc = new Scanner(System.in);
    private double d;

    public double readDouble() throws InputMismatchException {
        try {
            d = sc.nextDouble();
        } catch(InputMismatchException e) {
            System.out.println("Can't convert to double.");
            throw e;
        }
        return d;
    }
}
