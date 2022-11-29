import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Task12 {

    public static void main(String[] args){

        List<Double> polynom1 = Arrays.asList(5.4, -10.543, 56.5, 0.9, 0.0, 14.7);
        List<Double> polynom2 = Arrays.asList(12., -0.4, 55.65, 4.23);

        HashMap<Integer, Double> koffs = new HashMap<Integer, Double>();

        for(int i=0; i<polynom1.size();++i){
            for(int j=0; j<polynom2.size();++j) {
                double newValue = polynom1.get(i) * polynom2.get(j);
                if (koffs.containsKey(i + j)) {
                    double currentValue = koffs.get(i + j);
                    koffs.put(i + j, newValue + currentValue);
                }else{
                    koffs.put(i+j, newValue);
                }
            }
        }

        for(int i=0; i< koffs.size(); ++i){
            if(i==koffs.size()-1) {
                System.out.printf("%.2f*x^%d ", koffs.get(i), i);
            } else if((i!=koffs.size()-1) && (koffs.get(i+1)<0)) {
                System.out.printf("%.2f*x^%d ", koffs.get(i), i);
            } else{
                System.out.printf("%.2f*x^%d + ", koffs.get(i), i);
            }
        }

    }
}
