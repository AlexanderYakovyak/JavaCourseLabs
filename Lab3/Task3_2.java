import java.util.Random;

public class Task3_2 {

    public static void main(String[] args) {
        Random random1 = new Random();

        //Генеруємо 25 випадковий цілих чисел від -30 до 30
        int [] arr = random1.ints(25, -30, 30).toArray();

        //Можуть бути повтори, бо одне і те саме число може декілька разів з'явитись у списку

        //Порівнюємо кожне число із кожним іншим числом з отриманого списку
        for(int i = 0; i  < arr.length; ++i){
            for(int j = i; j < arr.length; j++){

                if(arr[i] < arr[j]){
                    System.out.printf("%d < %d\n", arr[i], arr[j]);
                }else if(arr[i] > arr[j]){
                    System.out.printf("%d > %d\n", arr[i], arr[j]);
                }else{
                    System.out.printf("%d = %d\n", arr[i], arr[j]);
                }

            }
        }


    }
}
