package com.example.mallapp;

public class salesdta {

    private String Salesinfo;
    private String Imgurl;
    public salesdta(){

    }

    public salesdta(String salesinfo, String imgurl) {
        Salesinfo = salesinfo;
        Imgurl = imgurl;
    }

    public String getSalesinfo() {
        return Salesinfo;
    }

    public void setSalesinfo(String salesinfo) {
        Salesinfo = salesinfo;
    }

    public String getImgurl() {
        return Imgurl;
    }

    public void setImgurl(String imgurl) {
        Imgurl = imgurl;
    }
}
