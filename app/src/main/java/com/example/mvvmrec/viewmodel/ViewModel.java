package com.example.mvvmrec.viewmodel;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmrec.Model.Model;
import com.example.mvvmrec.Repository.user_list_model.Repository_Users;
import com.example.mvvmrec.View.Adapter;

import java.util.ArrayList;

public class ViewModel extends BaseObservable {
    String name;
    String family;
    String number;
    int age;
    String height;
    String job;
    Context context;
    ArrayList<ViewModel> arrayList=new ArrayList<>();
    MutableLiveData<ArrayList<ViewModel>> mutableLiveData=new MutableLiveData<>();

    public MutableLiveData<ArrayList<ViewModel>> getMutableLiveData() {
        return mutableLiveData;
    }


    public ViewModel(Context context) {
        this.context = context;
        Toast.makeText(context, "tesssss", Toast.LENGTH_SHORT).show();
        Repository_Users repository_users=new Repository_Users();
        repository_users.getusers();
        repository_users.getMutableLiveData().observe((LifecycleOwner) context, new Observer<ArrayList<Model>>() {
            @Override
            public void onChanged(ArrayList<Model> models) { 
                for (int i=0;i<models.size();i++){
                    ViewModel viewModel=new ViewModel(models.get(i));
                    arrayList.add(viewModel) ;
                    Log.i("645123333",viewModel.getFamily()+"          "+arrayList.get(i));
                }
                mutableLiveData.setValue(arrayList);
            }
        });

    }

    @BindingAdapter("Bind:Adapter")
    public static void Binding(final RecyclerView recyclerView, MutableLiveData<ArrayList<ViewModel>> mutableLiveData){
        mutableLiveData.observe((LifecycleOwner) recyclerView.getContext(), new Observer<ArrayList<ViewModel>>() {
            @Override
            public void onChanged(ArrayList<ViewModel> viewModels) {
                Adapter adapter=new Adapter(viewModels);
recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(),LinearLayoutManager.VERTICAL,false));
recyclerView.setAdapter(adapter);

            }
        });
    }

    public ViewModel(Model model) {
        this.name = model.getName();
        this.family = model.getFamily();
        this.number = model.getNumber();
        this.age = model.getAge();
        this.height = model.getHeight();
        this.job = model.getJob();
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
