package com.example.fitnessapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WorkoutFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.workout, container, false);

        TextView workoutList = view.findViewById(R.id.workout_list);
        workoutList.setText("Available Workouts:\n- Full Body Workout\n- Cardio workout\n- Yoga \n- Aerobic dances");

        return view;
    }
}
