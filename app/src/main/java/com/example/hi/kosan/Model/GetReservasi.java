package com.example.hi.kosan.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Hi on 05/12/2017.
 */

public class GetReservasi {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Reservasi> listDataReservasi;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Reservasi> getListDataReservasi() {
        return listDataReservasi;
    }

    public void setListDataReservasi(List<Reservasi> listDataReservasi) {
        this.listDataReservasi = listDataReservasi;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
