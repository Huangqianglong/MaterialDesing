package com.example.meterialdesign;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BaseAct extends Activity {
    RecyclerView mListView;
    TestAdaper mAdaper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.layout_collapsingtoolbar);
    }

    protected void initList() {
        mListView = findViewById(R.id.rv_list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mListView.setLayoutManager(manager);
        mAdaper = new TestAdaper(this);
        mListView.setAdapter(mAdaper);

        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            String posion = "这是position" + i;
            data.add(posion);

        }
        mAdaper.updateList(data);


    }
}
