import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class HW4_Task4_2 {

    public static int daysBetween(Date d1, Date d2){
        return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    public static void main(String[] args){

        String[] day_of_week = {"Invalid", "Sunday", "Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday"};

        int first_year = 1701;
        int second_year = 2001;

        //First occurrence of Friday 13-th in the 1701 year
        Calendar transit = new GregorianCalendar(1701, 4,13);
        Calendar prev = new GregorianCalendar(1702,0,13);

        int max_days = daysBetween(transit.getTime(), prev.getTime());


        prev = transit;
        int curr_days = 0;

        for(int i=first_year+1;i<second_year+1;++i){
            for (int j=0;j<12;++j){
                Calendar current_month = new GregorianCalendar(i,j,13);
                int week_day = current_month.get(Calendar.DAY_OF_WEEK);

                if(day_of_week[week_day].equals("Friday")){
                    curr_days = daysBetween(prev.getTime(), current_month.getTime());
                    if(curr_days>max_days){
                        max_days=curr_days;
                    }

                    prev = current_month;
                    curr_days = 0;

                }

            }
        }

        System.out.println("Максимальна кількість днів поспіль, у які не бувала п'ятниця 13-го: "+max_days);



    }
}
