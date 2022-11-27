import com.colors.ColorCMYK;
import com.colors.ColorHSB;
import com.colors.ColorRGBA;
import com.colors.ColorXYZ;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TestColors {
    /** Calculates the number of Color records in a corresponding text file
     * @param fileName path to the text file with records about particular Color model
     * @return Number of particular Color model records in a text file
     */
    public static int countTxtInstances(String fileName) {

        Path path = Paths.get(fileName);

        int lines = 0;
        try {

            lines = (int) Files.lines(path).count();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;

    }
    /** Calculates the number of Color records in a corresponding binary file
     * @param fileName path to the binary file with records about particular Color model
     * @return Number of particular Color model records in a binary file
     */
    public static int countBinInstances(String fileName){
        int lines = 0;

        DataInputStream input=null;
        try {
            int n = (int) new File(fileName).length();
            return n/8;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lines;
    }
    /** Enables to test different types of Colors Object input, namely
     * manual and text/binary file inputs.
     * @return Array of two Color implementation Object to test methods on
     */
    public static ColorRGBA[] rgbaColorTestInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the mode of providing data: ");
        System.out.println("1 - for manual input");
        System.out.println("2 - for file input");

        int mode = sc.nextInt();

        while(mode!=1 && mode!=2){
            System.out.println("Choose the CORRECT mode of providing data: ");
            System.out.println("1 - for manual input");
            System.out.println("2 - for file input");
            mode = sc.nextInt();


        }

        if(mode==1){
            System.out.println("First color for testing: ");
            ColorRGBA test_color1 = new ColorRGBA();
            test_color1.manualInputColor();

            System.out.println("Second color for testing:");
            ColorRGBA test_color2 = new ColorRGBA();
            test_color2.manualInputColor();

            return new ColorRGBA[] {test_color1, test_color2};
        }else{
            long rgba_txt_records = countTxtInstances("./resources/rgba_colors.txt");
            long rgba_bin_records = countBinInstances("./resources/rgba.dat");


            System.out.println("Choose what file to read from: 1 - text, 2 - binary");

            int source = sc.nextInt();

            while(source!=1 && source!=2){
                System.out.println("Choose what file to read from: 1 - text, 2 - binary");
                source = sc.nextInt();


            }

            ColorRGBA test_color1 = new ColorRGBA();
            ColorRGBA test_color2 = new ColorRGBA();

            if(source==1){
                System.out.printf("There is currently %d records of RGBA colors in text file\n", rgba_txt_records);
                System.out.printf("Input the positions of 2 colors you want to get: from 0 to %d\n", rgba_txt_records-1);

                int position1 = sc.nextInt();
                int position2 = sc.nextInt();

                test_color1.textFileInput(position1);
                test_color2.textFileInput(position2);

            }else{
                System.out.printf("There is currently %d records of RGBA colors in binary file\n", rgba_bin_records);
                System.out.printf("Input the positions of 2 colors you want to get: from 0 to %d\n", rgba_bin_records-1);

                int position1 = sc.nextInt();
                int position2 = sc.nextInt();

                test_color1.binaryFileInput(position1);
                test_color2.binaryFileInput(position2);
            }

            return new ColorRGBA[]{test_color1, test_color2};


        }

    }
    /** Tests all binary methods on array of two RGBA colors
     */
    public static void rgbaColorsOperations(ColorRGBA[] colors){
        ColorRGBA test_color1 = colors[0];
        ColorRGBA test_color2 = colors[1];

        System.out.println("Blended colors:");
        System.out.println(test_color2.blendColors(test_color1));

        System.out.println("\nBitwise AND of colors:");
        System.out.println(test_color2.bitwiseAnd(test_color1));

        System.out.println("\nBitwise OR of colors:");
        System.out.println(test_color2.bitwiseOr(test_color1));

        System.out.println("\nBitwise XOR of colors:");
        System.out.println(test_color2.bitwiseXor(test_color1));

    }
    /** Tests all conversions from test RGBA color
     */
    public static void rgbaColorConversion(ColorRGBA test_color){
        ColorCMYK to_cmyk = test_color.rgbToCmyk();
        ColorHSB to_hsb = test_color.rgbToHsb();
        ColorXYZ to_xyz = test_color.rgbToXyz();

        System.out.println("\nConverted to CMYK");
        System.out.println(to_cmyk);

        System.out.println("\nConverted to HSB");
        System.out.println(to_hsb);

        System.out.println("\nConverted to XYZ");
        System.out.println(to_xyz);

        System.out.println("\nConversion back: ");
        System.out.println("Converted from CMYK");
        System.out.println(to_cmyk.cmykToRgb());

        System.out.println("\nConverted from HSB");
        System.out.println(to_hsb.hsbToRgb());

        System.out.println("\nConverted from XYZ");
        System.out.println(to_xyz.xyzToRgba());
    }
    /** Tests Image creation from RGBA colors and
     * different methods of Mask applications
     */
    public static Image rgbaColorsToImage(){
        long random_R, random_G, random_B, random_A;

        Image test_image = new Image(2,5);
        ColorRGBA[][] colors = new ColorRGBA[2][5];

        for(int i=0; i<2; ++i) {
            for(int j=0; j<5; ++j) {
                random_R = (int) (Math.random() * 256);
                random_G = (int) (Math.random() * 256);
                random_B = (int) (Math.random() * 256);
                random_A = (int) (Math.random() * 100);
                ColorRGBA temp = new ColorRGBA(random_R, random_G, random_B, random_A);
                colors[i][j] = temp;
            }
        }

        test_image.setColors(colors);

        /** Displaying randomly generated ColorRGBA values */
        System.out.println("\nColors we've randomly generated:\n");
        test_image.displayColors();
        System.out.println('\n');

        /** Writing array of Color instances to text and binary files */
        //test_image.imageToTextFile();
        //test_image.imageToBinaryFile();

        return test_image;
    }


    public static void test1(){
        ColorRGBA test_colors[] = rgbaColorTestInput();

        System.out.println("Your colors: ");
        System.out.println(test_colors[0]);
        System.out.println(test_colors[1]);
        System.out.println();

        rgbaColorsOperations(test_colors);
        rgbaColorConversion(test_colors[0]);

    }

    public static void test2(){
        Image test_image = rgbaColorsToImage();
        Mask test_mask = new Mask(2,5);
        test_mask.applyMask(test_image);

        System.out.println("Colors of given Image after applying this mask:");
        test_image.displayColors();
    }

    public static void test3(){
        ColorCMYK testCmyk= new ColorCMYK();
        testCmyk.binaryFileInput(countBinInstances("./resources/cmyk.dat")-2);

        ColorCMYK testCmyk2 = new ColorCMYK();
        testCmyk2.textFileInput(countTxtInstances("./resources/cmyk_colors.txt")-5);

        System.out.println("\nConverting our CMYK color to other color models");
        System.out.println(testCmyk.cmykToRgb());
        System.out.println(testCmyk.cmykToXyz());
        System.out.println(testCmyk.cmykToHsb());

        System.out.println("\nBlending out CMYK colors");
        System.out.println(testCmyk.blendColors(testCmyk2));

        System.out.println("\nApplying bitwise operations to our CMYK colors");
        System.out.println("\nbitwise OR");
        System.out.println(testCmyk.bitwiseOr(testCmyk2));
        System.out.println("\nbitwise AND");
        System.out.println(testCmyk.bitwiseAnd(testCmyk2));
        System.out.println("\nbitwise XOR");
        System.out.println(testCmyk.bitwiseXor(testCmyk2));
    }

    public static void test4(){
        ColorHSB testHSB = new ColorHSB();
        testHSB.binaryFileInput(countBinInstances("./resources/hsb.dat")-5);

        ColorHSB testHSB2 = new ColorHSB();
        testHSB2.textFileInput(countTxtInstances("./resources/hsb_colors.txt")-2);

        System.out.println("\nConverting our HSB color to other color models");
        System.out.println(testHSB.hsbToRgb());
        System.out.println(testHSB.hsbToCmyk());
        System.out.println(testHSB.hsbToXyz());

        System.out.println("\nBlending out HSB colors");
        System.out.println(testHSB.blendColors(testHSB2));

        System.out.println("\nApplying bitwise operations to our HSB colors");
        System.out.println("\nbitwise OR");
        System.out.println(testHSB.bitwiseOr(testHSB2));
        System.out.println("\nbitwise AND");
        System.out.println(testHSB.bitwiseAnd(testHSB2));
        System.out.println("\nbitwise XOR");
        System.out.println(testHSB.bitwiseXor(testHSB2));
    }

    public static void test5(){
        ColorXYZ testXYZ = new ColorXYZ();
        testXYZ.binaryFileInput(countBinInstances("./resources/xyz.dat"));

        ColorXYZ testXYZ2 = new ColorXYZ();
        testXYZ2.textFileInput(countTxtInstances("./resources/xyz_colors.txt")-2);

        System.out.println("\nConverting our XYZ color to other color models");
        System.out.println(testXYZ.xyzToCmyk());
        System.out.println(testXYZ.xyzToHsb());
        System.out.println(testXYZ.xyzToRgba());

        System.out.println("\nBlending out XYZ colors");
        System.out.println(testXYZ.blendColors(testXYZ2));

        System.out.println("\nApplying bitwise operations to our XYZ colors");
        System.out.println("\nbitwise OR");
        System.out.println(testXYZ.bitwiseOr(testXYZ2));
        System.out.println("\nbitwise AND");
        System.out.println(testXYZ.bitwiseAnd(testXYZ2));
        System.out.println("\nbitwise XOR");
        System.out.println(testXYZ.bitwiseXor(testXYZ2));
    }

}
