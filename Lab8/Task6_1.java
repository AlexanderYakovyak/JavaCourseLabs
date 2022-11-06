import bouquet.Accessories;
import bouquet.FlowerBouquet;
import flowers.Flower;
import flowers.Rose;
import flowers.Tulip;

import java.util.Arrays;
import java.util.Scanner;

public class Task6_1 {
    public static void main(String[] args) {
        Rose rose1 = new Rose("red", 10, 10, 3, "Roseae", "Rosaceae");
        Rose rose2 = new Rose("white", 8, 12, 5, "Roseae", "Rosaceae");
        Rose rose3 = new Rose("red", 11, 9, 2, "Roseae", "Rosaceae");
        Rose rose4 = new Rose("white", 7, 9, 3, "Roseae", "Rosaceae");
        Rose rose5 = new Rose("red", 9, 11, 3, "Roseae", "Rosaceae");

        Tulip tulip1 = new Tulip("yellow", 5, 12, 1, "Lilieae", "Liliaceae");
        Tulip tulip2 = new Tulip("pink", 6, 11, 2, "Lilieae", "Liliaceae");

        Flower[] flowers = new Flower[]{rose1, rose2, rose3, rose4, rose5,tulip1, tulip2};

        Accessories accessory1 = new Accessories("red ribbon", 10);
        Accessories accessory2 = new Accessories("white wrap", 15);

        Accessories[] accessories = new Accessories[]{accessory1, accessory2};


        FlowerBouquet bouquet = new FlowerBouquet(7, flowers, 2, accessories);

        System.out.printf("The price of this bouquet = %d\n", bouquet.get_price());

        System.out.println("\nFlowers sorted in ascending order by their freshness: ");
        Arrays.sort(flowers);

        for(Flower flower: flowers){
            System.out.println(flower);
        }

        System.out.println("\n");

        Scanner sc = new Scanner(System.in);

        int left_border, right_border;

        System.out.println("Input range of desired stem length: ");
        left_border = sc.nextInt();
        right_border = sc.nextInt();

        System.out.println("\nThe flower with the desired length os stem: ");
        for(Flower flower: flowers){
            if((left_border<=flower.getStem_length()) && (flower.getStem_length()<=right_border)){
                System.out.println(flower);
                break;
            }
        }

    }
}
