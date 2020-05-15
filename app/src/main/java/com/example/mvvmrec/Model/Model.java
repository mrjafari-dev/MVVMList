package com.example.mvvmrec.Model;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("name")
            @Expose
    String name;
    @SerializedName("family")
            @Expose
    String family;
    @SerializedName("number")
    @Expose
    String number;
    @SerializedName("age")
    @Expose
    int age;
    @SerializedName("height")
    @Expose
    String height;
    @SerializedName("job")
    @Expose
    String job;



    public Model(String name, String family, String number, int age, String height, String job) {
        this.name = name;
        this.family = family;
        this.number = number;
        this.age = age;
        this.height = height;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
