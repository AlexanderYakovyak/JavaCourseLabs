public class Task3_7 {

    public static double gravitational_constant(){
        double g = 6.673 * Math.pow(10, -11);

        return g;
    }

    public static void main(String[] args) {

       double m1 = 180.123f;
       double m2 = 350f;
       double r = 3000f;
       double F = gravitational_constant() * ((m1 * m2)/Math.pow(r,2));
       System.out.printf("F = %e", F);

    }
}
