package com.example.flickster.Adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MoviesAdapter {

    class viewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
