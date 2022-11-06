import gems.Gemstone;
import gems.Ruby;
import gems.Sapphire;

import java.util.Arrays;
import java.util.Scanner;

public class Task6_6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Sapphire sapphire1 = new Sapphire(0.1, 10, 2000, 0.44, "Blue", "Africa");
        Sapphire sapphire2 = new Sapphire(0.05, 12, 5000, 0.87, "Green", "China");

        Ruby ruby1 = new Ruby(0.2, 7, 1400, 0.66, "Africa");
        Ruby ruby2 = new Ruby(0.3, 12, 6000, 0.89, "Alaska");

        Gemstone[] gems = new Gemstone[]{sapphire1, sapphire2, ruby1, ruby2};

        JewelryPiece jp = new JewelryPiece(gems, 3000);

        System.out.printf("The weight of this jewelry piece = %.03f\n", jp.setWeight());
        System.out.printf("The price of this jewelry piece, including craft price = %d\n", jp.setPrice());

        System.out.println("\nGemstones sorted in ascending order by their rarity: ");
        Arrays.sort(gems);

        for(Gemstone gem: gems){
            System.out.println(gem);
        }

        System.out.println("\n");

        double left_border, right_border;

        System.out.print("Input range of desired gem transparency (double values): ");
        left_border = sc.nextDouble();
        right_border = sc.nextDouble();

        System.out.println("\nThe gem with the desired transparency: ");
        for(Gemstone gem: gems){
            if((left_border<=gem.transparency)&&(gem.transparency<=right_border)){
                System.out.println(gem);
            }
        }
    }
}
