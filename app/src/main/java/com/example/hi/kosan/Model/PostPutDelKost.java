package com.example.hi.kosan.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hi on 29/11/2017.
 */

public class PostPutDelKost {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Kost mKost;
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
    public Kost getKost() {
        return mKost;
    }
    public void setKost (Kost Kost) {
        mKost = Kost;
    }
}
