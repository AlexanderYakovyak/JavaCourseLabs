import java.util.Random;

public class Task3_3 {

    public static void main(String[] args) {
        /*
        Всі методи з Random мають рівномірний розроділ, тому і
        вибір цілого числа від [0, 5] - тобто сторін чесного кубіка
        буде рівномірним
        */

        Random r = new Random();
        int cube = r.nextInt(6)+1;
        System.out.println("You got: "+ cube);

    }
}
