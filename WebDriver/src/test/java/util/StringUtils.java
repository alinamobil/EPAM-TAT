package util;

public class StringUtils {
    public static boolean isDateValid(String date){
        String[] substr = date.split("\\.");

        int day = Integer.parseInt(substr[0]);
        int month = Integer.parseInt(substr[1]);
        int year = Integer.parseInt(substr[2]);

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: {
                if (day < 0 || day > 31) { return false; }
                break;
            }
            case 4:
            case 6:
            case 9:
            case 11: {
                if (day < 0 || day > 30) { return false; }
                break;
            }
            case 2: {
                if (((day < 0 || day > 28) && year % 4 != 0) || ((day < 0 || day > 29) && year % 4 == 0)) { return false; }
                break;
            }
        }
        return true;
    }

    public static double getCostsRatio(String[] costs) {
        costs[0] = String.join(".", costs[0].split(","));
        costs[1] = String.join(".", costs[1].split(","));
        return Double.parseDouble(costs[1]) / Double.parseDouble(costs[0]);
    }
}
