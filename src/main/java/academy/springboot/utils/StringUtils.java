package academy.springboot.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringUtils {

    public static String toBrazilianCurrency(BigDecimal source) {
        var nf = NumberFormat.getCurrencyInstance();

        return nf.format(source);
    }

    public static String toBrazilianDateTime(LocalDateTime source) {
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        return source.format(formatter);
    }
}
