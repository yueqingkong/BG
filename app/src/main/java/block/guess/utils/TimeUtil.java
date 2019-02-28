package block.guess.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    public final static String FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE = "yyyy/MM/dd HH:mm";
    public final static String FORMAT_TIME = "yyyy/MM/dd HH:mm:ss";
    public final static String FORMAT_MONTH_DAY_TIME = "MM/dd HH:mm:ss";
    public final static String FORMAT_HOUR_MINUTE_SECOND = "HH:mm:ss";

    public static String timestampFormat(long timestamp, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(new Date(timestamp));
    }

    public static long timestamp() {
        return System.currentTimeMillis();
    }

    public static String timestampSecondFormat(int seconds) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (seconds <= 0)
            return "00:00:00";
        else {
            minute = seconds / 60;
            if (minute < 60) {
                second = seconds % 60;
                timeStr = unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
                if (hour > 99) {
                    return "99:59:59";
                }

                minute = minute % 60;
                second = seconds - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }
        }
        return timeStr;
    }

    public static String timestampSecondFullFormat(int seconds) {
        String string = timestampSecondFormat(seconds);
        if (string.length() < 8) {
            string = "00:" + string;
        }
        return string;
    }


    private static String unitFormat(int i) {
        String string = null;
        if (i >= 0 && i < 10)
            string = "0" + Integer.toString(i);
        else {
            string = "" + i;
        }
        return string;
    }
}
