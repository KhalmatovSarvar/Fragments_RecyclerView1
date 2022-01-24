package com.example.fragments_recyclerview.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragments_recyclerview.MainActivity;
import com.example.fragments_recyclerview.R;
import com.example.fragments_recyclerview.adapter.CustomAdapter;
import com.example.fragments_recyclerview.model.Member;

import java.util.ArrayList;
import java.util.List;

public class FragmentA extends Fragment {
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a,container,false);
        recyclerView = view.findViewById(R.id.contact_list);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),1));


        List<Member> members = prepareMemberList();

        CustomAdapter adapter = new CustomAdapter((MainActivity) view.getContext(),members);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Member> prepareMemberList() {
        List<Member> members= new ArrayList<>();
        for(int i = 0; i<20; i++){
            members.add(new Member("Sarvarbek"+i,"Khalmatov"+i));
        }
        return members;
    }
    }

