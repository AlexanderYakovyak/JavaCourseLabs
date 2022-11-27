import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Task6_1 {

    public static void writeToBinary(String filename, double[] doubleValues){
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(filename, true));

            for(double value: doubleValues) {
                dos.writeDouble(value);
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

    public static double[] toDoubleArray(byte[] byteArray){
        int times = Double.SIZE/Byte.SIZE;
        double[] doubles = new double[byteArray.length/times];

        for(int i=0; i<doubles.length;++i){
            doubles[i] = ByteBuffer.wrap(byteArray,i*times, times).getDouble();
        }

        return doubles;
    }

    static double solveA(double[] doubles){
        double summ = 0;
        for(double x: doubles){
            summ+=x;
        }
        return summ;
    }

    static int solveB(double[] doubles){
        int count = 0;
        for(double x: doubles){
            if(x<0){
                count+=1;
            }
        }

        return count;
    }

    static double solveC(double[] doubles){
        return doubles[doubles.length-1];
    }

    static double solveD(double[] doubles){
        double max = doubles[0];

        for(int i=1; i<doubles.length;++i){
            if(doubles[i]>max){
                max = doubles[i];
            }
        }

        return max;
    }

    static double solveE(double[] doubles){
        double min = doubles[0];

        for(int i=2; i<doubles.length;i+=2){
            if(doubles[i]<min && i%2==0){
                min = doubles[i];
            }
        }

        return min;
    }

    static double getMin(double[] doubles){
        double min = doubles[0];

        for(int i=1; i<doubles.length;++i){
            if(doubles[i]<min){
                min = doubles[i];
            }
        }

        return min;
    }

    static double solveG(double[] doubles){
        return doubles[0]-doubles[doubles.length-1];
    }

    static int solveH(double[] doubles){
        int res = 0;

        double mean = 0;
        for(double x:doubles){
            mean+=x;
        }

        mean = mean/doubles.length;

        for(double x: doubles){
            if(x<mean){
                res+=1;
            }
        }

        return res;
    }

    static void generateDoubleRandom(String filename){
        double[] testData = new double[15];
        for(int i=0; i<15;++i){
            Random r = new Random();
            testData[i] = -100.0 + 200.0 * r.nextDouble();
        }

        writeToBinary(filename, testData);
    }

    public static void main(String[] args){
        //generateDoubleRandom("experiment_double.dat");
        double[] retrievedData = toDoubleArray(readFromBinary("experiment_double.dat"));

        for(double x: retrievedData){
            System.out.print(x+" ");
        }


        System.out.println("Task A result = "+solveA(retrievedData));
        System.out.println("Task B result = "+solveB(retrievedData));
        System.out.println("Task C result = "+solveC(retrievedData));
        double max = solveD(retrievedData);
        System.out.println("Task D result = "+max);
        System.out.println("Task E result = "+solveE(retrievedData));
        System.out.println("Task F result = " + (max-getMin(retrievedData)));
        System.out.println("Task G result = " +solveG(retrievedData));
        System.out.println("Task H result = " +solveH(retrievedData));

    }

}
