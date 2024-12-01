package com.example.fitnessapp;

import android.os.Bundle;
import android.provider.Settings;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

class activity_settings extends AppCompatActivity {

    private CheckBox notificationsCheckbox;
    private CheckBox soundCheckbox;
    private Button saveSettingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);  // Make sure your XML file is named activity_settings.xml

        // Initialize views
        notificationsCheckbox = findViewById(R.id.notifications_checkbox);
        soundCheckbox = findViewById(R.id.sound_checkbox);
        saveSettingsButton = findViewById(R.id.save_settings_button);

        // Set onClick listener for the save button
        saveSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Settings saved:\n";
                message += "Popup message: " + (notificationsCheckbox.isChecked() ? "Enabled" : "Disabled") + "\n";
                message += "Reminders: " + (soundCheckbox.isChecked() ? "Enabled" : "Disabled");

                // Display the settings in a Toast message
                Toast.makeText(activity_settings.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
