package rational;
public class RationalFraction extends Number {
    int m;
    int n;

    public RationalFraction(){
        this.m = 0;
        this.n = 1;
    }

    public RationalFraction (int m, int n){
        if(n==0){
            System.out.println("Ділення на нуль, неможливо створити число");
        }
        int num_gcd  = gcd(m, n);

        int new_m = m/num_gcd;
        int new_n = n/num_gcd;


        this.m = new_m;
        this.n = new_n;
    }

    public int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

    public  RationalFraction add(RationalFraction other){
        return new RationalFraction(this.m * other.n + this.n * other.m, this.n * other.n);
    }

    public  RationalFraction sub(RationalFraction other){
        return new RationalFraction(this.m * other.n - this.n * other.m, this.n * other.n);
    }

    public  RationalFraction mul(RationalFraction other) {
        return new RationalFraction(this.m * other.m, this.n * other.n);
    }

    public  RationalFraction div(RationalFraction other){
        return new RationalFraction(this.m * other.n, this.n * other.m);
    }

    @Override
    public String toString() {
        return "RationalFraction{" +
                m +
                "/" + n +
                '}';
    }

    @Override
    public int intValue() {
        return (int)m/n;
    }

    @Override
    public long longValue() {
        return (long)m/n;
    }

    @Override
    public float floatValue() {
        return (float)m/n;
    }

    @Override
    public double doubleValue() {
        return (double)m/n;
    }
}
