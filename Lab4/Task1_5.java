import java.util.Scanner;

public class Task1_5 {
    public static double dist(double[] point1, double[] point2){
        double prep = Math.pow(point1[0]-point2[0], 2) + Math.pow(point1[1]-point2[1], 2) + Math.pow(point1[2]-point2[2], 2);
        double dist = Math.sqrt(prep);

        return dist;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double[] point1 = new double[3];

        System.out.println("Input coordinates of the first point: ");
        for(int i=0; i<3;++i){
            point1[i] = sc.nextDouble();
        }

        System.out.println("Input the number of other points: ");
        int n = sc.nextInt();

        double[][] points = new double[n][3];

        System.out.println("Input coordinates of other points: ");
        for(int j=0;j<n;++j) {
            System.out.printf("Point #%d: ", j);
            for (int i = 0; i < 3; ++i) {
                points[j][i] = sc.nextDouble();
            }
        }

        double min_dist = dist(point1, points[0]);
        double[] closest_point = points[0];

        for(int j=1; j<points.length;++j){
            if (dist(point1, points[j]) < min_dist){
                min_dist = dist(point1, points[j]);
                closest_point = points[j];

            }
        }

        System.out.printf("The closest point: (%.3f, %.3f, %.3f), distance = %.3f",closest_point[0],closest_point[1],closest_point[2], min_dist );


    }
}
