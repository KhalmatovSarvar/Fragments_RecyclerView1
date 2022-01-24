package com.example.fragments_recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragments_recyclerview.MainActivity;
import com.example.fragments_recyclerview.R;
import com.example.fragments_recyclerview.fragments.FragmentA;
import com.example.fragments_recyclerview.model.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    FragmentA fragmentA;
    List<Member> members;

    public CustomAdapter(FragmentA fragmentA, List<Member> members) {
        this.fragmentA = fragmentA;
        this.members = members;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            Member member = members.get(position);

            if(holder instanceof CustomViewHolder){
            LinearLayout lay_click = ((CustomViewHolder) holder).linearLayout;
            TextView name = ((CustomViewHolder)holder).name;
            TextView phone = ((CustomViewHolder)holder).phone;

            name.setText(member.getName());
            phone.setText(member.getPhoneNumber());

            lay_click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    fragmentA.clickContactItem(member);
                }
            });
            }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView name,phone;
        LinearLayout linearLayout;
        View view;
        public CustomViewHolder(View v) {
            super(v);
            view = v;
        linearLayout = view.findViewById(R.id.lay_click);
        name = view.findViewById(R.id.tv_name);
        phone = view.findViewById(R.id.tv_phone_number);

        }
    }



}
