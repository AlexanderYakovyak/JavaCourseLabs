package com.colors;

import java.io.*;
import java.util.Scanner;

/**
 * ColorRGBA is an implementation of Color interface that corresponds to RGBA color model.
 * R,G,B,A stands for Red, Green, Blue, Alpha (represent color opacity).
 * R,G,B takes integer values between 0 and 255.
 * A takes integer values between 0 and 100. Where 0 corresponds to
 * 0.0 opacity, and 100 to 1.0 opacity.
 * @author Alexander Yakovyak
 * @version 23 Nov 2022
 * @since 20 Oct 2022
 */
public class ColorRGBA implements Color {

    long R;
    long G;
    long B;
    long A;

    /** Represents the transformation matrix from RGBA color model to XYZ color model.
     * In this implementation we are using AdobeRGB (1998) Working Space.
     */
    static double[][] rgbXyzConversionMatrix = {{0.5767309,  0.1855540,  0.1881852},
            {0.2973769,  0.6273491, 0.0752741},
            {0.0270343,  0.0706872,  0.9911085}};

    /** Creates an empty RGBA color.
     */
    public ColorRGBA(){
    }
    /** Creates a copy of a given RGBA color.
     * @param copy the Object of ColorRGBA class
     */
    public ColorRGBA(ColorRGBA copy){
        this.R = copy.R;
        this.G = copy.G;
        this.B = copy.B;
        this.A = copy.A;
    }
    /** Creates an RGBA color with the specified R,G,B,A values.
     * And checks if corresponding values are correct.
     * @param R the value of red color intensity
     * @param G the value of green color intensity
     * @param B the value of blue color intensity
     * @param A the value of alpha channel
     */
    public ColorRGBA(long R, long G, long B, long A){
        if(((R>255)||(R<0))||((G>255)||(G<0))||((B>255)||(B<0))||((A>100)||(A<0))){
            System.out.println("The values of R,G,B should be integers, not less than 0 and not greater than 255");
            System.out.println("The values of A should be an integer, not less than 0 and not greater than 100");
            this.manualInputColor();
        }else {
            this.R = R;
            this.G = G;
            this.B = B;
            this.A = A;
        }
    }
    /** Converts RGBA color to its String representation.
     */
    @Override
    public String toString() {
        return "ColorRGBA{" +
                "R=" + R +
                ", G=" + G +
                ", B=" + B +
                ", A=" + A +
                '}';
    }
    /** Enables manual-RGBA-color-input from user's console.
     */
    @Override
    public void manualInputColor() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please, input RGBA color: ");
        System.out.print("R: ");
        long temp_R = sc.nextLong();
        System.out.print("G: ");
        long temp_G = sc.nextLong();
        System.out.print("B: ");
        long temp_B = sc.nextLong();
        System.out.print("A: ");
        long temp_A = sc.nextLong();

        while((temp_R>255)||(temp_R<0)||(temp_G>255)||(temp_G<0)||(temp_B>255)||(temp_B<0)||(temp_A>100)||(temp_A<0)){
            System.out.println("The values of R,G,B should be integers, not less than 0 and not greater than 255");
            System.out.println("The values of A should be an integer, not less than 0 and not greater than 100");
            System.out.print("R: ");
            temp_R = sc.nextLong();
            System.out.print("G: ");
            temp_G = sc.nextLong();
            System.out.print("B: ");
            temp_B = sc.nextLong();
            System.out.print("A: ");
            temp_A = sc.nextLong();
        };

        this.R = temp_R;
        this.G = temp_G;
        this.B = temp_B;
        this.A = temp_A;
    }
    /**
     * Writes RGBA color to text file 'rgba_colors.txt' in 'resources' directory
     * in form of sequence of R,G,B,A integer values with spaces in-between.
     */
    @Override
    public void colorToTextFile() {
        try {
            String toFile = Long.toString(this.R) + " " + Long.toString(this.G) + " " + Long.toString(this.B) + " " + Long.toString(this.A) + '\n';
            FileWriter fWriter = new FileWriter("./resources/rgba_colors.txt", true);

            fWriter.write(toFile);
            fWriter.close();
        }
        catch (IOException e) {
            System.out.print(e.getMessage());
        }

    }
    /** Enables RGBA-color-input from text file 'rgba_colors.txt' in 'resources' directory
     * with a given position of a color in the file, assigning retrieved values to our color.
     * @param position Index of a row in a text file.
     */
    @Override
    public void textFileInput(int position) {
        File file = new File("./resources/rgba_colors.txt");
        try {
            Scanner sc = new Scanner(file);
            int con = 0;

            while (sc.hasNextLine()){
                if(con==(position-1)){
                    String text_color = sc.nextLine();
                    String[] components = text_color.split(" ");
                    this.R = Long.parseLong(components[0]);
                    this.G = Long.parseLong(components[1]);
                    this.B = Long.parseLong(components[2]);
                    this.A = Long.parseLong(components[3]);
                }
                sc.nextLine();
                con+=1;
            }

        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Writes RGBA color to binary file 'rgba.dat' in 'resources' directory
     * in form of corresponding long values.
     */
    @Override
    public void colorToBinaryFile() {
        DataOutputStream output=null;
        try {
            output = new DataOutputStream(new FileOutputStream("./resources/rgba.dat", true));
            long toWrite = this.valueInt();
            output.writeLong(toWrite);
            output.flush();
            output.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            try{
                assert output != null;
                output.close();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    /** Enables RGBA-color-input from binary file 'rgba.dat' in 'resources' directory
     * with a given position of a color in the file, converting retrieved long value back
     * to corresponding R,G,B,A values.
     * @param position Index of a long value in a binary file.
     */
    @Override
    public void binaryFileInput(int position) {
        DataInputStream input=null;
        try {
            input = new DataInputStream(new FileInputStream("./resources/rgba.dat"));
            long n =  new File("./resources/rgba.dat").length();

            int cont = 0;
            long number = input.readLong();

            for(int i=0; i < n/8; ++i) {

                if(cont==(position-1)) {
                    ColorRGBA temp = new ColorRGBA(0, 0, 0, 0);
                    temp = (ColorRGBA) temp.fromInt(number);

                    this.R = temp.R;
                    this.G = temp.G;
                    this.B = temp.B;
                    this.A = temp.A;
                    break;
                }

                if(i==(n/8-1)){
                    break;
                }

                number = input.readLong();
                cont++;
            }
            input.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            try{
                input.close();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    /** Converts RGBA value to an integer value by applying
     * shift operator.
     * @return Long value corresponding to R,G,B,A values.
     */
    @Override
    public long valueInt() {
        long res = (this.R << 24) + (this.G << 16) + (this.B << 8) + this.A;

        return res;
    }

    /** Converts RGBA value to a double value by casting
     * integer value of a color to double type.
     * @return Double value corresponding to R,G,B,A values.
     */
    @Override
    public double valueDouble() {
        return (double) this.valueInt();
    }

    /** Converts long value to RGBA color by applying
     * shift operators.
     * @return RGBA color Object corresponding to long value.
     */
    @Override
    public ColorRGBA fromInt(long value){

        long new_R = (value & 0xFF000000) >> 24;
        long new_G = (value & 0x00FF0000) >> 16;
        long new_B = (value & 0x0000FF00) >> 8;
        long new_A = (value & 0x000000FF);

        new_R = Math.min(new_R, 250);
        new_G = Math.min(new_G, 250);
        new_B = Math.min(new_B, 250);
        new_A = Math.min(new_A, 100);


        return new ColorRGBA(new_R,new_G,new_B,new_A);
    }
    /** Blends two RGBA colors by calculating average values
     * of a corresponding R,G,B,A values.
     * @param other Object of RGBA color to blend with.
     * @return RGBA color Object corresponding to blended color.
     */
    public ColorRGBA blendColors(ColorRGBA other) {
        long new_R = (this.R + other.R)/2;
        long new_G = (this.G + other.G)/2;
        long new_B = (this.B + other.B)/2;
        long new_A = (this.A + other.A)/2;

        return new ColorRGBA(new_R, new_G, new_B, new_A);

    }
    /** Applies bitwise OR operation to two RGBA colors
     * by converting them to long values and applying
     * bitwise OR operation to them. Then result value is converted
     * back to corresponding RGBA color.
     * @param other Object of RGBA color to blend with.
     * @return RGBA color Object corresponding to bitwise OR color.
     */
    @Override
    public ColorRGBA bitwiseOr(Color other) {
        long res = other.valueInt() | this.valueInt();

        return this.fromInt(res);
    }
    /** Applies bitwise AND operation to two RGBA colors
     * by converting them to long values and applying
     * bitwise AND operation to them. Then result value is converted
     * back to corresponding RGBA color.
     * @param other Object of RGBA color to blend with.
     * @return RGBA color Object corresponding to bitwise AND color.
     */
    @Override
    public ColorRGBA bitwiseAnd(Color other) {
        long res = other.valueInt() & this.valueInt();

        return this.fromInt(res);
    }
    /** Applies bitwise XOR operation to two RGBA colors
     * by converting them to long values and applying
     * bitwise XOR operation to them. Then result value is converted
     * back to corresponding RGBA color.
     * @param other Object of RGBA color to blend with.
     * @return RGBA color Object corresponding to bitwise XOR color.
     */
    @Override
    public ColorRGBA bitwiseXor(Color other) {
        long res = other.valueInt() ^ this.valueInt();

        return this.fromInt(res);
    }
    /** Converts RGBA color to CMYK color model.
     * As there is no means to directly convert RGBA color to
     * CMYK model, first we apply A (opacity) to each R,G,B value
     * to get R,G,B color and then convert it into CMYK color.
     * After conversion, it's impossible to restore A value back.
     * @return CMYK color corresponding to a given RGBA color.
     */
    public ColorCMYK rgbToCmyk(){
        int new_R = (int) (this.R*this.A/100);
        int new_G = (int) (this.G*this.A/100);
        int new_B = (int) (this.B*this.A/100);

        double R_trans = new_R/255.0;
        double G_trans = new_G/255.0;
        double B_trans = new_B/255.0;

        double K = 1 - Math.max(Math.max(R_trans, G_trans), B_trans);
        double C = (1-R_trans-K)/(1-K);
        double M = (1-G_trans-K)/(1-K);
        double Y = (1-B_trans-K)/(1-K);

        K *= 100;
        C *= 100;
        M *= 100;
        Y *= 100;

        long res_C = (long) Math.round(C);
        long res_M = (long) Math.round(M);
        long res_Y = (long) Math.round(Y);
        long res_K = (long) Math.round(K);

        return new ColorCMYK(res_C,res_M,res_Y,res_K);
    }
    /** Converts RGBA color to HSB color model.
     * As there is no means to directly convert RGBA color to
     * HSB model, first we apply A (opacity) to each R,G,B value
     * to get R,G,B color and then convert it into HSB color.
     * After conversion, it's impossible to restore A value back.
     * @return HSB color corresponding to a given RGBA color.
     */
    public ColorHSB rgbToHsb(){
        int new_R = (int) (this.R*this.A/100);
        int new_G = (int) (this.G*this.A/100);
        int new_B = (int) (this.B*this.A/100);

        double R_trans = new_R/255.0;
        double G_trans = new_G/255.0;
        double B_trans = new_B/255.0;

        double C_max = Math.max(Math.max(R_trans,G_trans),B_trans);
        double C_min = Math.min(Math.min(R_trans,G_trans),B_trans);

        double delta = C_max-C_min;

        double H_trans = 0;
        if(delta==0){
            H_trans=0;
        }else if (C_max==B_trans){
            H_trans = 60*(((R_trans-G_trans)/delta)+4);
        }else if(C_max==G_trans){
            H_trans = 60*(((B_trans-R_trans)/delta)+2);
        }else if(C_max==R_trans){
            H_trans = 60*(((G_trans-B_trans)/delta)%6);
        }

        double S_trans;

        if(C_max==0){
            S_trans=0;
        }else{
            S_trans=delta/C_max;
        }

        long H = (long) H_trans;
        long S = (long) (S_trans*100);
        long B = (long) (C_max*100);

        if(H < 0){
            H = 360+H;
        }

        return new ColorHSB(H,S,B);
    }
    /** Converts RGBA color to XYZ color model.
     * As there is no means to directly convert RGBA color to
     * XYZ model, first we apply A (opacity) to each R,G,B value
     * to get R,G,B color and then convert it into XYZ color,
     * applying our conversion matrix for AdobeRGB (1998) Working Space.
     * After conversion, it's impossible to restore A value back.
     * @return HSB color corresponding to a given RGBA color.
     */
    public ColorXYZ rgbToXyz(){
        int new_R = (int) (this.R*this.A/100);
        int new_G = (int) (this.G*this.A/100);
        int new_B = (int) (this.B*this.A/100);

        double R_trans = new_R/255.0;
        double G_trans = new_G/255.0;
        double B_trans = new_B/255.0;

        double[] rgb = {R_trans, G_trans, B_trans};

        double[] xyz = new double[3];

        for(int i=0;i<rgbXyzConversionMatrix.length;++i){
            double summ=0;
            for(int j=0;j<rgbXyzConversionMatrix.length;++j){
                summ+=(rgbXyzConversionMatrix[i][j]*rgb[j]);
            }
            xyz[i] = summ;
        }

        long res_X = (long) (xyz[0]*100);
        long res_Y = (long) (xyz[1]*100);
        long res_Z = (long) (xyz[2]*100);


        return new ColorXYZ(res_X,res_Y, res_Z);
    }

}