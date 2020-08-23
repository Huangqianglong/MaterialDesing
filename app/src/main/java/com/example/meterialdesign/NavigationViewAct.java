package com.example.meterialdesign;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class NavigationViewAct extends BaseAct {
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_navigationview);
        mDrawerLayout = findViewById(R.id.DrawerLayout);
        mNavigationView = findViewById(R.id.nav_view);
        mNavigationView.setItemTextColor(null);
        mNavigationView.setItemIconTintList(null);
        mNavigationView.setNavigationItemSelectedListener(selectedListener);
    }

    @Override
    protected void initList() {

    }

    NavigationView.OnNavigationItemSelectedListener selectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Log.d("hql", "点击menu" + menuItem.getItemId());
            mDrawerLayout.closeDrawers();
            return true;
        }
    };
}
