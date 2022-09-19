public class Task4_4 {

    public static void main(String[] args) {

        double a  = 3;
        double b = 3.5f + 3 * Math.pow(2, -111);
        double c = 3.5f + 3 * Math.pow(2, -111);

        double P = a + b + c;
        double p = P/2;

        double area = Math.sqrt(p*(p-a)*(p-b)*(p-c));


        System.out.printf("Perimeter = %f\n", P);
        System.out.printf("Area = %f", area);
    }
}
