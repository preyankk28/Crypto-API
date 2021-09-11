package com.innovations.cryptotask;

public class HistoryGrapghMainResponse {
    HistoryLinegraphResponseModel[]  data;
    public HistoryGrapghMainResponse(){

    }
    public HistoryGrapghMainResponse(HistoryLinegraphResponseModel[] data) {
        this.data = data;
    }

    public HistoryLinegraphResponseModel[] getData() {
        return data;
    }

    public void setData(HistoryLinegraphResponseModel[] data) {
        this.data = data;
    }
}
