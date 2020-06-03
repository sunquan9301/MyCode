package demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("hello world");
        System.out.println(getSpecificGmtDate(1614306994000L,0));
        System.out.println(getSpecificGmtDate(1614306994000L,3));
        System.out.println(getSpecificGmtDate(1614306994000L,-3));
    }

    private static String getSpecificGmtDate(long timeMillis, int gmt) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        return sdf.format(new Date(timeMillis));
    }
}
