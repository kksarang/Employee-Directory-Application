package com.example.whiterabbit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.whiterabbit.API.ModelClass;
import com.example.whiterabbit.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>

   {
       private ArrayList<ModelClass> modelArrayList;
       private Context context;

       public MyAdapter(ArrayList<ModelClass> modelArrayList, Context context) {
           this.modelArrayList = modelArrayList;
           this.context = context;
       }

       @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           View view = LayoutInflater.from(parent.getContext())
                   .inflate(R.layout.firstrecycler_iteam_showing, parent, false);
           return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ModelClass model = modelArrayList.get(position);

        holder.name.setText("Employ Name : " + model.getName());
        holder.company.setText("Company Name : " + model.getCompanyName());


        Glide.with(context)
                .load(model.getImage())
                .into(holder.img);



    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, company;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.person_name);
            company=itemView.findViewById(R.id.company_name);
            img=itemView.findViewById(R.id.person_image);


        }
    }
}
