package com.dse.test;


public class Model {
String tradeName, ltp, change, change_percent;

    public Model(String tradeName, String ltp, String change, String change_percent) {
        this.tradeName = tradeName;
        this.ltp = ltp;
        this.change = change;
        this.change_percent = change_percent;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getLtp() {
        return ltp;
    }

    public void setLtp(String ltp) {
        this.ltp = ltp;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getChange_percent() {
        return change_percent;
    }

    public void setChange_percent(String change_percent) {
        this.change_percent = change_percent;
    }

    @Override
    public String toString() {
        return  tradeName + " " + ltp + " " + change + " " + change_percent;
    }

}
