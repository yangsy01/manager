package com.voucher.manage2.utils;


import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DoubleUtils {

    /**
     * 保留小数点后两位
     */
    public static double convert(double f) {

        String format = new DecimalFormat("#.00").format(f);
        return Double.parseDouble(format);
    }


    /**
     * 保留小数点后三位
     */
    public static double convert1(double f) {

        String format = new DecimalFormat("#.000").format(f);
        return Double.parseDouble(format);
    }
}
