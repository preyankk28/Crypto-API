package com.innovations.cryptotask;

public class HistoryLinegraphResponseModel {
    String priceUsd;
    String time;
    String date;

    public  HistoryLinegraphResponseModel(){

    }
    public HistoryLinegraphResponseModel(String priceUsd, String time, String date) {
        this.priceUsd = priceUsd;
        this.time = time;
        this.date = date;
    }

    public String getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
