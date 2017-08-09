package com.test;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by walmt on 2017/7/26.
 */
public class DatePropertyEditor extends PropertyEditorSupport {

    private String format = "yyyy-MM-dd";

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void setAsText(String arg0) throws IllegalArgumentException {
        System.out.println("arg0:" + arg0);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date date = sdf.parse(arg0);
            this.setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
