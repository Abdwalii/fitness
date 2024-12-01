package com.example.fitnessapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProgressFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.progress, container, false);

        TextView progressSummary = view.findViewById(R.id.progress_summary);
        progressSummary.setText("My Progress:\n* Weight: 50 kg\n* Height: 175 cm\n* Managed to work out 20times\n* Lost 5kg \n* Managed to eat healthy");

        return view;
    }
}
