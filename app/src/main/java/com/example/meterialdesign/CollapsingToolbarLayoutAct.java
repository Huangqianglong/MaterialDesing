package com.example.meterialdesign;

import android.os.Bundle;

import androidx.annotation.Nullable;

public class CollapsingToolbarLayoutAct extends BaseAct {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_collapsingtoolbar);
        initList();
    }
}
