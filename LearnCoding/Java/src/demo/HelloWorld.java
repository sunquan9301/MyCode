package demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class HelloWorld {
    public static void main(String[] args) {
        String ss = new String("123");
        String ss1 = new String("123");
        System.out.println(ss.equals(ss1));
        System.out.println(ss.hashCode());
        System.out.println(ss1.hashCode());
//        System.out.println(getSpecificGmtDate(1614306994000L,0));
//        System.out.println(getSpecificGmtDate(1614306994000L,3));
//        System.out.println(getSpecificGmtDate(1614306994000L,-3));
    }

    private static String getSpecificGmtDate(long timeMillis, int gmt) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        return sdf.format(new Date(timeMillis));
    }
}
