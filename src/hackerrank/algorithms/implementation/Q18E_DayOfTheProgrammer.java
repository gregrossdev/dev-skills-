package hackerrank.algorithms.implementation;

public class Q18E_DayOfTheProgrammer {
    public static String dayOfProgrammer(int year) {
        // convert date to another date
        // if leap year the 256th day is Sept 12
        // else Sept 13
        String day = "";
        if (year == 1918) {
            return "26.09.1918";
        }
        if((year < 1918 && year % 4 == 0) || (year > 1918 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))) {
            day = "12";
        }
        else {
            day = "13";
        }


        return day + ".09." + year;
    }
}
