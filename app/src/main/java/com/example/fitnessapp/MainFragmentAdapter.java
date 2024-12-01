package com.example.fitnessapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MainFragmentAdapter extends FragmentStateAdapter {

    public MainFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment(); // Your HomeFragment class
            case 1:
                return new WorkoutFragment(); // Your WorkoutsFragment class
            case 2:
                return new ProgressFragment(); // Your ProgressFragment class
            default:
                return new HomeFragment(); // Default case
        }
    }

    @Override
    public int getItemCount() {
        return 3; // Number of tabs
    }
}
