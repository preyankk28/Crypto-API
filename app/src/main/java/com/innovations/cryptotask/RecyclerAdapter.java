package com.innovations.cryptotask;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.myViewHolder> {
    ArrayList<CryptoModel> arrayList;
    Context context;
    IntentData intentData;


    public RecyclerAdapter(ArrayList<CryptoModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cryptorecycler, parent, false);
        return new RecyclerAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull myViewHolder holder, int position) {
        holder.symbol.setText(arrayList.get(position).getSymbol());
        holder.rank.setText(arrayList.get(position).getRank());
        holder.name.setText(arrayList.get(position).getName());
        holder.changepercentinlast24.setText(arrayList.get(position).getChangePercent24Hr());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentData = new IntentData();
                intentData.setName(arrayList.get(position).getName());
                intentData.setRank(arrayList.get(position).getRank());
                intentData.setChangepercentinlast24(arrayList.get(position).getChangePercent24Hr());
                intentData.setSymbol(arrayList.get(position).getSymbol());
                intentData.setId(arrayList.get(position).getId());
                Intent intent = new Intent(context, MainActivity2.class);
                intent.putExtra("intentdata", (Parcelable) intentData);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView symbol, rank , name , changepercentinlast24;
        LinearLayout linearLayout;


        public myViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            symbol = itemView.findViewById(R.id.symbol);
            rank = itemView.findViewById(R.id.rank);
            name = itemView.findViewById(R.id.priceusd);
            changepercentinlast24 = itemView.findViewById(R.id.changepercent);
            linearLayout = itemView.findViewById(R.id.linear);



        }
    }
}
