package com.innovations.cryptotask;

public class ResponseModel {
    CryptoModel[]  data;
   public ResponseModel(){

   }
    public ResponseModel(CryptoModel[] data) {
        this.data = data;
    }

    public CryptoModel[] getData() {
        return data;
    }

    public void setData(CryptoModel[] data) {
        this.data = data;
    }
}
