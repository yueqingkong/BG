package block.guess.utils;

import android.text.TextUtils;

import java.math.BigDecimal;

public class StringsUtil {

    public static final long Unit = 100000000;

    /**
     * 有效格式化金额
     *
     * @param decimal
     * @return
     */
    public static String decimal(long decimal) {
        double value = (double) decimal / (double) Unit;

        BigDecimal bigDecimal = new BigDecimal(value);
        String format = bigDecimal.setScale(8, BigDecimal.ROUND_HALF_UP).toPlainString();

        if (format.indexOf(".") > 0) {
            format = format.replaceAll("0+?$", "");//去掉后面无用的零
            format = format.replaceAll("[.]$", "");//如小数点后面全是零则去掉小数点
        }
        return format;
    }

    public static String decimal(double decimal) {
        BigDecimal bigDecimal = new BigDecimal(decimal);
        String format = bigDecimal.setScale(8, BigDecimal.ROUND_HALF_UP).toPlainString();

        if (format.indexOf(".") > 0) {
            format = format.replaceAll("0+?$", "");//去掉后面无用的零
            format = format.replaceAll("[.]$", "");//如小数点后面全是零则去掉小数点
        }
        return format;
    }

    /**
     * 格式化 省略号字符串
     *
     * @param string
     * @return
     */
    public static String ellipsisStartEnd(String string) {
        StringBuffer buffer = new StringBuffer();
        if (string == null || string.length() < 1) {
            buffer.append(string);
        } else {
            buffer.append(string.substring(0, 4));
            buffer.append("****");
            buffer.append(string.substring(string.length() - 4));
        }
        return buffer.toString();
    }

    public static String nameEllipsis(String string, int start) {
        StringBuffer buffer = new StringBuffer();
        if (TextUtils.isEmpty(string) || string.length() < start) {
            buffer.append(string);
        } else {
            buffer.append(string.substring(0, start));
            buffer.append("...");
        }
        return buffer.toString();
    }
}
