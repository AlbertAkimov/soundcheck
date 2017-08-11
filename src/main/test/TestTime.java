import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @Author A.Albert
 * @Data 8/11/17
 * @Time 8:10 PM
 * @Version 1.0
 * @Info test convert string with times to java object {@link java.sql.Time} class.
 */

public class TestTime {

    public static void main(String[] args) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("HH:mm");
        String time = "11:00";
        String time1 = "13:00";

        Time conTime = new Time(formatter.parse(time).getTime());
        Time conTime2 = new Time(formatter.parse(time1).getTime());

        System.out.println(conTime.getTime() / 1000 / 60 / 60);
    }
}
