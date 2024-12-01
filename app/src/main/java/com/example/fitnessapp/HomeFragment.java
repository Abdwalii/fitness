package com.example.fitnessapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    @Nullable
    private BottomSheetDialog bottomSheetDialog;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);

        // TextViews for daily step count and calories burned
        TextView stepCount = view.findViewById(R.id.daily_steps);
        TextView caloriesBurned = view.findViewById(R.id.calories_burned);

        // Set data for the CardView (step count and calories burned)
        stepCount.setText("Steps: 8,500");
        caloriesBurned.setText("Calories: 320");

        // RecyclerView for horizontal scrollable cards
        RecyclerView fitnessFeaturesRecycler = view.findViewById(R.id.features_recycler_view);
        fitnessFeaturesRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        // Adapter for the fitness features
        FitnessFeaturesAdapter adapter = new FitnessFeaturesAdapter(getFitnessFeatures());
        fitnessFeaturesRecycler.setAdapter(adapter);

        // Initialize the Bottom Sheet Dialog
        setupBottomSheet(view);

        // Button to open the Bottom Sheet
        Button openBottomSheetButton = view.findViewById(R.id.open_bottom_sheet_button);
        openBottomSheetButton.setOnClickListener(v -> bottomSheetDialog.show());

        return view;
    }

    // Setup the Bottom Sheet Dialog
    private void setupBottomSheet(View view) {
        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_layout, null);
        bottomSheetDialog = new BottomSheetDialog(requireContext());
        bottomSheetDialog.setContentView(bottomSheetView);

        // Set up your bottom sheet actions here, e.g., logging food
        Button logFoodButton = bottomSheetView.findViewById(R.id.log_food_button);
        logFoodButton.setOnClickListener(v -> {
            // Implement log food functionality
            bottomSheetDialog.dismiss();
        });
    }

    // Method to provide data for the fitness features section
    private List<FitnessFeature> getFitnessFeatures() {
        List<FitnessFeature> features = new ArrayList<>();
        features.add(new FitnessFeature("Start a Workout", R.drawable.baseline_sports_24));
        features.add(new FitnessFeature("Track Sleep", R.drawable.baseline_hotel_24));
        features.add(new FitnessFeature("Water Intake", R.drawable.baseline_water_drop_24));
        features.add(new FitnessFeature("Healthy eating", R.drawable.baseline_fastfood_24));
        return features;
    }
}
