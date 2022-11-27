import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Task6_3 {

    public static void writeToBinary(String filename, int[] intValues){
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(filename));

            for(int value: intValues) {
                dos.writeInt(value);
            }

            dos.flush();
            dos.close();
            System.out.println("Successfully written data to the file");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            try{
                assert dos!=null;
                dos.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public static byte[] readFromBinary(String filename) {
        byte[] allBytes = new byte[0];
        try {
            allBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allBytes;
    }

    public static int[] toIntArray(byte[] byteArray){
        int times = Integer.SIZE/Byte.SIZE;
        int[] integers = new int[byteArray.length/times];

        for(int i=0; i<integers.length;++i){
            integers[i] = ByteBuffer.wrap(byteArray,i*times, times).getInt();
        }

        return integers;
    }

    public static void generateIntArray(String filename){
        int[] intArray = new int[20];

        for(int i=0; i<20; ++i){
            Random r = new Random();
            intArray[i] = r.nextInt(200) - 100;
        }

        writeToBinary(filename, intArray);
    }

    public static void solveA(String outputFile, int[] integers){
        List<Integer> newInt = new ArrayList<Integer>();

        for(int x: integers){
            if(x%2 == 0){
                newInt.add(x);
            }
        }

        int[] result = new int[newInt.size()];
        for(int i = 0; i < newInt.size(); i++) {
            result[i] = newInt.get(i);
        }

        writeToBinary(outputFile, result);

    }

    public static void solveB(String outputFile, int[] integers){
        List<Integer> newInt = new ArrayList<Integer>();

        for(int x: integers){
            if(x%15==0){
                newInt.add(x);
            }
        }

        int[] result = new int[newInt.size()];
        for(int i = 0; i < newInt.size(); i++) {
            result[i] = newInt.get(i);
        }

        writeToBinary(outputFile, result);

    }

    public static void solveC(String outputFile, int[] integers){
        List<Integer> newInt = new ArrayList<Integer>();

        for(int x: integers){
            int temp = (int) Math.sqrt(x);
            if (Math.pow(temp, 2) == x) {
                newInt.add(x);
            }
        }

        int[] result = new int[newInt.size()];
        for(int i = 0; i < newInt.size(); i++) {
            result[i] = newInt.get(i);
        }

        writeToBinary(outputFile, result);

    }

    public static void solveD(String outputFile, int[] integers){

        int[] result = new int[integers.length];
        for(int i = 0; i < integers.length; i++) {
            result[i] = integers[integers.length-1-i];
        }

        writeToBinary(outputFile, result);

    }

    public static int countOccurrences(int[] integers, int x)
    {
        int res = 0;
        for (int i=0; i<integers.length; i++)
            if (x == integers[i])
                res++;
        return res;
    }

    public static void solveE(String outputFile, int[] integers){

        List<Integer> newInt = new ArrayList<Integer>();

        for(int x: integers){
            if(countOccurrences(integers,x)==1){
                newInt.add(x);
            }
        }

        int[] result = new int[newInt.size()];
        for(int i = 0; i < newInt.size(); i++) {
            result[i] = newInt.get(i);
        }

        writeToBinary(outputFile, result);

    }

    public static void main(String[] args){

        //generateIntArray("experiment_int.dat");
        int[] retrievedData = toIntArray(readFromBinary("experiment_int.dat"));

        System.out.println("Generated values");
        for(int x: retrievedData){
            System.out.print(x + " ");
        }
        System.out.println('\n');

        //solveA("new.dat", retrievedData);
        //solveB("new.dat", retrievedData);
        //solveC("new.dat", retrievedData);
        //solveD("new.dat", retrievedData);
        solveE("new.dat", retrievedData);
    }

}
