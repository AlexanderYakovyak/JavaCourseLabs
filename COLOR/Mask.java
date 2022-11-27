/**
 * Represents a mask as a two-dimensional array of integer values of n*m size.
 * @author Alexander Yakovyak
 * @version 24 Nov 2022
 * @since 20 Oct 2022
 */
public class Mask {

    int n;
    int m;
    int[][] maskValues;
    /** Represents the mask’s coefficients
     * that are going to be applied to Image's colors.
     */
    double[][] maskCoefficient;
    /** Creates a Mask with the specified size, and generates integer values for it.
     * Then [0-1] normalization is applied to each integer value.
     * @param n The size of the first dimension of array.
     * @param m The size of the second dimension of array.
     */
    public Mask(int n, int m){
        this.n = n;
        this.m = m;
        this.maskValues = new int[n][m];
        this.generateMask();
        this.normalizeMaskValues();
    }
    /** Creates a Mask with the specified size and Mask values.
     * Then 0-1 normalization is applied to each integer value.
     * @param n The size of the first dimension of array.
     * @param m The size of the second dimension of array.
     * @param maskValues The two-dimensional array of integer values.
     */
    public Mask(int n, int m, int[][] maskValues){
        this.n = n;
        this.m = m;
        this.maskValues = new int[n][m];

        for(int i=0; i<n;++i){
            System.arraycopy(this.maskValues[i], 0, this.maskValues[i], 0, m);
        }

        this.normalizeMaskValues();
    }
    /**
     * Randomly generates n*m integer values for Mask within the range of 0-100.
     */
    private void generateMask(){
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                maskValues[i][j] = (int) (Math.random() * 100);
            }
        }
    }
    /**
     * Displays integer values in a mask values array.
     */
    public void displayMask(){
        for(int i=0; i<n;++i){
            for(int j=0;j<m;++j){
                System.out.println(this.maskValues[i][j]);
            }
        }
    }
    /**
     * Calculates the min and max integer values in an array.
     * @return two-integers array with min and max values.
     */
    protected int[] getMinMax(){
        int max =  maskValues[0][0];
        int min = maskValues[0][0];

        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                if(maskValues[i][j]>max){
                    max = maskValues[i][j];
                }

                if(maskValues[i][j]<min){
                    min = maskValues[i][j];
                }
            }
        }

        return new int[]{min, max};
    }
    /**
     * Applies [0-1] normalization to each value in Mask array.
     */
    protected void normalizeMaskValues() {
        this.maskCoefficient = new double[this.n][this.m];
        int[] minMax = this.getMinMax();
        int min = minMax[0];
        int max = minMax[1];

        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                maskCoefficient[i][j] = 1 -(((double) maskValues[i][j]-min)/((double)max-min));
            }
        }
    }
    /**
     * Applies Mask to a given Image by multiplying all Image color's
     * integer values by corresponding Mask coefficient.
     * It's required that Mask's two-dimensional array size matches
     * Image's two-dimensional array size.
     */
    public void applyMask(Image image){
        if(this.n != image.n || this.m != image.m){
            System.out.println("Impossible to apply this mask to a given image");
            System.out.println("Dimensions don't match");
        }else{
            for(int i=0; i<n; ++i){
                for(int j=0; j<m; ++j){
                    int new_color = (int) ((image.colors[i][j]).valueInt()*this.maskCoefficient[i][j]);
                    image.colors[i][j] = image.colors[i][j].fromInt(new_color);
                }
            }
        }
    }
}
