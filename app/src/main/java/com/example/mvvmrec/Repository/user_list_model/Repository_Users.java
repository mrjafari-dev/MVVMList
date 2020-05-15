package com.example.mvvmrec.Repository.user_list_model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmrec.Model.Model;
import com.example.mvvmrec.Repository.Api_Service;
import com.example.mvvmrec.Repository.Retrofit_Class;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository_Users {
    public Repository_Users(){

    }
    MutableLiveData<ArrayList<Model>> mutableLiveData=new MutableLiveData<>();

    public MutableLiveData<ArrayList<Model>> getMutableLiveData() {
        return mutableLiveData;
    }

    ArrayList<Model> arrayList=new ArrayList<>();
    public void getusers(){
        Api_Service api_service= Retrofit_Class.getApiServie();
        Call<Model_User> call=api_service.getuserlist();
        call.enqueue(new Callback<Model_User>() {
            @Override
            public void onResponse(Call<Model_User> call, Response<Model_User> response) {
                Log.i("1234567890",response.body().toString());
                for (int i=0;i<response.body().getArrayList().size();i++){
                    arrayList.add(response.body().getArrayList().get(i));
                    Log.i("645123333",response.body().getMessage()+"");
                }
                mutableLiveData.setValue(arrayList);
            }

            @Override
            public void onFailure(Call<Model_User> call, Throwable t) {
                Log.i("1234567890",t.toString());
            }
        });
    }
}
