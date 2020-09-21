package com.bsro.androidtestapp.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bsro.androidtestapp.R;
import com.bsro.androidtestapp.ui.fragments.FragmentOne;

public class ThirdActivity extends AppCompatActivity {

    private static final String ARG_1_KEY = "argument1Key";

    public static Intent createIntent(Context context, String argument1) {
        Intent intent = new Intent(context, ThirdActivity.class);
        intent.putExtra(ARG_1_KEY, argument1);

        return intent;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        showFirstFragment();
    }

    private void showFirstFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.container, FragmentOne.newInstance("Some argument"));
        fragmentTransaction.commit();
    }

}
