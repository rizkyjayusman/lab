package tech.noar.commons.helper;

import java.math.BigDecimal;

public class MathHelper {
    public static Double convertToDecimal(Double percent) {
        if (percent > 1) {
            return percent / 100;
        }
        return percent;
    }

    public static Double convertToPercent(Double decimal) {
        if (decimal < 1) {
            return BigDecimal.valueOf(decimal)
                    .multiply(BigDecimal.valueOf(100))
                    .doubleValue();
        }

        return decimal;

    }

}
