import java.util.Random;

public class HW_Task3_7 {
    public static void main(String[] args){

        Random r = new Random();
        int dayOfWeek = r.nextInt(7);

        System.out.printf("Day of the week: %d \n", (dayOfWeek+1));

        switch(dayOfWeek){
            case 0:
                System.out.println("It's Monday");
                break;
            case 1:
                System.out.println("It's Tuesday");
                break;
            case 2:
                System.out.println("It's Wednesday");
                break;
            case 3:
                System.out.println("It's Thursday");
                break;
            case 4:
                System.out.println("It's Friday");
                break;
            case 5:
                System.out.println("It's Saturday");
                break;
            case 6:
                System.out.println("It's Sunday");
                break;
            default:
                break;
        }
    }
}
