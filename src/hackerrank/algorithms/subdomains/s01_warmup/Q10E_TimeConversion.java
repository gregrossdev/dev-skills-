package hackerrank.algorithms.subdomains.s01_warmup;

public class Q10E_TimeConversion {
    public static String timeConversion(String s) {
        String timeOfDay = s.substring(s.length() - 2);
        String formattedTime;

        if (timeOfDay.equals("PM")) {
            int hour = Integer.parseInt(s.substring(0, 2));
            formattedTime = (hour == 12) ? s.substring(0, 8) : String.format("%02d%s", hour + 12, s.substring(2, 8));
        } else {
            int hour = Integer.parseInt(s.substring(0, 2));
            formattedTime = (hour == 12) ? String.format("%02d%s", 0, s.substring(2, 8)) : s.substring(0, 8);
        }

        return formattedTime;
    }
}
