package com.example.mvvmrec.Repository;

import com.example.mvvmrec.Repository.user_list_model.Model_User;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api_Service {
    @GET("json.html")
    Call<Model_User> getuserlist();
}
