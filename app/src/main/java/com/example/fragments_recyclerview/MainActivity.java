package com.example.fragments_recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fragments_recyclerview.adapter.CustomAdapter;
import com.example.fragments_recyclerview.fragments.FragmentA;
import com.example.fragments_recyclerview.fragments.FragmentB;
import com.example.fragments_recyclerview.model.Member;

public class MainActivity extends AppCompatActivity implements FragmentA.FragmentAListener {

    FragmentA fragmentA;
    FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        fragmentA = new FragmentA();
        fragmentB = new FragmentB();
        getSupportFragmentManager().beginTransaction().replace(R.id.container_a, fragmentA).replace(R.id.container_b, fragmentB).commit();
    }


    @Override
    public void sendToFragmentB(Member member) {
        fragmentB.updateText(member);
    }
}
