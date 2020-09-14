package com.bsro.androidtestapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bsro.androidtestapp.R;

public class FragmentOne extends Fragment {

    private static final String ARG_1_KEY = "fragmentArg1";

    private Button goToFragmentTwoButton;
    private Button buttonSetName;
    private EditText editTextNameInput;
    private TextView textViewNameLabel;

    public static Fragment newInstance(String argument) {
        Bundle arguments = new Bundle();
        arguments.putString(ARG_1_KEY, argument);

        Fragment fragment = new FragmentOne();
        fragment.setArguments(arguments);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        goToFragmentTwoButton = view.findViewById(R.id.goToFragmentTwoButton);
        goToFragmentTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        buttonSetName = view.findViewById(R.id.buttonSetName);
        editTextNameInput = view.findViewById(R.id.editTextName);
        textViewNameLabel = view.findViewById(R.id.textViewTitle);

        buttonSetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editTextNameInput.getText().toString();
                textViewNameLabel.setText(input);
            }
        });

        Bundle args = getArguments();
        if (args != null) {
            textViewNameLabel.setText(
                    getArguments().getString("userId")
            );
        }
    }
}
