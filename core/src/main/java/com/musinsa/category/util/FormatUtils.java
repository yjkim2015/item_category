package com.musinsa.category.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class FormatUtils {
    public static String toThousandsString(BigDecimal amount) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(amount);
    }
}
