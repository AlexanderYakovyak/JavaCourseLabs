package sqr_equation;

class SqrEqnException extends ArithmeticException {
    private String detail;

    SqrEqnException(String message) {
        detail = message;
    }

    @Override
    public String toString() {
        return detail;
    }
}


class DiscriminantEqnException extends ArithmeticException {
    private double a, b, c, d;

    DiscriminantEqnException(String message, double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public String toString() {
        return "Discriminant is " + d + " for a, b, c: " + a + ", " + b + ", " + c;
    }
}
