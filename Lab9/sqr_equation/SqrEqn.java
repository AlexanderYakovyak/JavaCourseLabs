package sqr_equation;

public class SqrEqn {
    private double a, b, c, x1, x2;

    SqrEqn() {}

    SqrEqn(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double discriminant() throws DiscriminantEqnException {
        double d = b*b - 4*a*b;

        if (d < 0) {
            throw new DiscriminantEqnException("Can't solve complex numbers equation!", a, b, c, d);
        }
        return d;
    }

    public void solution() throws DiscriminantEqnException, SqrEqnException {
        try {
            if (a == 0) throw new sqr_equation.SqrEqnException("It's not square root equation");

            double d = discriminant();
            double x1 = (-b - Math.sqrt(d))/(2*a);
            double x2 = (-b + Math.sqrt(d))/(2*a);

            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
            this.x1 = x1;
            this.x2 = x2;

        } catch (SqrEqnException e) {
            System.out.println(e);
            throw new SqrEqnException("Division by 0.");
        } catch (DiscriminantEqnException e) {
            throw e;
        }
    }

    public void printRoots() {
        System.out.println("Roots: x1 = " + x1 + ", x2 = " + x2);
    }
}
