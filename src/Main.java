import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        // Assuming the termDate is today's date
        Date termDate = new Date();

    // Assuming the termsActiveDate is the number of months to add from today's date
        int termsActiveDate = 3;

    // Create a Calendar instance and set its time to the termDate
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(termDate);

    // Add the number of months to the Calendar instance
        calendar.add(Calendar.MONTH, termsActiveDate);

    // Subtract 2 days if the month has 30 days to account for the 28-day month
        int monthDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (monthDays == 30) {
            calendar.add(Calendar.DATE, -2);
        }

    // Get the updated date from the Calendar instance
        Date updatedDate = calendar.getTime();







        LocalDate now = LocalDate.now(); //2015-11-23
        LocalDate lastDay = now.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDay);
        System.out.println(lastDay.getDayOfMonth());

    }
}