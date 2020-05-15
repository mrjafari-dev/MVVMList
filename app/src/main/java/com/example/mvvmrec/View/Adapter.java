package com.example.mvvmrec.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmrec.R;
import com.example.mvvmrec.databinding.ItemView;
import com.example.mvvmrec.viewmodel.ViewModel;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Adaper_ViewHoldr> {
        ArrayList<ViewModel> arrayList=new ArrayList<>();
        LayoutInflater layoutInflater;

    public Adapter(ArrayList<ViewModel> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Adaper_ViewHoldr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater=LayoutInflater.from(parent.getContext());

        }
        ItemView itemView= DataBindingUtil.inflate(layoutInflater, R.layout.recitem,parent,false);

        return new Adaper_ViewHoldr(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaper_ViewHoldr holder, int position) {
ViewModel viewModel=arrayList.get(position);
holder.binding(viewModel);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class Adaper_ViewHoldr extends RecyclerView.ViewHolder{
            ItemView itemView;
        public Adaper_ViewHoldr(ItemView itemView) {
            super(itemView.getRoot());
            this.itemView=itemView;
        }

        private void binding(ViewModel viewModel){
        itemView.setViewModel(viewModel);
        itemView.executePendingBindings();
        }
    }
}
