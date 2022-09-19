public class Task3_5 {
    public static void main(String[] args) {

     int[] int_array = {1,2,3,4,5};
     double[] float_array = {3.0, 1.0, 5.0, 4.0, 2.1};

     for (int i=0;i<5;i++){
      String temp = Integer.toString(int_array[i]);
      System.out.printf("%3s  |", temp);
     };
     System.out.println();

     for (int i=0;i<5;i++){
      System.out.print(" --  |");
     };
     System.out.println();

     for (int i=0;i<5;i++){
      String temp = Double.toString(float_array[i]);
      System.out.printf("%4s |", temp);
     };
    }
}
