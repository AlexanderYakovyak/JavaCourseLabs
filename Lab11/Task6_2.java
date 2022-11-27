import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Task6_2 {

    public static void writeToBinary(String filename, int[] intValues){
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(filename, true));

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

    public static int solveA(int[] integers){
        int count = 0;

        for(int x: integers){
            if(x%2 == 0){
                count+=1;
            }
        }

        return count;
    }

    public static int solveB(int[] integers){
        int count = 0;

        for(int x: integers){
            if(x>0) {
                int temp = (int) Math.sqrt(x);
                if (Math.pow(temp, 2) == x) {
                    count += 1;
                }
            }

        }

        return count;

    }

    public static int solveC(int[] integers){
        int maxEven = integers[0];
        int minOdd = integers[1];

        for(int i=0; i<integers.length; i+=2){
            if(integers[i]>maxEven){
                maxEven = integers[i];
            }
        }

        for(int i=1; i<integers.length; i+=2){
            if(integers[i]<minOdd){
                minOdd = integers[i];
            }
        }

        return maxEven-minOdd;

    }

    public static int solveD(int[] integers){
        int longestStreak = 1;
        int prev = integers[0];

        int currentStreak = 1;
        for(int i=1;i<integers.length;++i){
            if(integers[i]>prev){
                currentStreak+=1;
            }else{
                if(currentStreak>longestStreak){
                    longestStreak=currentStreak;
                }
                currentStreak=1;
            }
            prev=integers[i];
        }

        return longestStreak;
    }

    public static void main(String[] args){

        //generateIntArray("experiment_int.dat");
        int[] retrievedData = toIntArray(readFromBinary("experiment_int.dat"));

        System.out.println("Generated values");
        for(int x: retrievedData){
            System.out.print(x + " ");
        }
        System.out.println('\n');

        System.out.println("Task A result = "+solveA(retrievedData));
        System.out.println("Task B result = "+solveB(retrievedData));
        System.out.println("Task C result = "+solveC(retrievedData));
        System.out.println("Task D result = "+solveD(retrievedData));
    }

}
