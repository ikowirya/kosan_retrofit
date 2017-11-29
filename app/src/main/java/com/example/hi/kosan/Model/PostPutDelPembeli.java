package com.example.hi.kosan.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hi on 28/11/2017.
 */

public class PostPutDelPembeli {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Pembeli mPembeli;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Pembeli getPembeli() {
        return mPembeli;
    }
    public void setPembeli(Pembeli Pembeli) {
        mPembeli = Pembeli;
    }
}
