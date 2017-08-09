package com.test;

import java.util.Date;

/**
 * Created by walmt on 2017/7/26.
 */
public class UserManager {
    private Date dataValue;

    public Date getDataValue() {
        return dataValue;
    }

    public void setDataValue(Date dataValue) {
        this.dataValue = dataValue;
    }

    public String toString() {
        return "dataValue:" + dataValue;
    }
}