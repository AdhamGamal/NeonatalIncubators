package com.amg.neonatalincubators;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class Item {

    private final String HOSPITAL_NAME;
    private final int TOTAL_NURSERY_NO;
    private final int FREE_NURSERY_NO;
    private final int PRICE;
    private final String NURSERY_TYPE;
    private final String HOSPITAL_LOCATION;
    private final String HOSPITAL_CITY;
    private final String HOSPITAL_PHONE;
    private final int RATE;
    private final Drawable HOSPITAL_IMAGE;
    private final Drawable NURSERY_IMAGE;

    public Item(String HOSPITAL_NAME, int TOTAL_NURSERY_NO, int FREE_NURSERY_NO, int PRICE, String NURSERY_TYPE, String HOSPITAL_LOCATION, String HOSPITAL_CITY, String HOSPITAL_PHONE, int RATE, Drawable HOSPITAL_IMAGE, Drawable NURSERY_IMAGE) {
        this.HOSPITAL_NAME = HOSPITAL_NAME;
        this.TOTAL_NURSERY_NO = TOTAL_NURSERY_NO;
        this.FREE_NURSERY_NO = FREE_NURSERY_NO;
        this.PRICE = PRICE;
        this.NURSERY_TYPE = NURSERY_TYPE;
        this.HOSPITAL_LOCATION = HOSPITAL_LOCATION;
        this.HOSPITAL_CITY = HOSPITAL_CITY;
        this.HOSPITAL_PHONE = HOSPITAL_PHONE;
        this.RATE = RATE;
        this.HOSPITAL_IMAGE = HOSPITAL_IMAGE;
        this.NURSERY_IMAGE = NURSERY_IMAGE;
    }

    public String getHOSPITAL_NAME() {
        return HOSPITAL_NAME;
    }

    public int getTOTAL_NURSERY_NO() {
        return TOTAL_NURSERY_NO;
    }

    public int getFREE_NURSERY_NO() {
        return FREE_NURSERY_NO;
    }

    public int getPRICE() {
        return PRICE;
    }

    public String getNURSERY_TYPE() {
        return NURSERY_TYPE;
    }

    public String getHOSPITAL_LOCATION() {
        return HOSPITAL_LOCATION;
    }

    public String getHOSPITAL_CITY() {
        return HOSPITAL_CITY;
    }

    public String getHOSPITAL_PHONE() {
        return HOSPITAL_PHONE;
    }

    public int getRATE() {
        return RATE;
    }

    public Drawable getHOSPITAL_IMAGE() {
        return HOSPITAL_IMAGE;
    }

    public Drawable getNURSERY_IMAGE() {
        return NURSERY_IMAGE;
    }
}
