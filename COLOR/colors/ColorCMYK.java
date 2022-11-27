package com.colors;

import java.io.*;
import java.util.Scanner;

/**
 * ColorCMYK is an implementation of Color interface that corresponds to CMYK color model.
 * C,M,Y,K stands for Cyan, Magenta, Yellow, and Key (Black color)
 * C,M,Y,K take integer values between 0 and 100.
 * @author Alexander Yakovyak
 * @version 23 Nov 2022
 * @since 20 Oct 2022
 */
public class ColorCMYK implements Color {

    long C;
    long M;
    long Y;
    long K;

    /** Creates an empty CMYK color.
     */
    public ColorCMYK(){
    }
    /** Creates a copy of a given CMYK color.
     * @param copy the Object of ColorCMYK class
     */
    public ColorCMYK(ColorCMYK copy){
        this.C = copy.C;
        this.M = copy.M;
        this.Y = copy.Y;
        this.K = copy.K;
    }
    /** Creates a CMYK color with the specified C,M,Y,K values.
     * And checks if corresponding values are correct.
     * @param C the value of cyan color intensity
     * @param M the value of magenta color intensity
     * @param Y the value of yellow color intensity
     * @param K the value of black color intensity
     */
    public ColorCMYK(long C, long M, long Y, long K){
        if((C>100)||(C<0)||(M>100)||(M<0)||(Y>100)||(Y<0)||(K>100)||(K<0)){
            System.out.println("The values of C,M,Y,K should be integers, not less than 0 and not greater than 100");
            this.manualInputColor();
        }else {
            this.C = C;
            this.M = M;
            this.Y = Y;
            this.K = K;
        }

    }
    /** Converts CMYK color to its String representation.
     */
    @Override
    public String toString() {
        return "ColorCMYK{" +
                "C=" + C +
                ", M=" + M +
                ", Y=" + Y +
                ", K=" + K +
                '}';
    }
    /** Enables manual-CMYK-color-input from user's console.
     */
    @Override
    public void manualInputColor() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please, input CMYK color: ");
        System.out.print("C: ");
        long temp_C = sc.nextLong();
        System.out.print("M: ");
        long temp_M  = sc.nextLong();
        System.out.print("Y: ");
        long temp_Y  = sc.nextLong();
        System.out.print("K: ");
        long temp_K  = sc.nextLong();
        System.out.println(this);

        while((C>100)||(C<0)||(M>100)||(M<0)||(Y>100)||(Y<0)||(K>100)||(K<0)){
            System.out.println("The values of C,M,Y,K should be integers, not less than 0 and not greater than 100");
            System.out.print("C: ");
            temp_C = sc.nextLong();
            System.out.print("M: ");
            temp_M  = sc.nextLong();
            System.out.print("Y: ");
            temp_Y  = sc.nextLong();
            System.out.print("K: ");
            temp_K  = sc.nextLong();
            System.out.println(this);
        }

        this.C = temp_C;
        this.M = temp_M;
        this.Y = temp_Y;
        this.K = temp_K;
    }
    /** Enables CMYK-color-input from text file 'cmyk_colors.txt' in 'resources' directory
     * with a given position of a color in the file, assigning retrieved values to our color.
     * @param position Index of a row in a text file.
     */
    @Override
    public void textFileInput(int position) {
        File file = new File("./resources/cmyk_colors.txt");
        try {
            Scanner sc = new Scanner(file);
            int con = 0;

            while (sc.hasNextLine()){
                if(con==(position-1)){
                    String text_color = sc.nextLine();
                    String[] components = text_color.split(" ");
                    this.C = Long.parseLong(components[0]);
                    this.M = Long.parseLong(components[1]);
                    this.Y = Long.parseLong(components[2]);
                    this.K = Long.parseLong(components[3]);
                }
                sc.nextLine();
                con+=1;
            }

        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    /** Enables CMYK-color-input from binary file 'cmyk.dat' in 'resources' directory
     * with a given position of a color in the file, converting retrieved long value back
     * to corresponding C,M,Y,K values.
     * @param position Index of a long value in a binary file.
     */
    @Override
    public void binaryFileInput(int position) {
        DataInputStream input=null;
        try {
            input = new DataInputStream(new FileInputStream("./resources/cmyk.dat"));
            long n =  new File("./resources/cmyk.dat").length();

            int cont = 0;
            long number = input.readLong();

            for(int i=0; i < n/8; ++i) {

                if(cont==(position-1)) {
                    ColorCMYK temp = new ColorCMYK(0, 0, 0, 0);
                    temp = temp.fromInt(number);

                    this.C = temp.C;
                    this.M = temp.M;
                    this.Y = temp.Y;
                    this.K = temp.K;
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
     * Writes CMYK color to text file 'cmyk_colors.txt' in 'resources' directory
     * in form of sequence of C,M,Y,K integer values with spaces in-between.
     */
    @Override
    public void colorToTextFile() {
        try {
            String toFile = Long.toString(this.C) + " " + Long.toString(this.M) + " " + Long.toString(this.Y) + " " + Long.toString(this.K)+ '\n';
            FileWriter fWriter = new FileWriter("./resources/cmyk_colors.txt", true);

            fWriter.write(toFile);
            fWriter.close();
        }
        catch (IOException e) {
            System.out.print(e.getMessage());
        }

    }
    /**
     * Writes CMYK color to binary file 'cmyk.dat' in 'resources' directory
     * in form of corresponding long values.
     */
    @Override
    public void colorToBinaryFile() {
        DataOutputStream output=null;
        try {
            output = new DataOutputStream(new FileOutputStream("./resources/cmyk.dat", true));
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
    /** Converts CMYK value to an integer value by applying
     * shift operator.
     * @return Long value corresponding to C,M,Y,K values.
     */
    @Override
    public long valueInt() {
        long res = (this.C << 24) + (this.M << 16) + (this.Y << 8) + this.K;

        return res;
    }
    /** Converts long value to CMYK color by applying
     * shift operators.
     * @return CMYK color Object corresponding to long value.
     */
    @Override
    public ColorCMYK fromInt(long value) {

        long new_C = (value & 0xFF000000) >> 24;
        long new_M = (value & 0x00FF0000) >> 16;
        long new_Y = (value & 0x0000FF00) >> 8;
        long new_K = (value & 0x000000FF);

        new_C = Math.min(new_C, 100);
        new_M = Math.min(new_M, 100);
        new_Y = Math.min(new_Y, 100);
        new_K = Math.min(new_K, 100);

        return new ColorCMYK(new_C,new_M,new_Y,new_K);
    }
    /** Converts CMYK value to a double value by casting
     * integer value of a color to double type.
     * @return Double value corresponding to C,M,Y,K values.
     */
    @Override
    public double valueDouble() {
        return (double) this.valueInt();
    }
    /** Blends two CMYK colors by calculating average values
     * of a corresponding C,M,Y,K values.
     * @param other Object of CMYK color to blend with.
     * @return CMYK color Object corresponding to blended color.
     */
    public ColorCMYK blendColors(ColorCMYK other) {
        long new_C = (this.C + other.C)/2;
        long new_M = (this.M + other.M)/2;
        long new_Y = (this.Y + other.Y)/2;
        long new_K = (this.K + other.K)/2;

        return new ColorCMYK(new_C, new_M, new_Y, new_K);

    }
    /** Applies bitwise OR operation to two CMYK colors
     * by converting them to long values and applying
     * bitwise OR operation to them. Then result value is converted
     * back to corresponding CMYK color.
     * @param other Object of CMYK color to blend with.
     * @return CMYK color Object corresponding to bitwise OR color.
     */
    @Override
    public ColorCMYK bitwiseOr(Color other) {
        long res = other.valueInt() | this.valueInt();

        return this.fromInt(res);
    }
    /** Applies bitwise AND operation to two CMYK colors
     * by converting them to long values and applying
     * bitwise AND operation to them. Then result value is converted
     * back to corresponding CMYK color.
     * @param other Object of CMYK color to blend with.
     * @return CMYK color Object corresponding to bitwise AND color.
     */
    @Override
    public ColorCMYK bitwiseAnd(Color other) {
        long res = other.valueInt() & this.valueInt();

        return this.fromInt(res);
    }
    /** Applies bitwise XOR operation to two CMYK colors
     * by converting them to long values and applying
     * bitwise XOR operation to them. Then result value is converted
     * back to corresponding CMYK color.
     * @param other Object of CMYK color to blend with.
     * @return CMYK color Object corresponding to bitwise XOR color.
     */
    @Override
    public ColorCMYK bitwiseXor(Color other) {
        long res = other.valueInt() ^ this.valueInt();

        return this.fromInt(res);
    }
    /** Converts CMYK color to RGBA color model.
     * As there is no means to directly convert CMYK color to
     * RGBA model, by default 1.0 opacity is assigned to retrieved RGB value
     * @return RGBA color corresponding to a given CMYK color.
     */
    public ColorRGBA cmykToRgb(){
        int R = (int) Math.floor(255*(1-(this.C/100.0))*(1-(this.K/100.0)));
        int G = (int) Math.floor(255*(1-(this.M/100.0))*(1-(this.K/100.0)));
        int B = (int) Math.floor(255*(1-(this.Y/100.0))*(1-(this.K/100.0)));

        return new ColorRGBA(R,G,B,100);
    }
    /** Converts CMYK color to HSB color model.
     * We use the ability to convert our CMYK color to RGBA color, which
     * can be transitioned to HSB color.
     * @return HSB color corresponding to a given CMYK color.
     */
    public ColorHSB cmykToHsb(){
        ColorRGBA transit_color = this.cmykToRgb();
        return transit_color.rgbToHsb();
    }
    /** Converts CMYK color to XYZ color model.
     * We use the ability to convert our CMYK color to RGBA color, which
     * can be transitioned to XYZ color.
     * @return XYZ color corresponding to a given CMYK color.
     */
    public ColorXYZ cmykToXyz(){
        ColorRGBA transit_color = this.cmykToRgb();
        return transit_color.rgbToXyz();
    }



}