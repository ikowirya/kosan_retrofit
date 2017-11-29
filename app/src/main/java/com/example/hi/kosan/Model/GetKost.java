package com.example.hi.kosan.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Hi on 29/11/2017.
 */

public class GetKost {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Kost> listDataKost;
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
    public List<Kost> getListDataKost() {
        return listDataKost;
    }
    public void setListDataKost(List<Kost> listDataKost) {
        this.listDataKost= listDataKost;
    }
}
