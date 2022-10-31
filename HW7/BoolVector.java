import java.util.Arrays;

public class BoolVector {
    int n;
    boolean[] values;

    BoolVector(int n){
        this.n = n;
        this.values = new boolean[n];
    }

    BoolVector(boolean[] vector){
        this.values = new boolean[vector.length];

        for(int i=0; i<vector.length; ++i){
            this.values[i] = vector[i];
        }
    }

    public int ones(){
        int res = 0;
        for(boolean val: this.values){
            if(val)
                res+=1;
        }

        return res;
    }

    public int zeros(){
        int res = 0;
        for(boolean val: this.values){
            if(!val)
                res+=1;
        }

        return res;
    }

    public BoolVector vectorNot(){
        BoolVector new_vector = new BoolVector(this.values.length);

        for(int i=0; i<this.values.length;i++){
            new_vector.values[i] = !(this.values[i]);
        }

        return new_vector;
    }

    public BoolVector vectorAnd(BoolVector other){
        int min_length = Math.min(this.values.length, other.values.length);
        int max_length = Math.max(this.values.length, other.values.length);
        BoolVector new_vector = new BoolVector(max_length);

        for(int i=0; i<min_length;i++){
            new_vector.values[i] = this.values[i] && other.values[i];
        }

        if(this.values.length>other.values.length) {
            for (int j = min_length; j < max_length; ++j) {
                new_vector.values[j] = this.values[j];
            }
        } else if(this.values.length<other.values.length){
            for (int j = min_length; j < max_length; ++j) {
                new_vector.values[j] = other.values[j];
            }
        }

        return new_vector;
    }

    public BoolVector vectorOr(BoolVector other){
        int min_length = Math.min(this.values.length, other.values.length);
        int max_length = Math.max(this.values.length, other.values.length);
        BoolVector new_vector = new BoolVector(max_length);

        for(int i=0; i<min_length;i++){
            new_vector.values[i] = this.values[i] || other.values[i];
        }

        if(this.values.length>other.values.length) {
            for (int j = min_length; j < max_length; ++j) {
                new_vector.values[j] = this.values[j];
            }
        } else if(this.values.length<other.values.length){
            for (int j = min_length; j < max_length; ++j) {
                new_vector.values[j] = other.values[j];
            }
        }

        return new_vector;
    }

    @Override
    public String toString() {
        return "BoolVector{" +
                "n=" + n +
                ", values=" + Arrays.toString(values) +
                '}';
    }

    public static void main(String[] args){
        BoolVector exp = new BoolVector(new boolean[]{true, false, true, false});
        BoolVector exp2 = new BoolVector(new boolean[]{false, true, true});


        BoolVector res = exp.vectorOr(exp2);
        BoolVector res2 = exp.vectorAnd(exp2);
        BoolVector res3 = res2.vectorNot();

        System.out.println("Vector exp OR Vector exp2: ");
        System.out.println(res);
        System.out.println("\nVector exp AND Vector exp2: ");
        System.out.println(res2);
        System.out.println("\nNOT vector res ");
        System.out.println(res3);

        System.out.printf("\nLast vector has %d ones and %d zeros: ", res3.ones(), res3.zeros());
    }

}
