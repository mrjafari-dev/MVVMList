package com.example.mvvmrec.Repository.user_list_model;

import com.example.mvvmrec.Model.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Model_User {
    @SerializedName("status")
            @Expose
    int status;
    @SerializedName("message")
     @Expose
    String message;
    @SerializedName("data")
    @Expose
    ArrayList<Model> arrayList=new ArrayList<>();

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Model> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Model> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public String toString() {
        return "Model_User{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", arrayList=" + arrayList +
                '}';
    }
}
