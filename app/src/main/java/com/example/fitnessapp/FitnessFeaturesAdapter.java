package com.example.fitnessapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

class FitnessFeaturesAdapter extends RecyclerView.Adapter<FitnessFeaturesAdapter.FitnessFeatureViewHolder> {

    private List<FitnessFeature> fitnessFeatures;

    public FitnessFeaturesAdapter(List<FitnessFeature> fitnessFeatures) {
        this.fitnessFeatures = fitnessFeatures;
    }

    @NonNull
    @Override
    public FitnessFeatureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_fitness_feature, parent, false);
        return new FitnessFeatureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FitnessFeatureViewHolder holder, int position) {
        FitnessFeature feature = fitnessFeatures.get(position);
        holder.featureName.setText(feature.getFeatureName());
        holder.icon.setImageResource(feature.getIconResourceId());
    }

    @Override
    public int getItemCount() {
        return fitnessFeatures.size();
    }

    // ViewHolder class for the RecyclerView
    public static class FitnessFeatureViewHolder extends RecyclerView.ViewHolder {
        TextView featureName;
        ImageView icon;

        public FitnessFeatureViewHolder(@NonNull View itemView) {
            super(itemView);
            featureName = itemView.findViewById(R.id.feature_name);
            icon = itemView.findViewById(R.id.feature_icon);
        }
    }
}
