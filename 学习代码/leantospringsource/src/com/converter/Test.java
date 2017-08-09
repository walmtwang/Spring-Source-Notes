package com.converter;

import org.springframework.core.convert.support.DefaultConversionService;

import java.util.Date;

/**
 * Created by walmt on 2017/8/3.
 */
public class Test {

    public static void main(String[] args) {
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new String2DateConverter());
        String dateStr = "2010-01-01 00:00:00";
        Date date = conversionService.convert(dateStr, Date.class);
        System.out.println(date);
    }
}
