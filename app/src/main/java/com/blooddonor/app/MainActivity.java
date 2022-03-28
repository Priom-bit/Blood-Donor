package com.blooddonor.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.blooddonor.app.databinding.ActivityMainBinding;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.RoundedCornerTreatment;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;
    static NavController navController;
    static BottomAppBar bottomAppBar;
    static FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // try block to hide Action bar
        try {
            this.getSupportActionBar().hide();
        }
        // catch block to handle NullPointerException
        catch (NullPointerException e) {
        }

        mainBinding.bottomNavigationView.setBackground(null);
        bottomAppBar = mainBinding.bottomAppBar;
        floatingActionButton = mainBinding.btnMotorHome;

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_seekers, R.id.navigation_profile, R.id.navigation_menu)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(mainBinding.bottomNavigationView, navController);

    }


    /**
     * Hide bottom Navigation
     */
    public static void hideBottomNav() {
        bottomAppBar.setVisibility(View.GONE);
        floatingActionButton.setVisibility(View.GONE);
    }

    /**
     * Show bottom Navigation
     */
    public static void showBottomNav() {
        bottomAppBar.setVisibility(View.VISIBLE);
        floatingActionButton.setVisibility(View.VISIBLE);
    }
}