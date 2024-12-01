package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set up the drawer layout
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this::onOptionsItemSelected);

        // Set up the ActionBarDrawerToggle for hamburger icon to open/close the drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Set up the Bottom Navigation Bar and handle navigation item clicks
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null; // Initialize selectedFragment

                // Check each menu item using if statements
                if (item.getItemId() == R.id.nav_home) {
                    selectedFragment = new HomeFragment();
                } else if (item.getItemId() == R.id.nav_workouts) {
                    selectedFragment = new WorkoutFragment();
                } else if (item.getItemId() == R.id.nav_progress) {
                    selectedFragment = new ProgressFragment();
                }

                // Replace the fragment if a valid one is selected
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, selectedFragment)
                            .commit();
                }

                return true;
            }


        });

        // Set the default fragment to Home
        if (savedInstanceState == null) {
            bottomNavigationView.setSelectedItemId(R.id.nav_home);
}
}


    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    // Handle navigation item selection
    private boolean onoptionsItemSelected(@NonNull MenuItem item) {
        

        int itemId = item.getItemId();
        Log.d("NavItem", "Clicked item: " + itemId);
        // Handle each menu item click
        if (itemId == R.id.profile) {
            // Open Profile Activity
            Intent profileIntent = new Intent(MainActivity.this, Profile.class);
            startActivity(profileIntent);
        } else if (itemId == R.id.settings) {
            // Open Settings Activity
            Intent settingsIntent = new Intent(MainActivity.this, Settings.class);
            startActivity(settingsIntent);
        } else if (itemId == R.id.workout_list) {
            // Load WorkoutsFragment
            loadFragment(new WorkoutFragment());
        } else if (itemId == R.id.nav_progress) {
            // Load ProgressFragment
            loadFragment(new ProgressFragment());
        }

        // Close the navigation drawer
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        // Close the navigation drawer if it's open
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.notification) {
            // Handle notifications action
            Intent notificationIntent = new Intent(MainActivity.this, NotificationActivity.class);
            startActivity(notificationIntent);
            return true;
        } else if (id == R.id.help) {
            // Handle help action
            Intent helpIntent = new Intent(MainActivity.this, HelpActivity.class);
            startActivity(helpIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
