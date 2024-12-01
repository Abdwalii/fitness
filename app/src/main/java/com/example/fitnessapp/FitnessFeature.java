package com.example.fitnessapp;

public class FitnessFeature {
    private String featureName;
    private int iconResourceId;

    public FitnessFeature(String featureName, int iconResourceId) {
        this.featureName = featureName;
        this.iconResourceId = iconResourceId;
    }

    public String getFeatureName() {
        return featureName;
    }

    public int getIconResourceId() {
        return iconResourceId;
    }
}
