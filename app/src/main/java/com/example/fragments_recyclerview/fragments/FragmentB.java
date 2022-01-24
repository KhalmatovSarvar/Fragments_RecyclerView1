package com.example.fragments_recyclerview.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragments_recyclerview.R;
import com.example.fragments_recyclerview.model.Member;

public class FragmentB extends Fragment {

    private TextView contact_name,contact_phone;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b,container,false);
        contact_name = view.findViewById(R.id.contact_name);
        contact_phone = view.findViewById(R.id.contact_phone_number);
        return view;
    }



    public void updateText(Member member){

        contact_name.setText(member.getName());
        contact_phone.setText(member.getPhoneNumber());
    }
}

