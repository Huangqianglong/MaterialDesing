package com.example.meterialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startCoordinatorLayoutAct(View view) {
        startActivity(new Intent(this, CoordinatorLayoutAct.class));
    }

    public void startCollapsingToolbarLayoutAct(View view) {
        startActivity(new Intent(this, CollapsingToolbarLayoutAct.class));
    }

    public void startFloatingActionButtonAct(View view) {
        startActivity(new Intent(this, FloatingActionButtonAct.class));
    }

    public void startNavigationViewAct(View view) {
        startActivity(new Intent(this, NavigationViewAct.class));
    }

}
