package com.example.mvvmrec.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.mvvmrec.R;
import com.example.mvvmrec.viewmodel.ViewModel;
import com.example.mvvmrec.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);
        ActivityMainBinding activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        ViewModel viewModel=new ViewModel(this);
        activityMainBinding.setViewModel(viewModel);

    }
}
