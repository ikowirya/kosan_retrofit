package com.example.hi.kosan.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hi on 05/12/2017.
 */

public class PostPutDelKostReservasi {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Reservasi mReservasi;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Reservasi getmReservasi() {
        return mReservasi;
    }

    public void setmReservasi(Reservasi mReservasi) {
        this.mReservasi = mReservasi;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
