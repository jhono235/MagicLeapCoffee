package com.example.magicleapcoffee;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.magicleapcoffee.activities.DetailActivity;
import com.example.magicleapcoffee.data.Coffee;

import java.util.ArrayList;

public class CoffeeRvAdapter extends RecyclerView.Adapter<CoffeeRvAdapter.ViewHolder> {

    private ArrayList<Coffee> coffeeList;
    private Context context;
    private ItemClickListener itemClickListener;

    public interface ItemClickListener{
        void onItemClicked(Coffee coffee);
    }



    public CoffeeRvAdapter(ArrayList<Coffee> coffeeList, Context context) {
        this.coffeeList = coffeeList;
        this.context = context;

    }

    public Coffee coffee;
    @NonNull
    @Override
    public CoffeeRvAdapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.coffee_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position) {
         coffee = coffeeList.get(position);
        holder.tvCoffeeName.setText(coffee.getName());
        holder.tvCoffeeDescription.setText(coffee.getDesc());

        Glide
                .with(holder.itemView)
                .load(coffee.getImageUrl())
                .into(holder.imgCoffeeImage);


    }

    @Override
    public int getItemCount() {
        return coffeeList.size();
    }

    public void setData(ArrayList<Coffee> coffees){
        this.coffeeList = coffees;
        notifyDataSetChanged();


    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCoffeeName;
        TextView tvCoffeeDescription;
        ImageView imgCoffeeImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCoffeeName = itemView.findViewById(R.id.tvCoffeeNameList);
            tvCoffeeDescription = itemView.findViewById(R.id.tvCoffeeDescriptionList);
            imgCoffeeImage = itemView.findViewById(R.id.ivCoffeePic);

            itemView.setOnClickListener(
                    new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), DetailActivity.class);
                    intent.putExtra("passedId", coffeeList.get(getAdapterPosition()).getId());
                    view.getContext().startActivity(intent);



                }
            });
        }
    }


}
