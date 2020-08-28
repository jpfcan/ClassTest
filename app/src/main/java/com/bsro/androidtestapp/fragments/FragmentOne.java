package com.bsro.androidtestapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import com.bsro.androidtestapp.R;

public class FragmentOne extends Fragment {

    private static final String ARG_1_KEY = "fragmentArg1";

    private Button goToFragmentTwoButton;
    private Button goToFragmentTwoNavigationButton;

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
                if (getActivity() != null) {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    fragmentTransaction.replace(R.id.container, FragmentTwo.newInstance("Some argument"));
                    fragmentTransaction.commit();
                }
            }
        });

        goToFragmentTwoNavigationButton = view.findViewById(R.id.goToFragmentTwoButtonAction);
        goToFragmentTwoNavigationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_fragment_one_to_fragment_two);
            }
        });
    }
}
