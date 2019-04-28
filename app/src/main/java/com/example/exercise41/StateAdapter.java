package com.example.exercise41;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder> {

    private ArrayList<State> mStates;
    final private OnListItemClickListener mOnListItemClickListener;

    StateAdapter(ArrayList<State> states, OnListItemClickListener listener) {
        mStates = states;
        mOnListItemClickListener = listener;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.state_list_item, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.name.setText(mStates.get(position).getName());
        viewHolder.abbreviation.setText(mStates.get(position).getAbbreviation());
    }

    public int getItemCount() {
        return mStates.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        TextView abbreviation;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            abbreviation = itemView.findViewById(R.id.tv_abbreviation);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnListItemClickListener.onListItemClick(getAdapterPosition());
        }
    }

    public interface OnListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}
