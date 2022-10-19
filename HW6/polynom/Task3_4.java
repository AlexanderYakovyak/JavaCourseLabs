package polynom;

import java.util.Scanner;

public class Task3_4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть кількість поліномів у масиві: ");
        int m = sc.nextInt();

        Polynom[] polynoms = new Polynom[m];

        for(int i=0; i<m; ++i){
            System.out.printf("\nВведіть степінь %d-го полінома: ",(i+1));
            int n = sc.nextInt();
            System.out.printf("Введіть коефіцієнти полінома (від старшого до молодшого): ");

            double[] curr_coef = new double[n+1];
            for(int j=0; j<(n+1); ++j){
                curr_coef[j] = sc.nextDouble();
            }

            Polynom curr_poly = new Polynom(n,curr_coef);
            System.out.println(curr_poly);
            polynoms[i] = curr_poly;
        }

        Polynom first = polynoms[0];

        for(int i=1;i<m;++i){
            first = first.add(polynoms[i]);
        }

        System.out.println("\nСума введених поліномів: ");
        System.out.println(first);



        
    }
}
