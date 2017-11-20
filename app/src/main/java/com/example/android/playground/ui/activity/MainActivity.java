package com.example.android.playground.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.playground.R;
import com.example.android.playground.ui.activity.fragment.PopularFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new PopularFragment())
                    .commit();
        }

    }

}
