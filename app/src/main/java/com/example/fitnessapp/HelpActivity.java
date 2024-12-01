package com.example.fitnessapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);

        Button contactSupportButton = findViewById(R.id.contact_support_button);
        contactSupportButton.setOnClickListener(v -> {
            // Handle contact support action
            Toast.makeText(HelpActivity.this, "FAQ", Toast.LENGTH_SHORT).show();
        });
    }
}
