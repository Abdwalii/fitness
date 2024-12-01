package com.example.fitnessapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NotificationActivity extends AppCompatActivity {

    private ListView notificationsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        notificationsList = findViewById(R.id.notifications_list);

        // Example notifications
        String[] notifications = {
                "Workout in the morning",
                "Eat Healthy",
                "New Gym outfit",

        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, notifications);
        notificationsList.setAdapter(adapter);
    }
}
