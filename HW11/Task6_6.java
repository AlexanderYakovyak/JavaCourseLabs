import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task6_6 {

    public static void writeToBinary(String filename, int[] intValues){
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(filename));

            for(int value: intValues) {
                dos.writeInt(value);
            }

            dos.flush();
            dos.close();
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
        int[] intArray = new int[40];

        for(int i=0; i<20; ++i){
            Random r = new Random();
            intArray[i] = r.nextInt(200);
        }

        for(int i=20; i<40; ++i){
            Random r = new Random();
            intArray[i] = r.nextInt(200)-300;
        }

        writeToBinary(filename, intArray);
    }

    public static void solveA(String fileG, int[] integers){
        List<Integer> positives = new ArrayList<Integer>();
        List<Integer> negatives = new ArrayList<Integer>();

        for(int x: integers){
            if(x<0){
                positives.add(x);
            }else{
                negatives.add(x);
            }
        }

        int[] result = new int[positives.size()+negatives.size()];


        int positiveCount = 0;
        int negativeCount = 0;

        for(int i = 0; i < result.length; ++i) {
            if(i%2==0){
                result[i] = positives.get(positiveCount);
                positiveCount+=1;
            }else{
                result[i] = negatives.get(negativeCount);
                negativeCount+=1;
            }
        }

        writeToBinary(fileG, result);
    }

    public static void solveB(String fileG, int[] integers){
        List<Integer> positives = new ArrayList<Integer>();
        List<Integer> negatives = new ArrayList<Integer>();

        for(int x: integers){
            if(x<0){
                positives.add(x);
            }else{
                negatives.add(x);
            }
        }

        negatives.addAll(positives);

        int[] result = new int[negatives.size()];

        for(int i = 0; i < result.length; i++) {
            result[i] = negatives.get(i);
        }

        writeToBinary(fileG, result);
    }

    public static void solveC(String fileG, int[] integers){
        List<Integer> positives = new ArrayList<Integer>();
        List<Integer> negatives = new ArrayList<Integer>();
        List<Integer> combination = new ArrayList<Integer>();


        for(int x: integers){
            if(x<0){
                positives.add(x);
            }else{
                negatives.add(x);
            }
        }


        for(int i=0; i<positives.size()/2; ++i){
            combination.addAll(negatives.subList(2*i, 2*i+2));
            combination.addAll(positives.subList(2*i, 2*i+2));

        }

        int[] result = new int[combination.size()];

        for(int i=0; i<result.length;++i){
            result[i] = combination.get(i);
        }

        writeToBinary(fileG, result);

    }



    public static void main(String[] args) {

        //generateIntArray("fileF.dat");
        int[] fileFData = toIntArray(readFromBinary("fileF.dat"));

        //solveA("fileG.dat", fileFData)
        //solveB("fileG.dat", fileFData);
        solveC("fileG.dat", fileFData);



        int[] fileGdataCheck = toIntArray(readFromBinary("fileG.dat"));

        for(int x: fileGdataCheck){
            System.out.print(x+" ");
        }

    }
}
