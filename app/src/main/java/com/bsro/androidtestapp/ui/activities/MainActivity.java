package com.bsro.androidtestapp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bsro.androidtestapp.R;

public class MainActivity extends AppCompatActivity {

    private Button goToSecondActivityButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToSecondActivityButton = findViewById(R.id.goToSecondButton);
        goToSecondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchSecondActivity();
            }
        });
    }

    private void launchSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        //We could add arguments here
        startActivity(intent);
    }

    public void launchThirdActivity(View view) {
        startActivity(
                ThirdActivity.createIntent(this, "This is argument 1")
        );
    }

}
