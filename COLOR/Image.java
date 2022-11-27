import com.colors.*;

/**
 * Represents an image as a two-dimensional array of colors of n*m size.
 * @author Alexander Yakovyak
 * @version 23 Nov 2022
 * @since 20 Oct 2022
 */
public class Image {

    int n;
    int m;
    Color[][] colors;
    /** Creates an Image with the specified size.
     * @param n The size of the first dimension of array.
     * @param m The size of the second dimension of array.
     */
    public Image(int n, int m){
        this.n = n;
        this.m = m;
        this.colors = new Color[n][m];
    }
    /** Creates an Image with the specified size and two-dimensional array of colors.
     * @param n The size of the first dimension of array.
     * @param m The size of the second dimension of array.
     * @param colors The two-dimensional array of n*m instances of Color interface
     */
    public Image(int n, int m, Color[][] colors){
        this.n = n;
        this.m = m;
        this.colors = new Color[n][m];

        for(int i=0; i<n;++i){
            System.arraycopy(colors[i], 0, this.colors[i], 0, m);
        }
    }
    /**
     * Displays Color in a colors array, as specified for each color type
     */
    public void displayColors(){
        for(int i=0; i<this.n;++i){
            for(int j=0;j<this.m;++j){
                System.out.println(this.colors[i][j]);
            }
        }
    }
    /** Sets the image's color set
     * @param colors A two-dimensional array of Color instances
     */
    public void setColors(Color[][] colors) {
        for (int i=0; i<this.n; ++i){
            for(int j=0; j<this.m; ++j){
                this.colors[i][j] = colors[i][j];
            }
        }
    }
    /**
     * Writes Image to text file by writing each Color of a specific type
     * to the corresponding Color text file.
     * After writing down the Image, It would be impossible to restore
     * the initial color values, once the Object of Image is deleted.
     */
    public void imageToTextFile(){
        for(int i=0;i<this.n;++i){
            for(int j=0;j<this.m;++j){
                colors[i][j].colorToTextFile();
            }
        }
    }
    /**
     * Writes Image to binary file by writing each Color of a specific type
     * to the corresponding Color binary file.
     * After writing down the Image, It would be impossible to restore
     * the initial color values, once the Object of Image is deleted.
     */
    public void imageToBinaryFile(){
        for(int i=0;i<this.n;++i){
            for(int j=0;j<this.m;++j){
                colors[i][j].colorToBinaryFile();
            }
        }
    }
}
