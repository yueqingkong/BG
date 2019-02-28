package block.guess.utils;

public class MathUtil {

    public static final long Unit = 100000000;

    public static String format(long amount) {
        return String.format("%.8f", (double) amount / Unit);
    }

    /**
     * 随机数
     *
     * @param max
     * @return
     */
    public static int randomInMax(int max) {
        return (int) random(max);
    }

    public static boolean random() {
        return random(1) > 0.5d;
    }

    public static double random(int max) {
        return Math.random() * max;
    }
}
