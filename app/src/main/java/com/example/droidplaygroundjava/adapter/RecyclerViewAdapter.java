package com.example.droidplaygroundjava.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.droidplaygroundjava.R;
import com.example.droidplaygroundjava.databinding.RowItemBinding;
import com.example.droidplaygroundjava.model.User;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<User> dataSet;
    private OnItemClickListener onItemClickListener;

    public RecyclerViewAdapter(ArrayList<User> dataSet, OnItemClickListener onItemClickListener) {
        this.dataSet = dataSet;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setTextView(dataSet.get(position));
        holder.nameTextView.setOnClickListener(view -> {
            onItemClickListener.onClickItem(position);
        });
       /* holder.itemView.setOnClickListener(view -> {
            onItemClickListener.onClickItem(dataSet.get(position));
        });*/
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  {
        private TextView nameTextView, ageTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            RowItemBinding itemBinding = RowItemBinding.bind(itemView.getRootView());
            nameTextView = itemBinding.textViewName;
            ageTextView = itemBinding.textviewAge;
        }

        public void setTextView(User user) {
            nameTextView.setText(user.getName());
            ageTextView.setText(Integer.toString(user.getAge()));
        }
    }

    public interface OnItemClickListener {
        void onClickItem(int position);
    }
}
