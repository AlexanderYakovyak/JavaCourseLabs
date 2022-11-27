package com.colors;

import java.io.*;
import java.util.Scanner;

/**
 * ColorHSB is an implementation of Color interface that corresponds to HSB/HSV/HSL color model.
 * HSB stands for Hue, Saturation, Brightness.
 * H takes integer values between 0 and 360.
 * S,B take integer values between 0 and 100.
 * @author Alexander Yakovyak
 * @version 23 Nov 2022
 * @since 20 Oct 2022
 */
public class ColorHSB implements Color{

    long H;
    long S;
    long B;

    /** Creates an empty HSB color.
     */
    public ColorHSB(){
    }
    /** Creates a copy of a given HSB color.
     * @param copy the Object of ColorHSB class
     */
    public ColorHSB(ColorHSB copy){
        this.H = copy.H;
        this.S = copy.S;
        this.B = copy.B;
    }
    /** Creates a HSB color with the specified H,S,B values.
     * And checks if corresponding values are correct.
     * @param H the value of color's hue
     * @param S the value of color's saturation
     * @param B the value of color's brightness
     */
    public ColorHSB(long H, long S, long B){
        if(((H>360)||(H<0))||((S>100)||(S<0))||((B>100)||(B<0))) {
            System.out.println("The values of H should be integers, not less than 0 and not greater than 360");
            System.out.println("The values of S,B should be integers, not less than 0 and not greater than 100");
            this.manualInputColor();
        }else {
            this.H = H;
            this.S = S;
            this.B = B;
        }
    }
    /** Converts HSB color to its String representation.
     */
    @Override
    public String toString() {
        return "ColorHSB{" +
                "H=" + H +
                ", S=" + S +
                ", B=" + B +
                '}';
    }
    /** Enables manual-HSB-color-input from user's console.
     */
    @Override
    public void manualInputColor() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please, input HSB color: ");
        System.out.print("H: ");
        long temp_H = sc.nextLong();
        System.out.print("S: ");
        long temp_S = sc.nextLong();
        System.out.print("B: ");
        long temp_B = sc.nextLong();

        while(((temp_H>360)||(temp_H<0))||((temp_S>100)||(temp_S<0))||((temp_B>100)||(temp_B<0))){
            System.out.println("The values of H should be integers, not less than 0 and not greater than 360");
            System.out.println("The values of S,B should be integers, not less than 0 and not greater than 100");
            System.out.print("H: ");
            temp_H = sc.nextLong();
            System.out.print("S: ");
            temp_S = sc.nextLong();
            System.out.print("B: ");
            temp_B = sc.nextLong();
        }

        this.H = temp_H;
        this.S = temp_S;
        this.B = temp_B;
    }
    /** Enables HSB-color-input from text file 'hsb_colors.txt' in 'resources' directory
     * with a given position of a color in the file, assigning retrieved values to our color.
     * @param position Index of a row in a text file.
     */
    @Override
    public void textFileInput(int position) {
        File file = new File("./resources/hsb_colors.txt");
        try {
            Scanner sc = new Scanner(file);
            int con = 0;

            while (sc.hasNextLine()){
                if(con==(position-1)){
                    String text_color = sc.nextLine();
                    String[] components = text_color.split(" ");
                    this.H = Long.parseLong(components[0]);
                    this.S = Long.parseLong(components[1]);
                    this.B = Long.parseLong(components[2]);
                }
                sc.nextLine();
                con+=1;
            }

        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    /** Enables HSB-color-input from binary file 'hsb.dat' in 'resources' directory
     * with a given position of a color in the file, converting retrieved long value back
     * to corresponding H,S,B values.
     * @param position Index of a long value in a binary file.
     */
    @Override
    public void binaryFileInput(int position) {
        DataInputStream input=null;
        try {
            input = new DataInputStream(new FileInputStream("./resources/hsb.dat"));
            long n =  new File("./resources/hsb.dat").length();

            int cont = 0;
            long number = input.readLong();

            for(int i=0; i < n/8; ++i) {

                if(cont==(position-1)) {
                    ColorHSB temp = new ColorHSB(0, 0, 0);
                    temp = temp.fromInt(number);

                    this.H = temp.H;
                    this.S = temp.S;
                    this.B = temp.B;
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
     * Writes HSB color to text file 'HSB_colors.txt' in 'resources' directory
     * in form of sequence of H,S,B integer values with spaces in-between.
     */
    @Override
    public void colorToTextFile() {
        try {
            String toFile = Long.toString(this.H) + " " + Long.toString(this.S) + " " + Long.toString(this.B)+ '\n';
            FileWriter fWriter = new FileWriter("./resources/hsb_colors.txt", true);

            fWriter.write(toFile);
            fWriter.close();
        }
        catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }
    /**
     * Writes HSB color to binary file 'hsb.dat' in 'resources' directory
     * in form of corresponding long values.
     */
    @Override
    public void colorToBinaryFile() {
        DataOutputStream output=null;
        try {
            output = new DataOutputStream(new FileOutputStream("./resources/hsb.dat", true));
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
    /** Converts HSB value to an integer value by applying
     * shift operator.
     * @return Long value corresponding to H,S,B values.
     */
    @Override
    public long valueInt() {
        long res = (this.H << 16) + (this.S << 8) + this.B;

        return res;
    }
    /** Converts long value to HSB color by applying
     * shift operators.
     * @return HSB color Object corresponding to long value.
     */
    @Override
    public ColorHSB fromInt(long value) {

        long new_H = (value & 0x00FF0000) >> 16;
        long new_S = (value & 0x0000FF00) >> 8;
        long new_B = (value & 0x000000FF);

        new_H = Math.min(new_H, 360);
        new_S = Math.min(new_S, 100);
        new_B = Math.min(new_B, 100);

        return new ColorHSB(new_H, new_S, new_B);
    }
    /** Converts HSB value to a double value by casting
     * integer value of a color to double type.
     * @return Double value corresponding to H,S,B values.
     */
    @Override
    public double valueDouble() {
        return (double) this.valueInt();
    }
    /** Blends two HSB colors by calculating average values
     * of a corresponding H,S,B values.
     * @param other Object of HSB color to blend with.
     * @return HSB color Object corresponding to blended color.
     */
    public ColorHSB blendColors(ColorHSB other){
        long new_H = (this.H + other.H)/2;
        long new_S = (this.S + other.S)/2;
        long new_B = (this.B + other.B)/2;

        return new ColorHSB(new_H, new_S, new_B);
    }
    /** Applies bitwise OR operation to two HSB colors
     * by converting them to long values and applying
     * bitwise OR operation to them. Then result value is converted
     * back to corresponding HSB color.
     * @param other Object of HSB color to blend with.
     * @return HSB color Object corresponding to bitwise OR color.
     */
    @Override
    public ColorHSB bitwiseOr(Color other) {
        long res = other.valueInt() | this.valueInt();

        return this.fromInt(res);
    }
    /** Applies bitwise AND operation to two HSB colors
     * by converting them to long values and applying
     * bitwise AND operation to them. Then result value is converted
     * back to corresponding HSB color.
     * @param other Object of HSB color to blend with.
     * @return HSB color Object corresponding to bitwise AND color.
     */
    @Override
    public ColorHSB bitwiseAnd(Color other) {
        long res = other.valueInt() & this.valueInt();

        return this.fromInt(res);
    }
    /** Applies bitwise XOR operation to two HSB colors
     * by converting them to long values and applying
     * bitwise XOR operation to them. Then result value is converted
     * back to corresponding HSB color.
     * @param other Object of HSB color to blend with.
     * @return HSB color Object corresponding to bitwise XOR color.
     */
    @Override
    public ColorHSB bitwiseXor(Color other) {
        long res = other.valueInt() ^ this.valueInt();

        return this.fromInt(res);
    }
    /** Converts HSB color to RGBA color model.
     * As there is no means to directly convert HSB color to
     * RGBA model, by default 1.0 opacity is assigned to retrieved RGB value
     * @return RGBA color corresponding to a given HSB color.
     */
    public ColorRGBA hsbToRgb(){
        double new_S = this.S/100.0;
        double new_B = this.B/100.0;

        double C = new_S*new_B;
        double X = C*(1-Math.abs((this.H/60.0)%2 - 1));
        double m = new_B-C;

        double R_trans = 0;
        double G_trans = 0;
        double B_trans = 0;

        if((0 <= this.H) && (this.H < 60)){
            R_trans = C;
            G_trans = X;
        }else if((60 <= this.H) && (this.H < 120)){
            R_trans = X;
            G_trans = C;
        }else if((120 <= this.H) && (this.H < 180)){
            G_trans = C;
            B_trans = X;
        }else if((180 <= this.H) && (this.H < 240)){
            G_trans = X;
            B_trans = C;
        }else if((240 <= this.H) && (this.H < 300)){
            R_trans = X;
            B_trans = C;
        }
        else if((300 <= this.H) && (this.H < 360)){
            R_trans = C;
            B_trans = X;
        }

        long R = (long) Math.floor((R_trans+m)*255.0);
        long G = (long) Math.floor((G_trans+m)*255.0);
        long B = (long) Math.floor((B_trans+m)*255.0);

        return new ColorRGBA(R,G,B,100);
    }
    /** Converts HSB color to CMYK color model.
     * We use the ability to convert our HSB color to RGBA color, which
     * can be transitioned to CMYK color.
     * @return CMYK color corresponding to a given HSB color.
     */
    public ColorCMYK hsbToCmyk(){
        ColorRGBA transit_color = this.hsbToRgb();
        return transit_color.rgbToCmyk();
    }
    /** Converts HSB color to XYZ color model.
     * We use the ability to convert our HSB color to RGBA color, which
     * can be transitioned to XYZ color.
     * @return XYZ color corresponding to a given HSB color.
     */
    public ColorXYZ hsbToXyz(){
        ColorRGBA transit_color = this.hsbToRgb();
        return transit_color.rgbToXyz();
    }
}
