import java.util.HashMap;
import java.util.Scanner;

class Task4_1 {

    static String fractionToDecimal(int numr, int denr)
    {

        String res = "";

        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.clear();

        int rem = numr % denr;


        while ((rem != 0) && (!mp.containsKey(rem)))
        {

            mp.put(rem, res.length());

            rem = rem * 10;


            int res_part = rem / denr;
            res += String.valueOf(res_part);

            rem = rem % denr;
        }

        if (rem == 0)
            return "";
        else if (mp.containsKey(rem))
            return res.substring(mp.get(rem));

        return "";
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input p and q: ");
        int p = sc.nextInt();
        int q = sc.nextInt();

        String res = fractionToDecimal(p, q);

        int whole = (int) p/q;

        double repr = (double) p/q;

        if (res == "")
            System.out.print(whole);
        else{

            String r = Double.toString(repr);
            int before_repeat = r.indexOf(res);
            int point = r.indexOf('.');

            String last_part = r.substring(point+1,before_repeat);


            System.out.print(whole+"."+last_part+"("+res+")");
        }
    }
}