package polynom;

import java.util.Arrays;

public class Polynom {
    private int m;
    private double[] coef;

    Polynom(int m, double[] coef){
        this.m = m;
        this.coef = new double[m+1];

        for(int i=0; i<(m+1); ++i){
            this.coef[i] = coef[i];
        }
    }

    @Override
    public String toString() {
        String res = "";
        int degree = 0;
        for(int i=0; i<(m+1); ++i){
            String current;
            if(coef[i] == 0){
                current = "";
            }
            else if(i==0) {
                current = Double.toString(coef[i]) + " + ";
            } else if (i==m) {
                current = Double.toString(coef[i]) + "*x^" + Integer.toString(degree);
            }
            else{
                current = Double.toString(coef[i]) + "*x^" + Integer.toString(degree) + " + ";
            }
            degree+=1;
            res+=current;
        }
        return res;
    }

    public Polynom add(Polynom another){
        int new_m = Math.max(this.m, another.m);
        double[] new_coef = new double[new_m+1];

        for(int i=0; i<(this.m+1); ++i){
            new_coef[i] += this.coef[i];
        }

        for(int i=0; i<(another.m+1); ++i){
            new_coef[i] += another.coef[i];
        }

        Polynom res = new Polynom(new_m, new_coef);

        return res;
    }
}
