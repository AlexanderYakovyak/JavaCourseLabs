package com.colors;

import java.io.*;
import java.util.Scanner;

/**
 * ColorXYZ is an implementation of Color interface that corresponds to XYZ color model.
 * X,Y,Z stand for the XYZ coordinates for the lightest light and are called the color space's white point.
 * The XYZ coordinates for the reddest possible red, the greenest possible green and bluest possible blue
 * are called the color space's Red, Green, and Blue primaries.
 * X,Y,Z take integer values between 0 and 100.
 * @author Alexander Yakovyak
 * @version 23 Nov 2022
 * @since 20 Oct 2022
 */
public class ColorXYZ implements Color{

    long X;
    long Y;
    long Z;
    /** Represents the transformation matrix from XYZ color model to RGB color model.
     * In this implementation we are using AdobeRGB (1998) Working Space.
     */
    static double[][] xyz_rgb_conversion_matrix = {{2.0413690, -0.5649464, -0.3446944},
            {-0.9692660, 1.8760108, 0.0415560},
            {0.0134474, -0.1183897, 1.0154096}};
    /** Creates an empty XYZ color.
     */
    public ColorXYZ(){
    }
    /** Creates a copy of a given XYZ color.
     * @param copy the Object of ColorHSB class
     */
    public ColorXYZ(ColorXYZ copy){
        this.X = copy.X;
        this.Y = copy.Y;
        this.Z = copy.Z;
    }
    /** Creates a XYZ color with the specified X,Y,Z values.
     * And checks if corresponding values are correct.
     * @param X axis representing red color
     * @param Y axis representing green color
     * @param Z axis representing blue color
     */
    public ColorXYZ(long X, long Y, long Z){
        if(((X>100)||(X<0))||((Y>100)||(Y<0))||((Z>100)||(Z<0))){
            System.out.println("The values of X,Y,Z should be integers, not less than 0 and not greater than 100");
            this.manualInputColor();
        }else {
            this.X = X;
            this.Y = Y;
            this.Z = Z;
        }

    }
    /** Converts XYZ color to its String representation.
     */
    @Override
    public String toString() {
        return "ColorXYZ{" +
                "X=" + X +
                ", Y=" + Y +
                ", Z=" + Z +
                '}';
    }
    /** Enables manual-XYZ-color-input from user's console.
     */
    @Override
    public void manualInputColor() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please, input XYZ color: ");
        System.out.print("X: ");
        long temp_X = sc.nextLong();
        System.out.print("Y: ");
        long temp_Y = sc.nextLong();
        System.out.print("Z: ");
        long temp_Z = sc.nextLong();

        while(((X>100)||(X<0))||((Y>100)||(Y<0))||((Z>100)||(Z<0))){
            System.out.println("The values of X,Y,Z should be integers, not less than 0 and not greater than 100");
            System.out.print("X: ");
            temp_X = sc.nextLong();
            System.out.print("Y: ");
            temp_Y = sc.nextLong();
            System.out.print("Z: ");
            temp_Z = sc.nextLong();
        }

        this.X = temp_X;
        this.Y = temp_Y;
        this.Z = temp_Z;

    }
    /** Enables XYZ-color-input from text file 'xyz_colors.txt' in 'resources' directory
     * with a given position of a color in the file, assigning retrieved values to our color.
     * @param position Index of a row in a text file.
     */
    @Override
    public void textFileInput(int position) {
        File file = new File("./resources/xyz_colors.txt");
        try {
            Scanner sc = new Scanner(file);
            int con = 0;

            while (sc.hasNextLine()){
                if(con==(position-1)){
                    String text_color = sc.nextLine();
                    String[] components = text_color.split(" ");
                    this.X = Long.parseLong(components[0]);
                    this.Y = Long.parseLong(components[1]);
                    this.Z = Long.parseLong(components[2]);
                }
                sc.nextLine();
                con+=1;
            }

        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    /** Enables XYZ-color-input from binary file 'xyz.dat' in 'resources' directory
     * with a given position of a color in the file, converting retrieved long value back
     * to corresponding X,Y,Z values.
     * @param position Index of a long value in a binary file.
     */
    @Override
    public void binaryFileInput(int position) {
        DataInputStream input=null;
        try {
            input = new DataInputStream(new FileInputStream("./resources/xyz.dat"));
            long n =  new File("./resources/xyz.dat").length();

            int cont = 0;
            long number = input.readLong();

            for(int i=0; i < n/8; ++i) {

                if(cont==(position-1)) {
                    ColorXYZ temp = new ColorXYZ(0, 0, 0);
                    temp = (ColorXYZ) temp.fromInt(number);

                    this.X = temp.X;
                    this.Y = temp.Y;
                    this.Z = temp.Z;
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
    /**
     * Writes XYZ color to text file 'xyz_colors.txt' in 'resources' directory
     * in form of sequence of X,Y,Z integer values with spaces in-between.
     */
    @Override
    public void colorToTextFile() {
        try {
            String toFile = Long.toString(this.X) + " " + Long.toString(this.Y) + " " + Long.toString(this.Z)+ '\n';
            FileWriter fWriter = new FileWriter("./resources/xyz_colors.txt", true);

            fWriter.write(toFile);
            fWriter.close();
        }
        catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }
    /**
     * Writes XYZ color to binary file 'xyz.dat' in 'resources' directory
     * in form of corresponding long values.
     */
    @Override
    public void colorToBinaryFile() {
        DataOutputStream output=null;
        try {
            output = new DataOutputStream(new FileOutputStream("./resources/xyz.dat", true));
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
    /** Converts XYZ value to an integer value by applying
     * shift operator.
     * @return Long value corresponding to X,Y,Z values.
     */
    @Override
    public long valueInt() {
        long res = (this.X << 16) + (this.Y << 8) + this.Z;

        return res;
    }
    /** Converts long value to XYZ color by applying
     * shift operators.
     * @return XYZ color Object corresponding to long value.
     */
    @Override
    public ColorXYZ fromInt(long value) {
        long new_X = value >> 16;
        long new_Y = (value & 0x0000FF00) >> 8;
        long new_Z = (value & 0x000000FF);

        new_X = Math.min(new_X, 100);
        new_Y = Math.min(new_Y, 100);
        new_Z = Math.min(new_Z, 100);

        return new ColorXYZ(new_X, new_Y, new_Z);
    }
    /** Converts XYZ value to a double value by casting
     * integer value of a color to double type.
     * @return Double value corresponding to X,Y,Z values.
     */
    @Override
    public double valueDouble() {
        return (double) this.valueInt();
    }
    /** Blends two XYZ colors by calculating average values
     * of a corresponding X,Y,Z values.
     * @param other Object of XYZ color to blend with.
     * @return XYZ color Object corresponding to blended color.
     */
    public ColorXYZ blendColors(ColorXYZ other){
        long new_X = (this.X + other.X)/2;
        long new_Y = (this.Y + other.Y)/2;
        long new_Z = (this.Z + other.Z)/2;

        return new ColorXYZ(new_X, new_Y, new_Z);
    }
    /** Applies bitwise OR operation to two XYZ colors
     * by converting them to long values and applying
     * bitwise OR operation to them. Then result value is converted
     * back to corresponding XYZ color.
     * @param other Object of XYZ color to blend with.
     * @return XYZ color Object corresponding to bitwise OR color.
     */
    @Override
    public ColorXYZ bitwiseOr(Color other) {
        long res = other.valueInt() | this.valueInt();

        return this.fromInt(res);
    }
    /** Applies bitwise AND operation to two XYZ colors
     * by converting them to long values and applying
     * bitwise AND operation to them. Then result value is converted
     * back to corresponding XYZ color.
     * @param other Object of XYZ color to blend with.
     * @return XYZ color Object corresponding to bitwise AND color.
     */
    @Override
    public ColorXYZ bitwiseAnd(Color other) {
        long res = other.valueInt() & this.valueInt();

        return this.fromInt(res);
    }
    /** Applies bitwise XOR operation to two XYZ colors
     * by converting them to long values and applying
     * bitwise XOR operation to them. Then result value is converted
     * back to corresponding XYZ color.
     * @param other Object of XYZ color to blend with.
     * @return XYZ color Object corresponding to bitwise XOR color.
     */
    @Override
    public ColorXYZ bitwiseXor(Color other) {
        long res = other.valueInt() ^ this.valueInt();

        return this.fromInt(res);
    }
    /** Converts XYZ color to RGBA color model.
     * As there is no means to directly convert XYZ color to
     * RGBA model, by default 1.0 opacity is assigned to retrieved RGB value,
     * applying our conversion matrix for AdobeRGB (1998) Working Space.
     * @return RGBA color corresponding to a given XYZ color.
     */
    public ColorRGBA xyzToRgba(){
        double new_X = this.X/100.0;
        double new_Y = this.Y/100.0;
        double new_Z = this.Z/100.0;


        double[] xyz = {new_X, new_Y, new_Z};

        double[] rgb = new double[3];

        for(int i=0;i<xyz_rgb_conversion_matrix.length;++i){
            double summ=0;
            for(int j=0;j<xyz_rgb_conversion_matrix.length;++j){
                summ+=(xyz_rgb_conversion_matrix[i][j]*xyz[j]);
            }
            rgb[i] = summ;
        }


        long res_R = (long) Math.floor(rgb[0]*255.0);
        long res_G = (long) Math.floor(rgb[1]*255.0);
        long res_B = (long) Math.floor(rgb[2]*255.0);

        if(res_B<0){
            res_B = 0;
        }

        return new ColorRGBA(res_R, res_G, res_B, 100);
    }
    /** Converts XYZ color to CMYK color model.
     * We use the ability to convert our XYZ color to RGBA color, which
     * can be transitioned to CMYK color.
     * @return CMYK color corresponding to a given XYZ color.
     */
    public ColorCMYK xyzToCmyk(){
        ColorRGBA transit_color = this.xyzToRgba();
        return transit_color.rgbToCmyk();
    }
    /** Converts XYZ color to HSB color model.
     * We use the ability to convert our XYZ color to RGBA color, which
     * can be transitioned to HSB color.
     * @return HSB color corresponding to a given XYZ color.
     */
    public ColorHSB xyzToHsb(){
        ColorRGBA transit_color = this.xyzToRgba();
        return transit_color.rgbToHsb();
    }
}
