package com.example.fitnessapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class BottomSheetFragment extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_layout, container, false);

        Button logFoodButton = view.findViewById(R.id.log_food_button);
        Button trackSleepButton = view.findViewById(R.id.track_sleep_button);
        Button trackWeightButton = view.findViewById(R.id.track_weight_button);

        logFoodButton.setOnClickListener(v -> {
            // Handle log food action
            dismiss(); // Close bottom sheet
        });

        trackSleepButton.setOnClickListener(v -> {
            // Handle track sleep action
            dismiss(); // Close bottom sheet
        });

        trackWeightButton.setOnClickListener(v -> {
            // Handle track weight action
            dismiss(); // Close bottom sheet
        });

        return view;
    }
}
