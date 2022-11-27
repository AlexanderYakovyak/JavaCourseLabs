package com.colors;

/**
 * Color is a basic interface for all color models of this package:
 * ColorCMYK, ColorHSB, ColorRGBA, ColorXYZ
 * @author Alexander Yakovyak
 * @version 20 Oct 2022
 * @since 20 Oct 2022
 */
public interface Color {
    /**
     * Inputs object of Color implementation class from console
     */
    void manualInputColor();
    /**
     * Inputs object of Color implementation class from text file
     */
    void textFileInput(int position);
    /**
     * Inputs object of Color implementation class from binary file
     */
    void binaryFileInput(int position);
    /**
     * Prints object of Color implementation class to text file
     */
    void colorToTextFile();
    /**
     * Prints object of Color implementation class to binary file
     */
    void colorToBinaryFile();
    /**
     * Returns an int value of object of Color implementation class
     *
     * @return      integer value of object of Color implementation class
     */
    long valueInt();
    /**
     * Converts int value to Color
     *
     * @return      Color implementation object
     */
    Color fromInt(long value);
    /** Blends two colors by calculating average values
     * of a corresponding color model values.
     * @param other Object of Color implementation to blend with.
     * @return Color implementation Object corresponding to blended color.
     */
    Color bitwiseOr(Color other);
    /**
     * Performs bitwise AND operation on two objects of Color implementation class.
     * It utilizes valueInt() method to convert both instances of Color objects
     * into corresponding int values and performs bitwise AND operation on this int values
     * @param other Object of Color implementation to blend with.
     * @return      Color implementation object
     */
    Color bitwiseAnd(Color other);
    /**
     * Performs bitwise XOR operation on two objects of Color implementation class.
     * It utilizes valueInt() method to convert both instances of Color objects
     * into corresponding int values and performs bitwise XOR operation on this int values
     * @param other Object of Color implementation to blend with.
     * @return      Color implementation object
     */
    Color bitwiseXor(Color other);
    /**
     * Returns a double value of object of Color implementation class
     *
     * @return      double value of object of Color implementation class
     */
    double valueDouble();

}