package Others;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyDemo {
    public static void main(String[] args) {
        Locale[] locales = {
                new Locale("en", "US"),
                new Locale("en", "IN"),
                new Locale("zh", "CN"),
                new Locale("fr", "FR")
        };
        try (Scanner in = new Scanner(System.in)) {
            double payment = in.nextDouble();
            in.close();
            if (payment >= 0 && payment < Math.pow(payment, 9)) {
                for (Locale currentLocale : locales) {
                    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);
                    if(currentLocale.getDisplayCountry().equals("United States"))
                        System.out.println("US" + ": " + currencyFormatter.format(payment));
                    else
                        System.out.println(currentLocale.getDisplayCountry() + ": " + currencyFormatter.format(payment));
                }
            }
        } catch (Exception ex) {
        }
    }
}
