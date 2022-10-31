import FractionPolynom.Polynom;
import fraction.RationalFraction;

import java.util.ArrayList;
import java.util.List;

public class Task4_1 {
    public static void main(String[] args){
        List<RationalFraction> fraction1 = new ArrayList<>(){
            {
                add(new RationalFraction(1, 2));
                add(new RationalFraction(-100, 412));
                add(new RationalFraction(13, 15));
            }
        };

        List<RationalFraction> fractions2 = new ArrayList<>(){
            {
                add(new RationalFraction(-1,2));
                add(new RationalFraction(23, 23));
                add(new RationalFraction(-55, 41));
                add(new RationalFraction(2, 1));

            }
        };

        Polynom polynom1 = new Polynom(fraction1);
        Polynom polynom2 = new Polynom(fractions2);

        System.out.println("Polynom1: " + polynom1 );
        System.out.println("Polynom2: " + polynom2 );

        Polynom res = polynom1.addPolynom(polynom2);
        System.out.println("\nResult: " + res);
    }

}
